import PhoneItem from "./PhoneItem";

function PhoneList(props) {
  return (
    <ul>
      {props.phones.map((phone) => (
        <PhoneItem
          key={phone.id}
          id={phone.id}
          image={phone.image}
          title={phone.productName}
          ar={phone.ar}
        />
      ))}
    </ul>
  );
}

export default PhoneList;
