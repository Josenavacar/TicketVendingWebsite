import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import ListFanComponent from './components/ListFanComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import ListMatchComponent from './components/ListMatchComponent';
import RegisterComponent from './components/RegisterComponent.jsx';
import LoginComponent from './components/LoginComponent.jsx';
import TicketComponent from './components/TicketComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch>
                <Route path="/" exact={true} component={ListMatchComponent}></Route>
                <Route path="/fans" component={ListFanComponent}></Route>
                <Route path="/matches" component={ListMatchComponent}></Route>
                <Route path="/register" component={RegisterComponent}></Route>
                <Route path="/login" component={LoginComponent}></Route>
                <Route path="/tickets" component={TicketComponent}></Route>
              </Switch>
            </div>
          <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
