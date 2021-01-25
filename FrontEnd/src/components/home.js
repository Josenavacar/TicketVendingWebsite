import React, { Component } from 'react'
import MatchService from '../services/MatchService';

export default class Home extends Component {
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
            <div>
                <div style={matchStyle}>
                    {
                        this.state.matches.map(
                            match =>
                            <div className="card text-center cardpadding" key={match.id}>
                                <p className="form-text text-muted">#{match.id}</p>
                                <h3>{match.team1} vs. {match.team2}</h3>
                                <p>{match.date}</p>
                            </div>
                        )
                    }
                </div>
            </div>
        )
    }

}

const matchStyle = {
    display: 'grid',
    gridTemplateColumns: 'repeat(4, 1fr)',
    gridGap: '1rem'
}
