import Card from "./ui/Card";
import Picture from "../pictures/iphone-12.jpg"

function PhoneItem(props) {
  return (
    <Card>
      <li>
        <div>
          <h3>{props.title}</h3>
        </div>
        <div>
         <img src={Picture} alt={props.title}/>
          {props.ar}
        </div>
        <div>
          <button>Buy</button>
        </div>
      </li>
    </Card>
  );
}

export default PhoneItem;
