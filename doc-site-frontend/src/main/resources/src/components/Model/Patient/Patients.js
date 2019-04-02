import React from 'react';
import axios from '../../../axios';

const patients = () => {

    axios.get("/users/1").then(response => {
        console.log(response.data);
    }).catch(error => {
        console.log(error);
    });

    return <div>Patients</div>

};

export default patients;