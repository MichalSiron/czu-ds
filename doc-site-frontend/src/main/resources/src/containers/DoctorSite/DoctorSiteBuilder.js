import React, { Component } from 'react';
import { Route, Redirect } from 'react-router-dom';

import Doctors from '../../components/Model/Doctors/Doctors';
import Login from '../Login/Login';

class DoctorSiteBuilder extends Component {

    render() {

        return (
            <div>
                <Route path="/" exact component={Doctors}/>
                <Route path="/login" component={Login}/>
            </div>
        );
    }

}

export default DoctorSiteBuilder;