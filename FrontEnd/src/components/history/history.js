import React, { Component } from 'react'
import authService from '../../services/auth.service';
import TicketService from '../../services/TicketService';

export default class history extends Component {
    constructor(props) {
        super(props)

        this.state = {
            ticketHistory: []
        }
    }

    componentDidMount(){
        TicketService.getPaidTickets(authService.getCurrentUser().id)
        .then((res) => {
            this.setState({ticketHistory: res.data});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Purchase History</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> # </th>
                                <th> Match ID </th>
                                <th> Price in € </th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.ticketHistory.map(
                                    ticket =>
                                    <tr key = {ticket.id}>
                                        <td>{ticket.id}</td>
                                        <td>{ticket.matchName}</td>
                                        <td>{ticket.price}</td>
                                    </tr>
                                )
                            }

                        </tbody>
                    </table>
                </div>
                
            </div>
        )
    }
}
