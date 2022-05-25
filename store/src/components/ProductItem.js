import Card from "./ui/Card";
import Iphone11 from "../pictures/iphone_11.jpg"
import Iphone12 from "../pictures/iphone_12.jpg"
import Iphone13 from "../pictures/iphone_13.jpg"
import IphoneSe from "../pictures/iphone_se.jpg"

function ProductItem(props) {
  return (
    <Card>
      <li style={liSize}>
          <div style={item}>
            <div>
              <h3 className="text-center">{props.title}</h3>
            </div>
            <div>
                <img style={pictureSize} src={"../pictures/".concat(props.ProductId).concat(".jpg")} alt={props.ProductId} />
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

export default ProductItem;

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