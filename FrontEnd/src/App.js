import React, { Component } from "react";
import { Switch, Route, Link } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";

import AuthService from "./services/auth.service";

import Login from "./components/auth/login.component";
import Register from "./components/auth/register.component";
import Profile from "./components/auth/profile.component";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faFutbol, faShoppingCart, faSignOutAlt, faSignInAlt, faHistory, faUserCircle, faUserPlus } from '@fortawesome/free-solid-svg-icons'
import ListUserComponent from "./components/ListUserComponent";
import ListMatchComponent from "./components/ListMatchComponent";
import Store from "./components/store/store";
import revenue from "./components/economics/revenue";
import cart from "./components/cart/cart";
import history from "./components/history/history";

class App extends Component {
  constructor(props) {
    super(props);
    this.logOut = this.logOut.bind(this);

    this.state = {
      showAdminBoard: false,
      currentUser: undefined,
    };
  }

  componentDidMount() {
    const user = AuthService.getCurrentUser();

    if (user) {
      this.setState({
        currentUser: user,
        showAdminBoard: user.roles.includes("ROLE_ADMIN")
      });
    }
  }

  logOut() {
    AuthService.logout();
  }

  render() {
    const { currentUser, showAdminBoard } = this.state;

    return (
      <div>
        <nav className="navbar navbar-expand navbar-dark bg-dark">
        <div className="i"><FontAwesomeIcon icon={faFutbol} size="2x" color="white"/></div>
         <div><a className="navbar-brand" href="http://localhost:3000/">TicketWebsite</a></div>
         <div className="navbar-nav mr-auto">
            {currentUser ? (
              <li className="nav-item">
                <Link to={"/store"} className="nav-link">
                Store
                </Link>
              </li>
            ) : (
              <li className="nav-item">
                <Link to={"/home"} className="nav-link">
                  Home
                </Link>
              </li>
            )}
            
            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/admin"} className="nav-link">
                  User List
                </Link>
              </li>
            )}

            {showAdminBoard && (
              <li className="nav-item">
                <Link to={"/revenue"} className="nav-link">
                  Revenue
                </Link>
              </li>
            )}
          </div>

          {currentUser ? (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/cart"} className="nav-link">
                  <FontAwesomeIcon icon={faShoppingCart} size="1x" color="white"/>
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/history"} className="nav-link">
                <FontAwesomeIcon icon={faHistory} size="1x" color="white"/>
                </Link>
              </li>
              <li className="nav-item">
                <Link to={"/profile"} className="nav-link">
                  {currentUser.username} <FontAwesomeIcon icon={faUserCircle} size="1x" color="white"/>
                </Link>
              </li>
              <li className="nav-item">
                <a href="/login" className="nav-link" onClick={this.logOut}>
                  Sign Out <FontAwesomeIcon icon={faSignOutAlt} size="1x" color="white"/>
                </a>
              </li>
            </div>
          ) : (
            <div className="navbar-nav ml-auto">
              <li className="nav-item">
                <Link to={"/login"} className="nav-link">
                  Sign In <FontAwesomeIcon icon={faSignInAlt} size="1x" color="white"/>
                </Link>
              </li>

              <li className="nav-item">
                <Link to={"/register"} className="nav-link">
                  Sign Up <FontAwesomeIcon icon={faUserPlus} size="1x" color="white"/>
                </Link>
              </li>
            </div>
          )}
        </nav>

        <div className="container mt-3">
          <Switch>
            <Route exact path={["/", "/home"]} component={ListMatchComponent} />
            <Route exact path="/login" component={Login} />
            <Route exact path="/register" component={Register} />
            <Route exact path="/profile" component={Profile} />
            <Route path="/store" component={Store} />
            <Route path="/admin" component={ListUserComponent} />
            <Route path="/revenue" component={revenue} />
            <Route path="/cart" component={cart} />
            <Route path="/history" component={history} />
          </Switch>
        </div>
      </div>
    );
  }
}

export default App;
