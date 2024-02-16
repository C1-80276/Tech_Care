import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";

//import PatientProfile from "../components/UI/PatientProfile";

//Import a toastify to use
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

import HospitalRegistration from "../Authentication/HospitalRegistration";
import RegisterUser from "../Authentication/UserRegistration";
import Registration from "../Authentication/Registration";
import LoginUser from "../Authentication/Login";

const Routers = () => {
  return (
    <div>
      <Routes>
        <Route path="register" element={<Registration />}/>
        <Route path="/register-hosplital" element={<HospitalRegistration />}/>
        <Route path="/register-user" element={<RegisterUser />}/>
        <Route path="/login" element={<LoginUser />} />




       {/* <Route path="/" element={<Navigate to="/home" />} /> */}
        {  /*// <Route path="/home" element={<Home />} />
        // <Route path="/about" element={<About />} />
        // <Route path="/cars" element={<CarListing />} />
        // <Route path="/docs" element={<DoctorListing />} />
        // <Route path="/carDetails/:id" element={<CarDetails />} />
        // <Route path="/finance" element={<FinancePage />} />
        // <Route path="/PatientServices" element={<PatientServices />} />
        // <Route path="/test_drive" element={<TestDrivePage />} />
        // <Route path="/contact" element={<Contact />} />
        // <Route path="*" element={<NotFound />} />
        // <Route path="/login" element={<Login />} />
        // <Route path="/register" element={<RegisterUser />} />
        // <Route path="/booking/:id" element={<BookingPage />} />
        // <Route path="/book_service/:id/:name" element={<BookService />} />
        // <Route path="/admin" element={<Admin />} />
        // <Route path="/patient" element={<Patient />} />
        // <Route path="/addcar" element={<AddCar />} />
        // <Route path="/patient_profile/:id/:name" element={<PatientProfile />} />
        // <Route path="/appointment" element={<Appointment />} />

        // <Route path="/DoctorServices" element={<DoctorServices />} />
        // <Route path="/AdminServices" element={<AdminServices />} />

        // <Route path="/patientEdit/:id" element={<EditPatient />} />
        // <Route path="/patient_profile" element={<PatientProfile />} />

        // <Route path="/doctor_profile/:id/:name" element={<DoctorProfile />} />
        // <Route path="/doctorEdit/:id" element={<EditDoctor />} />
        // <Route path="/doctor_profile" element={<DoctorProfile />} />

        // <Route path="/admin_profile/:id/:name" element={<AdminProfile />} />
        // <Route path="/adminEdit/:id" element={<EditAdmin />} />
        // <Route path="/admin_profile" element={<AdminProfile />} />
        // <Route path="/allpatients/:id/:name" element={<Allpatients />} />

        // <Route path="/myappointments" element={<MyAppointment />} />
        // <Route path="/appointmentItem" element={<AppointmentItem />} />

        // <Route path="/add_doctor/:id/:name" element={<AddDoctor />} />
        // <Route path="/alldoctors/:id/:name" element={<AllDoctors />} /> */}
      </Routes>
      <ToastContainer />
    </div>
  );
};

export default Routers;
