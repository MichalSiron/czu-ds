import React, { Component } from 'react';
import { BrowserRouter } from 'react-router-dom';

import Layout from './components/Layout/Layout';
import DoctorSiteBuilder from './containers/DoctorSite/DoctorSiteBuilder';


class App extends Component {

    state = {
        isAuthenticated: false
    };

    userHasAuthenticated = (authenticated, callback)=> {
        this.setState({ isAuthenticated: authenticated }, ()=>callback());
    };

  render() {

      const authentication = {
          isAuthenticated: this.state.isAuthenticated,
          userHasAuthenticated: this.userHasAuthenticated
      };

      return <BrowserRouter>
                    <Layout auth={authentication}>
                         <DoctorSiteBuilder auth={authentication}/>
                     </Layout>
              </BrowserRouter>;
  }
}

export default App;
