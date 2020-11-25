import React, { Component } from 'react'
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faFutbol } from '@fortawesome/free-solid-svg-icons'

export default class HeaderComponent extends Component {
    
    constructor(props) {
        super(props)
        
        this.state = {

        }
    }

    render() {
        return (
            <div>
                <header>
                    <nav className="navbar navbar-expand-md navbar-dark bg-dark">
                        <div className="i"><FontAwesomeIcon icon={faFutbol} size="2x" color="white"/></div>
                        <div><a className="navbar-brand">TicketWebsite</a></div>
                        <div class="navbar-nav">
                            <a class="nav-item nav-link" href="/matches">Home <span class="sr-only"></span></a>
                            <a class="nav-item nav-link" href="/fans">Users</a>
                            <a class="nav-item nav-link" href="/tickets">Tickets</a>
                            <a class="nav-item nav-link" href="/register">Register</a>
                        </div>
                    </nav>
                </header>
            </div>
        )
    }
}
