import React from 'react';
import classes from './NavigationItem.css';
import { NavLink } from "react-router-dom";

const NavigationItem = (props) => (
    <li className={classes.NavigationItem}>
        <NavLink to={{pathname: props.link}} activeClassName={classes.active}>
            {props.children}
        </NavLink>
    </li>
);

export default NavigationItem;