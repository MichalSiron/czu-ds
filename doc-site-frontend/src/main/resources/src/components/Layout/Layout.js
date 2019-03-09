import React, { Component } from 'react';
import classes from './Layout.css';
import Toolbar from '../Navigation/Toolbar/Toolbar';
import SideDrawer from '../Navigation/SideDrawer/SideDrawer';

class Layout extends Component {

    state = {
        showSideDrawer: false
    };

    render(){

        return (
            <>
                <Toolbar openHandler={() => this.setState({showSideDrawer: true})}/>
                <SideDrawer
                    closeHandler={() => this.setState({showSideDrawer: false})}
                    open={this.state.showSideDrawer}/>
                <main className={classes.Content}>
                    {this.props.children}
                </main>
            </>
        );
    }
}

export default Layout;