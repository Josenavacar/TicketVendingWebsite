import React, { Component } from 'react'
import TicketService from '../services/TicketService'

export default class TicketComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            tickets: []
        }
    }

    componentDidMount(){
        TicketService.getTickets()
        .then((res) => {
            this.setState({tickets: res.data});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Ticket List</h2>
                <div className="row">
                    <table className="table table-striped table borderless">

                        <thead>
                            <tr>
                                <th> # </th>
                                <th> Fan ID </th>
                                <th> Match ID </th>
                                <th> Seat Nr. </th>
                                <th> Price in € </th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.tickets.map(
                                    ticket =>
                                    <tr key = {ticket.id}>
                                        <td>{ticket.id}</td>
                                        <td>{ticket.fanID}</td>
                                        <td>{ticket.matchID}</td>
                                        <td>{ticket.seat}</td>
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

