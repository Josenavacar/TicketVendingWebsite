import React, { Component } from 'react'

class MatchItems extends Component {
    render() {
        const { team1, team2, date, scoreTeam0, scoreTeam1, html_url } = this.props.match;

        return (
            <div className="card text-center">
                <h3>{team1} vs. {team2}</h3>
                <div>
                    <h2>{scoreTeam0} - {scoreTeam1}</h2>
                </div>
                <p>{date}</p>

                <div>
                    <a href={html_url} className="btn btn-dark btn-sm my-1">More Info.</a>
                </div>
            </div>
        )
    }
}

export default MatchItems