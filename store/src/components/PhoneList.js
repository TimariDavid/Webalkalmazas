import PhoneItem from "./PhoneItem";
import classes from "./PhoneList.module.css";

function PhoneList(props) {
  return (
    <ul className={classes.list}>
      {props.phones.map((phone) => (
        <PhoneItem
          key={phone.id}
          id={phone.id}
          image={phone.image}
          title={phone.title}
          ar={phone.ar}
        />
      ))}
    </ul>
  );
}

export default PhoneList;
