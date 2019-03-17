import React from "react";
import { Redirect } from "react-router-dom";
import PrivateRoute from "./components/CustomRoute/PrivateRoute";
import AppliedRoute from "./components/CustomRoute/AppliedRoute";

import Doctors from "./components/Model/Doctors/Doctors";
import LoginForm from "./containers/Login/LoginForm";
import Patients from "./components/Model/Patient/Patients";


const Routes = ({auth}) =>
    <>
        <AppliedRoute path="/" exact component={Doctors} props={auth}/>
        <AppliedRoute path="/login" component={LoginForm} props={auth}/>
        <PrivateRoute path="/patients" component={Patients} props={auth}/>
        <AppliedRoute path="/logout" component={() => {
            auth.userHasAuthenticated(false, ()=>{});
            return <Redirect to="/"/>
        }} props={auth}/>
    </>;

export default Routes;