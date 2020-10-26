import React, { Component } from 'react'
import MatchItems from './MatchItems';

class Matches extends Component {
    state = {
        isLoading: true,
        matches: []
      }
    
      async componentDidMount() {
        const response = await fetch('/api/v1/match');
        const body = await response.json();
        this.setState({ matches: body, isLoading: false });
      }
      
    render() {
        //const {fans, isLoading} = this.state;
        const isLoading = this.state.isLoading;

        if(isLoading) {
        return <p>Loading...</p>;
        }

        return (
            <div style={matchStyle}>
                {this.state.matches.map(match => (
                    <MatchItems key={match.id} match={match} />
                ))}
            </div>
        );
    }
    
}

const matchStyle = {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gridGap: '1rem'
}

export default Matches;
