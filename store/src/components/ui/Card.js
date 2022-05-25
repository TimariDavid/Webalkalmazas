function Card(props) {
    return (
        <div style={divSize}>
            {props.children}
        </div>
    );
}

export default Card;

const divSize = {
    width: '30%',
    display: 'inline-block',
}