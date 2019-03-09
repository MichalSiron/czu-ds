import React, { Component } from 'react';
import axios from "../../../axios";

import Spinner from '../../UI/Spinner/Spinner';
import Doctor from './Doctor/Doctor';
import classes from './Doctors.css';

class Doctors extends Component {

    state = {
        loadingError: false,
        loadedDoctors: null
    };

    componentDidMount(){
        axios.get('/doctors')
            .then(response => {
                this.setState({
                    loadedDoctors: response.data
                });
                console.log(response.data);
                this.setState({loadingError: false})
            }).catch(error => {
                this.setState({loadingError: true});
                console.log(error);
        });
    }

    render() {
        let doctors = <Spinner/>;
        if (this.state.loadedDoctors) {
            doctors = this.state.loadedDoctors.map(doctor =>
                <Doctor
                key={doctor.id}
                id={doctor.id}
                name={doctor.person.name.first_name}
                surname={doctor.person.name.last_name}
                description={doctor.surgery.description}/>);
        }

        return (
            <div className={classes.Doctors}>
                {doctors}
            </div>
        );
    }
}

export default Doctors;
