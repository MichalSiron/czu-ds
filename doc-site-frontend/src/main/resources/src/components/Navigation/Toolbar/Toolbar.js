import React from 'react';
import classes from './Toolbar.css';
import Logo from '../../Logo/Logo';
import NavigationItems from '../NavigationItems/NavigationItems';
import { Link } from 'react-router-dom';

const toolbar = (props) => (
    <header className={classes.Toolbar}>
        <div className={classes.Logo}>
            <Link to="/" >
                <Logo/>
            </Link>
        </div>
        <nav className={classes.DesktopOnly}>
            <NavigationItems auth={props.auth}/>
        </nav>
    </header>
);

export default toolbar;