import React, { Component } from "react";
import AuthService from "../../services/auth.service";

export default class Profile extends Component {
  constructor(props) {
    super(props);

    this.state = {
      currentUser: AuthService.getCurrentUser()
    };
  }

  render() {
    const { currentUser } = this.state;

    return (
      <div className="container">
        <div>
          <header>
            <h1>
              <strong>{currentUser.username}</strong> <h3 class="mb-3">profile</h3>
            </h1>
          </header>
        </div>
        
        <hr class="my-4"></hr>

        <div>
          <strong>Id:</strong>{" "}
          <ul>
            {currentUser.id}
          </ul>
        </div>
        
        <div>
          <strong>Token:</strong>{" "}
          <ul>
            {currentUser.accessToken.substring(0, 20)} ...{" "}
            {currentUser.accessToken.substr(currentUser.accessToken.length - 20)}
          </ul>
          
        </div>

        <div>
          <strong>Email:</strong>{" "}
          <ul>
           {currentUser.email}
          </ul>
        </div>

        <div>
          <strong>Authorities:</strong>
          <ul>
            {currentUser.roles &&
              currentUser.roles.map((role, index) => <li key={index}>{role}</li>)}
          </ul> 
        </div>
      </div>
    );
  }
}