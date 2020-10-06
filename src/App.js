import React, { Component } from 'react';
import Navbar from './components/layout/Navbar';
import Fans from './components/fans/Fans';
import './App.css';

class App extends Component {
  /*
  state = {
    isLoading: true,
    fans: []
  }

  async componentDidMount() {
    const response = await fetch('/api/v1/fan');
    const body = await response.json();
    this.setState({ fans: body, isLoading: false });
  }
  */
  

  render() {
    
    /*
    const {fans, isLoading} = this.state;

    if(isLoading) {
      return <p>Loading...</p>;
    }
    */

    return (
      <nav className="App">
        <Navbar />
        <div className="container">
          <Fans />
        </div>
      </nav>
    );
  }
}

export default App;
