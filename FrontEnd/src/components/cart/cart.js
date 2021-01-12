import React, { Component } from 'react'
import authService from '../../services/auth.service';
import TicketService from '../../services/TicketService';

export default class cart extends Component {
    constructor(props) {
        super(props)

        this.state = {
            unpaidTickets: []
        }
    }

    componentDidMount(){
        TicketService.getUnpaidTickets(authService.getCurrentUser().id)
        .then((res) => {
            this.setState({unpaidTickets: res.data});
        });
    }

    handleDelete(e) {
        if(window.confirm("Are you sure you want to remove this Ticket from your shopping cart?"))
        {
            TicketService.deleteTicket(e.id);
            window.location.reload(false);
        }
    }

    handlePay() {
        if(window.confirm("You are about to pay, are you sure you want to proceed?"))
        {
            this.state.unpaidTickets.forEach(ticket => {
                    TicketService.payTicket(ticket.id)
                    window.location.reload(false);
            });
        }
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Cart</h2>
                <div className="row">
                    <table className="table table-striped table borderless">

                        <thead>
                            <tr>
                                <th> # </th>
                                <th> Match Name </th>
                                <th> Date </th>
                                <th> Price</th>
                                <th> Actions</th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.unpaidTickets.map(
                                    ticket =>
                                    <tr key = {ticket.id}>
                                        <td>{ticket.id}</td>
                                        <td>{ticket.matchName}</td>
                                        <td>{ticket.matchDate}</td>
                                        <td>{ticket.price} €</td>
                                        <td><button className="btn btn-primary btn-block btn-danger" onClick={() => this.handleDelete(ticket)}>Remove</button></td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                    <div>
                        <h3>To Pay: {this.state.unpaidTickets.reduce((a, b) => a + (b['price'] || 0), 0)}€</h3>

                        <div>
                            <button type="button" className="btn btn-primary btn-lg" onClick={() => this.handlePay()}>Complete Purchase</button>   
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
