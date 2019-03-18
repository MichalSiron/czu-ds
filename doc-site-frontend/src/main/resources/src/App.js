import React, { Component } from 'react';
import {Route, withRouter} from 'react-router-dom';
import { getCurrentUser } from "./util/APIUtils";
import { notification } from 'antd';
import Login from "./components/user/login/Login";
import Profile from './components/user/profile/Profile';


class App extends Component {

    state = {
        currentUser: null,
        isAuthenticated: false,
        isLoading: false
    };

    userHasAuthenticated = (authenticated, callback)=> {
        this.setState({ isAuthenticated: authenticated }, ()=>callback());
    };

    loadCurrentUser =() => {
        console.log("du nacist Current usera");
        this.setState({isLoading: true});
        getCurrentUser().then(response => {
            this.setState({
                currentUser: response,
                isAuthenticated: true,
                isLoading: false
            });
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
    };

    render() {

      return (
          <div className="container">
              <>
                  <div>UVOD VOLE</div>
                  <Route path="/login" render={(props) => <Login onLogin={this.handleLogin} {...props} />} />
                  <Route path="/users/:username"
                         render={(props) => <Profile isAuthenticated={this.state.isAuthenticated} currentUser={this.state.currentUser} {...props}  />}>
                  </Route>
              </>
          </div>
      )
  }
}

export default withRouter(App);
