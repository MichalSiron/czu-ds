import React, { Component } from 'react';
import classes from './Login.css';
import { Redirect } from 'react-router-dom';

class Login extends Component {

    state = {
        username: '',
        password:'',
        error: '',
        redirectToReferrer: false,
        api_key: null
    };

    handleSubmit = (event) => {
        event.preventDefault();

        if (!this.state.username) {
            console.log("handleSubmit, username incorrect");
            return this.setState({ error: 'Username is required' });
        }

        if (!this.state.password) {
            console.log("handleSubmit, password incorrect");
            return this.setState({ error: 'Password is required' });
        }

        if (this.state.username === 'test' && this.state.password === 'test') {
            this.login();
        }else {
            return this.setState({ error: 'Incorrect username or password!' });
        }

        return this.setState({ error: '' });
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
                    <input type="text" placeholder="Username" value={this.state.username} onChange={event => this.setState({username: event.target.value})} />
                    <input type="password" placeholder="password" value={this.state.password} onChange={event => this.setState({password: event.target.value})} />
                    <input type="submit" value="Log In" />
                </form>
            </div>
        );
    }
}

export default Login;