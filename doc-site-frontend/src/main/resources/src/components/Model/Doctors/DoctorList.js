import React, { Component } from 'react';

import './DoctorList.css';
import './Doctor.css';
import { Card, Col, Row } from 'antd';
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
            docs.push(<Doctor
                key={doctor.id}
                username="kolarpa1"
                name={doctor.name}
                address={doctor.address}
            />)
        });

        return(
            <div className="doctors-container">
                {docs}
                {
                    this.state.doctors.length === 0 ? (
                        <div className="no-doctors-found">
                            <span>No doctors found</span>
                        </div>
                    ) : null
                }
                <Row>
                    <Col span={6}>
                        <Card
                            title="Card title"
                            hoverable='true'
                        >Card content</Card>
                    </Col>
                    <Col span={6}>
                        <Card
                            title="Card title">Card content</Card>
                    </Col>
                    <Col span={6}>
                        <Card
                            title="Card title"
                        >Card content</Card>
                    </Col>
                    <Col span={6}>
                        <Card
                            title="Card title">Card content</Card>
                    </Col>
                </Row>
            </div>
        )
    }
}

export default withRouter(DoctorList);