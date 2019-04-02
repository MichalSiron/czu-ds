import React, {Component} from 'react';
import {Route, withRouter, Switch} from 'react-router-dom';
import {getCurrentUser} from "./util/APIUtils";
import Login from "./components/user/login/Login";
import Signup from "./components/user/signup/Signup";
import Profile from './components/user/profile/Profile';
import AppHeader from './components/Layout/AppHeader/AppHeader';
import {ACCESS_TOKEN} from "./constants";

import './App.css';

import {Layout, notification} from 'antd';
import LoadingIndicator from "./components/UI/Spinner/LoadingIndicator";
import DoctorList from "./components/Model/Doctors/DoctorList";

const {Content} = Layout;

class App extends Component {

    state = {
        currentUser: null,
        isAuthenticated: false,
        isLoading: false
    };

    userHasAuthenticated = (authenticated, callback) => {
        this.setState({isAuthenticated: authenticated}, () => callback());
    };

    loadCurrentUser = () => {
        this.setState({isLoading: true});
        getCurrentUser().then(response => {
            this.setState({
                currentUser: response.data,
                isAuthenticated: true,
                isLoading: false
            });
            console.log("APP: Current username data: "+response.data.username);
        }).catch(err => {
            this.setState({
                isLoading: false
            });
            console.log(err);
        })
    };

    componentDidMount() {
        this.loadCurrentUser();
    }

    handleLogin = () => {
        notification.success({
            message: 'Doctor Site App',
            description: "You're successfully logged in.",
        });
        this.loadCurrentUser();
        this.props.history.push("/");
    };

    handleLogout = (redirectTo = "/", notificationType = "success", description = "You're successfully logged out.") => {
        localStorage.removeItem(ACCESS_TOKEN);

        this.setState({
            currentUser: null,
            isAuthenticated: false
        });

        this.props.history.push(redirectTo);

        notification[notificationType]({
            message: 'Doctor Site',
            description: description,
        });
    };

    render() {
        if (this.state.isLoading) {
            return <LoadingIndicator/>
        }
        return (
            <Layout className="app-container">
                <AppHeader isAuthenticated={this.state.isAuthenticated}
                           currentUser={this.state.currentUser}
                           onLogout={this.handleLogout}/>
                <Content className="app-content">
                    <div className="container">
                        <Switch>
                            <Route exact path="/"
                                   render={(props) => <DoctorList isAuthenticated={this.state.isAuthenticated}
                                                                handleLogout={this.handleLogout} {...props} />}>
                            </Route>
                            <Route path="/login" render={(props) => <Login onLogin={this.handleLogin} {...props} />}/>
                            <Route path="/signup" component={Signup}/>
                            <Route path="/card" component={DoctorList}/>
                            <Route path="/users/:username" component={Profile}>
                            </Route>
                        </Switch>
                    </div>
                </Content>
            </Layout>
        )
    }
}

export default withRouter(App);
