import React, { Component } from 'react'
import MatchService from '../services/MatchService';

export default class ListMatchComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            matches: []
        }
    }

    componentDidMount(){
        MatchService.getMatches().then((res) => {
            this.setState({matches: res.data});
        });
    }

    render() {
        return (
            <div style={matchStyle}>
                {
                    this.state.matches.map(
                        match =>
                        <div className="card text-center">
                            <p className="form-text text-muted">#{match.id}</p>
                            <h3>{match.team1} vs. {match.team2}</h3>
                            <p>{match.date}</p>
                            <p>Seats left: {5000 - match.seatCounter}</p>
                        </div>
                    )
                }
            </div>
        )
    }

}

const matchStyle = {
    display: 'grid',
    gridTemplateColumns: 'repeat(3, 1fr)',
    gridGap: '1rem'
}
