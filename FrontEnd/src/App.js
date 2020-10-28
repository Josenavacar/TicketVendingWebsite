import React, { Component } from 'react';
import Navbar from './components/layout/Navbar';
//import Fans from './components/fans/Fans';
import Matches from './components/matches/Matches';
import './App.css';

class App extends Component {
  render() {
    return (
      <nav className="App">
        <Navbar />
        <div className="container">
         <Matches />
        </div>
      </nav>
    );
  }
}

export default App;
