import React from "react";
import Background from "../pictures/index_image.jpg";


function HomePage() {
    return (<div style={Style}>
        <img src= {Background}></img>
    </div>)

    {/*
        <div style={{ backgroundImage: 'url(${Background})' }}>
        </div>
    );
    */}
}

export default HomePage;

const Style = {
    width : '100%',
    height: '100%'
}