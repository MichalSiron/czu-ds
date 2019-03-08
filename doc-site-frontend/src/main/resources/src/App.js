import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';

import Layout from './components/Layout/Layout';
import DoctorSiteBuilder from './containers/DoctorSite/DoctorSiteBuilder';


class App extends Component {

  render() {
    return (
        <BrowserRouter>
          <div>
            <Layout>
              <DoctorSiteBuilder/>
            </Layout>
          </div>
        </BrowserRouter>
    );
  }
}

export default App;
