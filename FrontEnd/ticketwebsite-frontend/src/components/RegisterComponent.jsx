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
      <div class="reg-content">
        <form onSubmit={this.handleSubmit}>
        <div class="form-group">
            <label for="exampleInputEmail1">Username</label>
            <input type="username" class="form-control" name="username" placeholder="Username" value={this.state.username} onChange={this.handleChange}/>
          </div>
          <div class="form-group">
            <label for="exampleInputEmail1">Email address</label>
            <input type="email" class="form-control" id="exampleInputEmail1" name="email" placeholder="example@gmail.com" value={this.state.email} onChange={this.handleChange}/>
          </div>
          <div class="form-group">
            <label for="exampleInputPassword1">Password</label>
            <input type="password" class="form-control" id="exampleInputPassword1" name="password" placeholder="Password" value={this.state.password} onChange={this.handleChange}/>
          </div>
        <button type="submit" class="btn btn-primary">Register</button>
      </form>
      </div>
    )
  }
}

/*
  <div class="form-group">
    <label>Username: </label>
    <input type="text" name="username" placeholder="Username" value={this.state.username} onChange={this.handleChange} />
    <label>Password: </label>
    <input type="password" name="password" placeholder="Password" value={this.state.password} onChange={this.handleChange} />
    <label>Email: </label>
    <input type="text" name="email" placeholder="Email" value={this.state.email} onChange={this.handleChange} />
    <button>Register</button>
  </div>
*/