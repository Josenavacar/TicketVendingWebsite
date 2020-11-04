import React, { Component } from 'react'
import FanService from '../services/FanService'

export default class ListFanComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            fans: []
        }
    }

    componentDidMount(){
        FanService.getFans().then((res) => {
            this.setState({fans: res.data});
        });
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Fans List</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> # </th>
                                <th> Fan Username </th>
                                <th> Fan Email </th>
                                <th> Actions </th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.fans.map(
                                    fan =>
                                    <tr key = {fan.id}>
                                        <td>{fan.id}</td>
                                        <td>{fan.username}</td>
                                        <td>{fan.email}</td>
                                        <td></td>
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
