import React, { useState } from 'react'
import { Link } from 'react-router-dom';
import { toast } from 'react-toastify';
import { registerHospitalApi } from '../services/user';

const HospitalRegistration = () => {

  

    const [adminName, setAdminName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [name, setName] = useState("");
    const [address, setAddress] = useState("");
    const [city, setCity] = useState("");
    const [contactNo, setContactNo] = useState("");
    const [role, setRole] = useState(false);





    const registerHospital = () => {
        if (name.length == "") {
            toast.error("Please enter first name");
          } else if (!email.match(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/)) {
            toast.error("Invalid email format");
          } else if (email.length == "") {
            toast.error("Please enter email");
          } else if (contactNo.length == "") {
            toast.error("Please enter mobile");
          } else if (!password.match(/^(?=.*\d)(?=.*[a-z])(?=.*[#@$*]).{5,20}$/)) {
            toast.error("Invalid password format");
          } else if (password.length == "") {
            toast.error("Please enter password");
          }
          else{
            const response =  registerHospitalApi(
                adminName,
                email,
                password,
                name,
                address,
                city,
                contactNo,
                role
                );
          }
    }

  return (
    <div>
      <h1 style={{ textAlign: "center", margin: 10 }}>Register Hospital</h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">

          <div className="mb-3">
              <label htmlFor="">Admin Name</label>
              <input
                type="text"
                className="form-control"
                onChange={(e) => {
                    setAdminName(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Admin Email</label>
              <input
                type="text"
                className="form-control"
                onChange={(e) => {
                  setEmail(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Password</label>
              <input
                type="password"
                className="form-control"
                onChange={(e) => {
                  setPassword(e.target.value);
                }}
              />
            </div>



            <div className="mb-3">
              <label htmlFor="">Hospital Name</label>
              <input
                type="text"
                className="form-control"
                onChange={(e) => {
                  setName(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Contact Number</label>
              <input
                type="tel"
                className="form-control"
                onChange={(e) => {
                  setContactNo(e.target.value);
                  console.log(e.target.value)
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Address</label>
              <input
                type="text"
                className="form-control"
                onChange={(e) => {
                  setAddress(e.target.value);
                }}
              />
            </div>  

            <div className="mb-3">
              <label htmlFor="city">Choose City</label>
              <select name="city" className="form-control" onChange={(e) => {setCity(e.target.value);}}>
                <option value="pune">Pune</option>
                <option value="mumbai">Mumbai</option>  
              </select>
            </div>


            <div className="mb-3">
              <div className="mb-3">
                Already got an account? <Link to="/login">Login here</Link>
              </div>
              <button onClick={registerHospital} className="btn btn-success">
                Register
              </button>

            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  )
}

export default HospitalRegistration