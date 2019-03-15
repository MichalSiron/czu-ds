import React, { Component } from 'react';
import { Route } from 'react-router-dom';

import Doctors from '../../components/Model/Doctors/Doctors';
import Login from '../Login/Login';
import Patients from '../../components/Model/Patient/Patients';

class DoctorSiteBuilder extends Component {

    render() {

        return (
            <div>
                <Route path="/" exact component={Doctors}/>
                <Route path="/login" component={Login}/>
                <Route path="/patients" component={Patients}/>
            </div>
        );
    }

}

export default DoctorSiteBuilder;