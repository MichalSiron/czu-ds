import React from "react";
import { Route } from "react-router-dom";

const AppliedRoute = ({ component: Component, props: auth, ...rest }) =>
    <Route {...rest} render={props => <Component {...props} {...auth} />} />;

export default AppliedRoute;