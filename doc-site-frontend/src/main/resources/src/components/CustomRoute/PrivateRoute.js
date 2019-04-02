import React from "react";
import { Redirect, Route } from "react-router-dom";

const PrivateRoute = ({component: Component, props: auth, ...rest}) => (
    <Route {...rest} render={props => (
        auth.isAuthenticated ? <Component {...props} {...auth}/> : <Redirect to="/login"/>
    )}/>
);

export default PrivateRoute;