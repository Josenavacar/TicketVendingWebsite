import React, { Component } from 'react'
import FanItems from './FanItems';

class Fans extends Component {
    state = {
        isLoading: true,
        fans: []
      }
    
      async componentDidMount() {
        const response = await fetch('/api/v1/fan');
        const body = await response.json();
        this.setState({ fans: body, isLoading: false });
      }
      
    render() {
        //const {fans, isLoading} = this.state;
        const isLoading = this.state.isLoading;

        if(isLoading) {
        return <p>Loading...</p>;
        }

        return (
            <div style={fanStyle}>
                {this.state.fans.map(fan => (
                    <FanItems key={fan.username} fan={fan} />
                ))}
            </div>
        );
    }
    
}

const fanStyle = {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gridGap: '1rem'
}

export default Fans;
