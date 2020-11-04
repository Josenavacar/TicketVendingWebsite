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
                    </nav>
                </header>
            </div>
        )
    }
}
