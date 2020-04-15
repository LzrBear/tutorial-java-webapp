import React from 'react';
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>
    </div>
  );
}

class WelcomeMsg extends React.Component {

  constructor(props) {
      super(props);

      this.state = {
        data : null
      };
    }

  getUserName() {
      var url = rootURL + "/GetUser/"
      fetch(url)
      .then(resp => resp.text())
      .then((data) => { this.setState({username: data}) } )
  }

  render() {
      
      if (typeof this.state.username == 'undefined') {
          this.getUserName();
      }

      return (
          <div>
              <h3>Welcome { this.state.username }</h3>
          </div>
      )
  };

}

export default App;
