import React, { Component } from 'react';


import Doctor from './Doctor/Doctor';
import {getUserProfile} from "../../../util/APIUtils";
class Doctors extends Component {

    state = {
        doctors: [],
        isLoading: false
    };

    loadDoctorList = (username) => {
        this.setState({
            isLoading: true
        });

        getValidatedDoctorsForProfile(username)
            .then(response => {
                this.setState({
                    doctors: response,
                    isLoading: false
                });
            }).catch(error => {
            if(error.status === 404) {
                this.setState({
                    notFound: true,
                    isLoading: false
                });
            } else {
                this.setState({
                    serverError: true,
                    isLoading: false
                });
            }
        })



    };

    render() {
        const pollViews = [];

        this.state.doctors.forEach((doctor) => {
            pollViews.push(<Doctor
                key={doctor.id}
                doctor={doctor} />)
        });

        return (

            <div className="polls-container">
                {pollViews}
                {
                    !this.state.isLoading && this.state.polls.length === 0 ? (
                        <div className="no-polls-found">
                            <span>No Polls Found.</span>
                        </div>
                    ): null
                }
                {
                    !this.state.isLoading && !this.state.last ? (
                        <div className="load-more-polls">
                            <Button type="dashed" onClick={this.handleLoadMore} disabled={this.state.isLoading}>
                                <Icon type="plus" /> Load more
                            </Button>
                        </div>): null
                }
                {
                    this.state.isLoading ?
                        <LoadingIndicator />: null
                }
            </div>
        );
    }
}

export default Doctors;
