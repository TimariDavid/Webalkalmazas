import Card from "./ui/Card";
import Picture from "../pictures/iphone-12.jpg"

function PhoneItem(props) {
  return (
    <Card>
      <li style={liSize}>
          <div style={item}>
            <div>
              <h3 className="text-center">{props.title}</h3>
            </div>
            <div>
              <img  style={pictureSize} src={Picture} alt={props.title} />
              {props.ar}
            </div>
            <div>
              <button style={button}>Vásárol</button>
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
  borderRadius: '5px',
  boxShadow: '3px 3px 5px lightgray',
  backgroundColor: 'white',
  marginRight: '1cm',
  marginLeft: '1cm',
  marginBottom: '1cm',
}

const pictureSize = {
  width: '60%',
  display: 'block',
  marginLeft : 'auto',
  marginRight : 'auto'
}

const liSize = {
  width: '30%',
  listStyleType: 'none'
}

const button = {
  backgroundColor: '#4CAF50',
  border: 'none',
  color: 'white',
  padding: '10px 16px',
  textAlign: 'center',
  textDecoration: 'none',
  display: 'inline-block',
  fontSize: '16px',
  
  marginLeft : 'auto',
  marginRight : 'auto'
}