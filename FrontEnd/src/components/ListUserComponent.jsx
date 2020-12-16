import React, { Component } from 'react'
import AuthService from '../services/auth.service';
import UserService from '../services/user.service'

export default class ListUserComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            users: []
        }
    }

    componentDidMount(){
        UserService.getAdminBoard().then((res) => {
            this.setState({users: res.data});
        });
    }

    handleDelete(e) {
        if(window.confirm("Are you sure you want to delete this user?"))
        {
            AuthService.delete(e.id);
            window.location.reload(false);
        }
    }

    render() {
        return (
            <div>
                <h2 className="text-center">User List</h2>
                <div className="row">
                    <table className="table table-striped table-bordered">

                        <thead>
                            <tr>
                                <th> # </th>
                                <th> Username </th>
                                <th> Email </th>
                                <th> Actions </th>
                            </tr>
                        </thead>

                        <tbody>
                            {
                                this.state.users.map(
                                    user =>
                                    <tr key = {user.id}>
                                        <td>{user.id}</td>
                                        <td>{user.username}</td>
                                        <td>{user.email}</td>
                                        <td><button className="btn btn-primary btn-block btn-danger" onClick={() => this.handleDelete(user)}>Delete</button></td>
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
