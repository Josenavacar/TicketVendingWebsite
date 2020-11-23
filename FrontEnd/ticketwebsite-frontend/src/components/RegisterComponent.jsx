import React, { Component } from 'react'

export default class LoginComponent extends Component {
  constructor(props) {
    super(props);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.state = {username: '', password: '', email: ''};
  }

  handleSubmit = e => {
    e.preventDefault()
    fetch('http://localhost:8080/api/v1/fan', {
      method: 'POST',
      body: JSON.stringify(this.state),
      headers: {
        'content-type': 'application/json',
        'accept': 'application/json'
      }
    })
    .then(response => response.json())

    this.setState({
      username: '',
      password: '',
      email: ''
    })
  }

  handleChange = e => this.setState({ [e.target.name]: e.target.value })

  render() {
    return (
      <div>
        <h1>Register</h1>
        <form onSubmit={this.handleSubmit}>
          <label>Username: </label>
          <input type="text" name="username" placeholder="Username" value={this.state.username} onChange={this.handleChange} />
          <label>Password: </label>
          <input type="password" name="password" placeholder="Password" value={this.state.password} onChange={this.handleChange} />
          <label>Email: </label>
          <input type="text" name="email" placeholder="Email" value={this.state.email} onChange={this.handleChange} />
          <button>Register</button>
        </form>
      </div>
    )
  }
}
