import classes from "./PhoneItem.module.css";
import Card from "./ui/Card";

function PhoneItem(props) {
  return (
    <Card>
      <li className={classes.item}>
        <div className={classes.content}>
          <h3>{props.title}</h3>
        </div>
        <div className={classes.image}>
          <img src={props.image} alt={props.title} />
          {props.ar}
        </div>
        <div className={classes.actions}>
          <button>Buy</button>
        </div>
      </li>
    </Card>
  );
}

export default PhoneItem;
