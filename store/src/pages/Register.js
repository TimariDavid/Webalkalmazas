import React, { useState, useEffect } from 'react'

function Register() {
    const [username, setUsername]=useState("");
    const [password,setPassword]=useState("");
    useEffect(() => {
    }, [])
    async function register()
    {
        console.warn(username,password)
        let item={username,password};
        let result = await fetch("http.//localhost:8080/authentication/register", {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
                "Accept": 'application/json'
            },
            body: JSON.stringify(item)
        });
    result = await result.json();
    }
    return ( 
        <div>

            <h1>Register Page</h1>
            <div className="col-sm-6 offset-sm-3">
            <input type="text" placeholder="username"
            onChange={(e)=>setUsername(e.target.value)}
             className="form-control" />
            <br />
            <input type="password" placeholder="password"
            onChange={(e)=>setPassword(e.target.value)}

            className="form-control" />
            <br />
            <bottom onClick={register} className="btn btn-primary" >Register</bottom>

            </div>
                    </div>
    )
} 

export default Register;