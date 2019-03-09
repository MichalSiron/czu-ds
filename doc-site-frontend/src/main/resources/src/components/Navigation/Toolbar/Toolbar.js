import React from 'react';
import classes from './Toolbar.css';
import Logo from '../../Logo/Logo';
import NavigationItems from '../NavigationItems/NavigationItems';
import { Link } from 'react-router-dom';

const toolbar = () => (
    <header className={classes.Toolbar}>
        <div className={classes.Logo}>
            <Link to="/" >
                <Logo/>
            </Link>
        </div>
        <nav className={classes.DesktopOnly}>
            <NavigationItems unsuported={() => alert('This feature is not supported yet!')}/>
        </nav>
    </header>
);

export default toolbar;