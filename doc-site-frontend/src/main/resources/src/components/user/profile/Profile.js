import React, { Component } from 'react';
import { getUserProfile } from "../../../util/APIUtils";

class Profile extends Component{

    state = {
        user: null,
        isLoading: false
    };

    loadUserProfile= (username) => {
        this.setState({
            isLoading: true
        });

        getUserProfile(username)
            .then(response => {
                this.setState({
                    user: response,
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
        });
    };

    componentDidMount() {
        const username = this.props.match.params.username;
        this.loadUserProfile(username);
    }

    render() {
        if(this.state.isLoading) {
            return <div>Loading...</div>;
        }

        if(this.state.notFound) {
            return <div>Not found</div>;
        }

        if(this.state.serverError) {
            return <div>Server Error</div>;
        }

        return (
            <div>Uzivatelskej profil {JSON.stringify(this.state.user)}</div>
        )
    }
}

export default Profile;