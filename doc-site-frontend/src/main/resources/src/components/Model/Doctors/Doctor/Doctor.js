import React, { Component }from 'react';
import './Doctor.css';
import {getAvatarColor} from "../../../../util/Colors";
import {formatDateTime} from "../../../../util/Helper";
import {Link} from "react-router-dom";
import {Avatar} from "antd";

class Doctor extends Component {

    render() {

        console.log('PROPS');
        console.log(this.props);
        console.log('PROPS');

        const name = this.props.name.firstName +' '+ this.props.name.lastName;

        return (
            <div className="doctor-content">
                <div className="doctor-header">
                    <div className="doctor-info">
                        <Link className="doctor-link" to={`/users/${this.props.username}`}>
                            <Avatar className="doctor-avatar"
                                    style={{ backgroundColor: getAvatarColor(this.props.name)}} >
                                {name.toUpperCase()}
                            </Avatar>
                            <span className="doctor-name">
                                {this.props.address.city}
                            </span>
                            <span className="doctor-creation-date">
                                {formatDateTime()}
                            </span>
                        </Link>
                    </div>
                </div>
            </div>
        );
    }
}

export default Doctor;