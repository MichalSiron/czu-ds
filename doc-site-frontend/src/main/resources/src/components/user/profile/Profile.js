import React, { Component } from 'react';

import './Profile.css';
import DoctorList from '../../Model/Doctors/DoctorList';
import { getUserProfile } from "../../../util/APIUtils";
import {getAvatarColor} from "../../../util/Colors";
import { Avatar, Tabs } from 'antd';
import {formatDate} from "../../../util/Helper";
import LoadingIndicator from "../../UI/Spinner/LoadingIndicator";

const TabPane = Tabs.TabPane;

class Profile extends Component{
    _isMounted = false;

    state = {
        user: null,
        isLoading: false
    };

    loadUserProfile = (username) => {
        this._isMounted && this.setState({
            isLoading: true
        });

        getUserProfile(username)
            .then(response => {
                this._isMounted && this.setState({
                    user: response.data,
                    isLoading: false
                });
            }).catch(error => {
                if (error.status === 404) {
                    this._isMounted && this.setState({
                        notFound: true,
                        isLoading: false
                    });
                } else {
                    this._isMounted && this.setState({
                        serverError: true,
                        isLoading: false
                    });
                }
            });
    };

    componentDidMount() {
        this._isMounted = true;
        if (this._isMounted) {
            this.loadUserProfile(this.props.match.params.username);
        }

    }

    componentWillUnmount() {
        this._isMounted = false;
    }

    componentDidUpdate(nextProps) {
        if(this.props.match.params.username !== nextProps.match.params.username) {
            this.loadUserProfile(nextProps.match.params.username);
        }
    }

    render() {

        if(this.state.isLoading) {
            return <LoadingIndicator/>;
        }

        if(this.state.notFound) {
            return <div>Not found</div>;
        }

        if(this.state.serverError) {
            return <div>Server Error</div>;
        }

        return (
            <div className="profile">
                {
                    this.state.user ? (
                        <div className="user-profile">
                            <div className="user-details">
                                <div className="user-avatar">
                                    <Avatar className="user-avatar-circle" style={{ backgroundColor: getAvatarColor(this.state.user.name.firstName)}}>
                                        {this.state.user.name.firstName}
                                    </Avatar>
                                </div>
                                <div className="user-summary">
                                    <div className="full-name">{this.state.user.name.firstName +' '+ this.state.user.name.lastName}</div>
                                    <div className="username">@{this.state.user.username}</div>
                                    <div className="user-joined">
                                        Joined {formatDate(this.state.user.joinedAt)}
                                    </div>
                                </div>
                            </div>
                            <div className="user-doctor-details">
                                <Tabs defaultActiveKey="1"
                                      animated={false}
                                      tabBarStyle={{textAlign: 'center'}}
                                      size="large"
                                      className="profile-tabs">
                                    <TabPane tab={`${this.state.user.validatedDoctorsCount} Valid Doctors`} key="1">
                                        <DoctorList username={this.props.match.params.username} type="VALIDATED_DOCTORS" />
                                    </TabPane>
                                    <TabPane tab={`${this.state.user.invalidatedDoctorsCount} Pending Doctors`} key="2">
                                        <DoctorList username={this.props.match.params.username} type="PENDING_DOCTORS" />
                                    </TabPane>
                                </Tabs>
                            </div>
                        </div>
                    ): null
                }
            </div>
        )
    }
}

export default Profile;