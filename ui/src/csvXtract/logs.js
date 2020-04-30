import React from "react";
import config from 'react-global-configuration';

const rootURL = config.get("rootURL");

class Logs extends React.Component {

    constructor(props) {
        super(props);
  
        this.state = {
          data : null
        };

        this.getLogs = this.getLogs.bind(this);
      }

    getLogs() {
        var url = rootURL + "/getLogs"
        fetch(url)
        .then(resp => resp.json() )
        .then((data) => { this.setState({logs: data.Logs}) } )
    }

    getLogsServerFilePath() {
        var url = rootURL + "/getLogsServerFilePath"
        fetch(url)
        .then(resp => resp.json() )
        .then((data) => { this.setState({LogsServerFilePath: data.LogsServerFilePath}) } )
    }

    render() {

        if (typeof this.state.LogsServerFilePath == 'undefined') {
            this.getLogsServerFilePath();
        }

        return (
            <div>
                <h3>Logs</h3>
                <div>Log files located on server at {this.state.LogsServerFilePath}</div>
                <button onClick={this.getLogs}>
                    Refresh
                </button>
                
                <div style={{ 'white-space': 'pre-wrap' }}>
                    { this.state.logs } 
                </div>
            </div>
        )
    };

}

export default Logs;