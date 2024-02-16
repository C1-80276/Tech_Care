import { useState } from "react";
import { Link, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";
import { registerUser as registerUserApi } from "../services/user";

function RegisterUser() {
  const [name, setName] = useState("");
  const [address, setAddress] = useState("");
  const [email, setEmail] = useState("");
  const [contactNo, setContactNo] = useState("");
  const [password, setPassword] = useState("");
  const [bloodGroup, setBloodGroup] = useState("");
  const [role, setRole] = useState("USER");
  const [weight, setWeight] = useState(0);
  const [height, setHeight] = useState(0);
  const [dob, setDob] = useState("");
  const [gender, setGender] = useState("");
  const [city, setCity] = useState("");
  const navigate = useNavigate();
  const registerUser = async () => {
    if (name.length === 0) {
      toast.error("Please enter first name");
    } else if (address.length === 0) {
      toast.error("Please enter address");
    } else if (!email.match(/^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/)) {
      toast.error("Invalid email format");
    } else if (email.length === 0) {
      toast.error("Please enter email");
    } else if (contactNo.length === 0) {
      toast.error("Please enter mobile");
    } else if (!password.match(/^(?=.*\d)(?=.*[a-z])(?=.*[#@$*]).{5,20}$/)) {
      toast.error("Invalid password format");
    } else if (password.length === 0) {
      toast.error("Please enter password");
    } else if (city.length === 0) {
      toast.error("Please enter city");
    } else if (bloodGroup.length === 0) {
      toast.error("Please select blood group");
    } else if (gender.length === 0) {
      toast.error("Please select gender");
    } else {
      // call register api
      const response = await registerUserApi(
        name,
        email,
        password,
        contactNo,
        bloodGroup,
        address,
        role,
        weight,
        height,
        dob,
        gender,
        city
      );
      console.log(response);
      // parse the response
      if (response && response.email === "") {
        toast.info("Registration with this email is already done.");
      } else if (response && response.email) {
        toast.success("Successfully registered a new user");
        navigate("/login");
      } else {
        toast.error("Your Registration is already Done Please Log-In");
      }
    }
  };
  
  return (
    <div>
      <h1 style={{ textAlign: "center", margin: 10 }}>Register User</h1>

      <div className="row">
        <div className="col"></div>
        <div className="col">
          <div className="form">
            <div className="mb-3">
              <label htmlFor="">Full Name</label>
              <input
                type="text"
                className="form-control"
                onChange={(e) => {
                  setName(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Email</label>
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
              <label htmlFor="">Mobile Number</label>
              <input
                type="tel"
                className="form-control"
                onChange={(e) => {
                  setContactNo(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Blood Group</label>
              <select
                className="form-control"
                onChange={(e) => {
                  setBloodGroup(e.target.value);
                }}
              >
                <option value="A+">A+</option>
                <option value="A-">A-</option>
                <option value="B+">B+</option>
                <option value="B-">B-</option>
                <option value="AB+">AB+</option>
                <option value="AB-">AB-</option>
                <option value="O+">O+</option>
                <option value="O-">O-</option>
              </select>
            </div>

            <div className="mb-3">
              <label htmlFor="">Weight</label>
              <input
                type="number"
                className="form-control"
                onChange={(e) => {
                  setWeight(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Height</label>
              <input
                type="number"
                className="form-control"
                onChange={(e) => {
                  setHeight(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Date of Birth</label>
              <input
                type="date"
                className="form-control"
                onChange={(e) => {
                  setDob(e.target.value);
                }}
              />
            </div>

            <div className="mb-3">
              <label htmlFor="">Gender</label>
              <select
                className="form-control"
                onChange={(e) => {
                  setGender(e.target.value);
                }}
              >
                <option value="male">Male</option>
                <option value="female">Female</option>
              </select>
            </div>

            <div className="mb-3">
              <label htmlFor="">City</label>
              <select
                className="form-control"
                onChange={(e) => {
                  setCity(e.target.value);
                }}
              >
                <option value="Pune">Pune</option>
                <option value="Mumbai">Mumbai</option>
              </select>
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
              <div className="mb-3">
                Already got an account? <Link to="/login">Login here</Link>
              </div>
              <button onClick={registerUser} className="btn btn-success">
                Register
              </button>
            </div>
          </div>
        </div>
        <div className="col"></div>
      </div>
    </div>
  );
}

export default RegisterUser;
