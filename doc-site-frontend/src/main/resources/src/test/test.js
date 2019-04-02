import React, { Component } from 'react';
import classes from './test.css';

class Test extends Component {

    render() {
        return (
            <h1 className={classes.Test}>
                {this.props.children}
            </h1>
        )
    }
}

export default Test;