import React, { Component } from 'react';
import classes from './LoginForm.css';
import { Redirect } from 'react-router-dom';
import axios from '../../axios';

class LoginForm extends Component {

    state = {
        login: {
            username: '',
            password: '',
            error: '',
        },
        redirectToReferrer: false
    };

    // login = (response) => {
    //     localStorage.setItem("authenticated", JSON.stringify(true));
    //     localStorage.setItem("sessionToken", JSON.stringify("nakejtoken"));
    //
    //     this.setState({
    //         redirectToReferrer: true,
    //     });
    // };
    //
    // componentDidMount() {
    //     this.hydrateStateWithLocalStorage();
    //     window.addEventListener("beforeunload", this.saveStateToLocalStorage);
    // }
    //
    // componentWillUnmount() {
    //     window.removeEventListener("beforeunload", this.saveStateToLocalStorage);
    //     this.saveStateToLocalStorage();
    // }
    //
    // saveStateToLocalStorage = () => {
    //     for (let key in this.state){
    //         localStorage.setItem(key, JSON.stringify(this.state[key]));
    //     }
    // };
    //
    //
    // hydrateStateWithLocalStorage = () => {
    //     for (let key in this.state) {
    //         if (localStorage.hasOwnProperty(key)) {
    //             let value = localStorage.getItem(key);
    //
    //             try {
    //                 value = JSON.parse(value);
    //                 this.setState({ [key]: value });
    //             } catch (e) {
    //                 this.setState({ [key]: value });
    //             }
    //         }
    //     }
    // };

    handleSubmit = async (event) => {
        event.preventDefault();

        // const username = 'sironm';
        // const password = '123';

        const { username, password }= this.state.login;

        // const salt = bcrypt.genSaltSync(12);
        // const hashedPass = bcrypt.hashSync(password, salt);

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
                password: password
            }
        })
            .then((response) => {
                console.log("Authenticated: "+JSON.stringify(response));
                this.props.userHasAuthenticated(true, () => this.setState({redirectToReferrer: true}));
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

    handleInput = async (key, value) => {
        const login = {...this.state.login};
        login[key] = value;
        await this.setState({login});
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
                        value={this.state.login.username}
                        onChange={event => this.handleInput('username', event.target.value)} />
                    <input
                        type="password"
                        placeholder="Password"
                        value={this.state.login.password}
                        onChange={event => this.handleInput('password',event.target.value)} />
                    <input type="submit" value="Log In" />
                </form>
            </div>
        );
    }
}

export default LoginForm;