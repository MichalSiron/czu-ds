import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';

import Layout from './components/Layout/Layout';
import DoctorSiteBuilder from './containers/DoctorSite/DoctorSiteBuilder';


class App extends Component {

  render() {
    return (
        <BrowserRouter>
            <Layout>
              <DoctorSiteBuilder/>
            </Layout>
        </BrowserRouter>
    );
  }
}

export default App;
