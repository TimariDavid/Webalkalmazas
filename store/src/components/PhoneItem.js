import Card from "./ui/Card";
import Picture from "../pictures/iphone-12.jpg"

function PhoneItem(props) {
  return (
    <Card>
      <li style={liSize}>
          <div style={item}>
            <div>
              <h3>{props.title}</h3>
            </div>
            <div>
              <img style={pictureSize} src={Picture} alt={props.title} />
              {props.ar}
            </div>
            <div>
              <button>Buy</button>
            </div>
          </div>
      </li>
    </Card>
  );
}

export default PhoneItem;

const item = {
  width: '300px',
  height: '300px',
  'border-radius': '5px',
  'box-shadow': '3px 3px 5px lightgray',
  'background-color': 'white',
  'margin-right': '1cm',
  'margin-left': '1cm',
  'margin-bottom': '1cm',
}

const pictureSize = {
  width: '60%'
}

const liSize = {
  width: '30%',
  'list-style-type': 'none'
}


