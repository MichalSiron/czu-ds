import React, { Component } from 'react';

import './DoctorList.css';
import './Doctor/Doctor.css';
import { Col, Row } from 'antd';
import { getAllDoctors, getValidatedDoctorsForProfile } from "../../../util/APIUtils";
import Doctor from "./Doctor/Doctor";
import {withRouter} from "react-router-dom";

class DoctorList extends Component{

    state = {
        doctors: [],
        isLoading: false
    };

    loadDoctorList = () => {
        let promise;
        if (this.props.username){
            if(this.props.type === 'VALIDATED_DOCTORS') {
                promise = getValidatedDoctorsForProfile(this.props.username, true);
            } else if (this.props.type === 'PENDING_DOCTORS') {
                promise = getValidatedDoctorsForProfile(this.props.username, false);
            }
        } else {
            promise = getAllDoctors();
        }

        if(!promise) {
            return;
        }

        promise
            .then(response => {
                this.setState({
                    doctors: response.data
                });
                console.log(response.data);
            }).catch(error => console.log(error));
    };

    componentDidMount() {
        this.loadDoctorList();
    }

    render() {
        const docs = [];
        this.state.doctors.forEach((doctor) => {
            docs.push(
                <Col span={12}>
                    <Doctor
                        key={doctor.id}
                        username={doctor.username}
                        created={doctor.created}
                        name={doctor.name}
                        address={doctor.address}/>
                </Col>
            )
        });

        return(
            <div className="doctors-container">
                <Row>
                    {docs}
                </Row>
                {
                    this.state.doctors.length === 0 ? (
                        <div className="no-doctors-found">
                            <span>No doctors found</span>
                        </div>
                    ) : null
                }
            </div>
        )
    }
}

export default withRouter(DoctorList);