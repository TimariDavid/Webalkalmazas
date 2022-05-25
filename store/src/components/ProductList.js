import PhoneItem from "./ProductItem";

function PhoneList(props) {
  return (
    <ul style={ulSize}>
      {props.phones.map((phone) => (
        <PhoneItem
          key={phone.id}
          id={phone.id}
          productId ={phone.productId}
          image={phone.image}
          title={phone.productName}
          ar={phone.ar}
        />
      ))}
    </ul>
  );
}

export default PhoneList;

const ulSize = {
  overflow: 'hidden'
}