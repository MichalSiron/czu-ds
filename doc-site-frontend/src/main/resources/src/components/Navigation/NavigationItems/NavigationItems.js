import React from 'react';
import classes from './NavigationItems.css';
import NavigationItem from './NavigationItem/NavigationItem';

const NavigationItems = (props) => {
    let menuItems = (
        <>
            <NavigationItem link='/search'>Vyhledávání</NavigationItem>
        </>
    );
    console.log("Value of authentication: "+JSON.stringify(props));

        if (props.auth.isAuthenticated){
            menuItems = <>
                {menuItems}
                <NavigationItem link='/logout' logout={props.userHasAuthenticated}>Logout</NavigationItem>
                <NavigationItem link='/patients'>Patients</NavigationItem>
            </>
        } else {
            menuItems = <>
                {menuItems}
                <NavigationItem link='/login'>Login</NavigationItem>
                <NavigationItem link='/signup'>Signup</NavigationItem>
            </>
        }

    return (
        <ul className={classes.NavigationItems}>
            {menuItems}
        </ul>
        )
};

export default NavigationItems;