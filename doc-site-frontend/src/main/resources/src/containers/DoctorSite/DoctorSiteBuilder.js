import React, { Component } from 'react';

import Routes from '../../Routes';

class DoctorSiteBuilder extends Component {

    render() {

        return (
            <Routes auth={this.props.auth} />
        );
    }
}

export default DoctorSiteBuilder;