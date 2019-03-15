import React, { Component } from 'react';
import classes from './Login.css';
import { Redirect } from 'react-router-dom';
import bcrypt from 'bcryptjs';
import axios from '../../axios';

class Login extends Component {

    state = {
        username: '',
        password:'',
        error: '',
        redirectToReferrer: false,
        api_key: null
    };

    handleSubmit = async (event) => {
        event.preventDefault();

        // const username = 'sironm';
        // const password = '123';

        const username = this.state.username;
        const password = this.state.password;

        const salt = bcrypt.genSaltSync(12);
        const hashedPass = bcrypt.hashSync(password, salt);

        console.log("username: "+username);
        console.log("password: "+password);

        if (!username) {
            console.log("handleSubmit, username incorrect");
            return this.setState({error: 'Username is required'});
        }

        if (!password) {
            console.log("handleSubmit, password incorrect");
            return this.setState({error: 'Password is required'});
        }

        await axios.get("/validate", {
            auth: {
                username: username,
                password: hashedPass
            }
        })
            .then(() => {
                console.log("Authenticated");
                this.login();
            })
            .catch(error => {
                console.log("Authentication failed: "+error);
                this.setState({error: 'Incorrect username or password!'});
            });

        return this.state.error;
    };

    dismissError = () => {
        this.setState({error: ''});
    };

    render() {

        const { redirectToReferrer } = this.state;
        if (redirectToReferrer){
            return <Redirect to="/"/>
        }

        return (
            <div className={classes.Login}>
                <form onSubmit={this.handleSubmit}>
                    {
                        this.state.error &&
                        <h3 data-test="error" onClick={this.dismissError}>
                            <button onClick={this.dismissError}>✖</button>
                            {this.state.error}
                        </h3>
                    }
                    <input
                        type="text"
                        placeholder="Username"
                        value={this.state.username}
                        onChange={event => this.setState({username: event.target.value})} />
                    <input
                        type="password"
                        placeholder="password"
                        value={this.state.password}
                        onChange={event => this.setState({password: event.target.value})} />
                    <input type="submit" value="Log In" />
                </form>
            </div>
        );
    }
}

export default Login;