import React, { Component } from 'react'
import authService from '../../services/auth.service';
import TicketService from '../../services/TicketService';
import MatchService from '../../services/MatchService';

export default class Store extends Component {
    constructor(props) {
        super(props)

        this.state = {
            matches: [],
            userID: authService.getCurrentUser().id
        }
    }

    componentDidMount(){
        MatchService.getMatches().then((res) => {
            this.setState({matches: res.data});
        });
    }

    handlePurchase(e) {
        if(window.confirm("Are you sure you want to purchase this ticket?"))
        {
            TicketService.purchaseTicket(e.id, this.state.userID)
        }
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
                            <div>
                                <h3>25.99 €</h3>
                                <button type="button" class="btn btn-dark" onClick={() => this.handlePurchase(match)}>Buy Now!</button>
                            </div>
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