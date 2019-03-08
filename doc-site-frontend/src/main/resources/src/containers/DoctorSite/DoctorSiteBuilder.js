import React, { Component } from 'react';
import { Route, Redirect } from 'react-router-dom';

import axios from '../../axios';

class DoctorSiteBuilder extends Component {

    state = {
        loadedDoctors: []
    };

    componentDidMount(){
        axios.get('/doctors')
            .then(response => {
                this.setState({
                    doctors: response.data.results
                });
                console.log(response.data);
            }).catch(error => {
            console.log(error);
        });
    }

    render() {

        return (
            <div>
                <Route path="/" exact component={Movies}/>
            </div>
        );
    }

}

export default DoctorSiteBuilder;