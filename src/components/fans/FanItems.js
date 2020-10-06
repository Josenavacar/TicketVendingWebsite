import React, { Component } from 'react'

class FanItems extends Component {
    render() {
        const { username, email, html_url } = this.props.fan;

        return (
            <div className="card text-center">
                <img src={email} alt="" className="round-img" style={{ width : '60px' }} />
                <h3>{username}</h3>
                <h3>{email}</h3>

                <div>
                    <a href={html_url} className="btn btn-dark btn-sm my-1">About Me</a>
                </div>
            </div>
        )
    }
}

export default FanItems
