import React from 'react'

import { Button } from 'bootstrap';
import { Card } from 'reactstrap';
import { Link } from 'react-router-dom';

const Registration = () => {
  return (
    
    <div className="row" style={{height: "100vh"}}>
      <div className="col"></div>
      <div className="col">
        <h1>Register Here</h1>

        <div className='d-flex gap-3'>
          <Link to={"/register-hosplital"}>
          <div className="card p-3 w-100" style={{width: "18rem"}}>
              <div className="card-body">
                <h3>Hospital Register</h3>
              </div>
            </div>
          </Link>

            <Link to={"/register-user"}>
            <div className="card p-3 w-100" style={{width: "18rem"}}>
              <div className="card-body">
              <h3>User Register</h3>
              </div>
            </div>
            </Link>
        </div>
      </div>
      <div className="col"></div>
    </div>
  )
}

export default Registration