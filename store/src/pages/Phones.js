import { useEffect, useState } from "react";
import PhoneList from "../components/PhoneList";

function PhonesPage() {

  const [data, setData] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetch(
      "http://localhost:8080/products"
    )
      .then((response) => {
        if (response.ok) {
          return response.json();
        }
        throw response;
      })
      .then(res => {
        setData(res);
      })
      .catch(error => {
        console.error("Error fetcing data: ", error);
        setError(error);
      })
      .finally(() => {
        setLoading(false);
      })
  },[]);

  if (loading) {
    return "loading";
  }

  if (error) {
    return "error";
  }

  return (
    <section>
      <h1>Phones</h1>
      <PhoneList phones = {data}/>
    </section>
  );
}

export default PhonesPage;