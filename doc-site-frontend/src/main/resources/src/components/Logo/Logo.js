import React from 'react';
import doctorLogo from '../../assets/images/doctor_logo.png';
import classes from './Logo.css';


const logo = () => (
    <div className={classes.Logo}>
        <img src={doctorLogo} alt='MyDoctorSite'/>
    </div>
);

export default logo;