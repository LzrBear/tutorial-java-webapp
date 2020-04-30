import "./config";


import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import WelcomeMsg from './WelcomeMsg';
import Admin from './csvXtract/admin';
import Logs from './csvXtract/logs';
import * as serviceWorker from './serviceWorker';

ReactDOM.render(
  <React.StrictMode>
    <h1>CSVXtract Admin</h1>
    <WelcomeMsg/>
    <Admin/>
    <Logs/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
