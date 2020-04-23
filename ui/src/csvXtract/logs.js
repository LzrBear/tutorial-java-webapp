import React from "react";

const rootURL = "http://192.168.1.5:32769/csv-extract-web-service-0.0.1-SNAPSHOT/rest";

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