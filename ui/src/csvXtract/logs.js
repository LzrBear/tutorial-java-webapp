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

    render() {

        return (
            <div>
                <h3>Logs</h3>
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