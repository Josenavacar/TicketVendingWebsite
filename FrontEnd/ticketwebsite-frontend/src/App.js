import React from 'react';
import './App.css';
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom';
import ListFanComponent from './components/ListFanComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent';
import ListMatchComponent from './components/ListMatchComponent';

function App() {
  return (
    <div>
      <Router>
          <HeaderComponent />
            <div className="container">
              <Switch>
                <Route path="/fans" component={ListFanComponent}></Route>
                <Route path="/matches" component={ListMatchComponent}></Route>
                <ListFanComponent />
              </Switch>
            </div>
          <FooterComponent />
      </Router>
    </div>
  );
}

export default App;
