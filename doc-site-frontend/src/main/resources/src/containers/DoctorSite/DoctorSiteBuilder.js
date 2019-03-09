import React, { Component } from 'react';
import { Route, Redirect } from 'react-router-dom';

import Doctors from '../../components/Model/Doctors/Doctors';

class DoctorSiteBuilder extends Component {

    state = {
        loadedDoctors: []
    };

    render() {

        return (
            <div>
                <Route path="/" exact component={Doctors}/>
            </div>
        );
    }

}

export default DoctorSiteBuilder;