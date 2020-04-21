import React from "react";

const rootURL = "http://192.168.1.5:32769/csv-extract-web-service-0.0.1-SNAPSHOT/rest";

class Logs extends React.Component {

    constructor(props) {
        super(props);
  
        this.state = {
          data : null
        };
      }

    getLogs() {
        var url = rootURL + "/getLogs"
        fetch(url)
        // .then(resp => resp.json())
        // .then((data) => { this.setState({csvXtractStatus: data.status}) } )

        //TODO: Somehow display the log data on the page
    }

    render() {

        return (
            <div>
                <h3>Logs</h3>
                <button onClick={this.getLogs}>
                    Refresh
                </button>
                <p>
                    TODO: Logs go here!
                </p>
            </div>
        )
    };

}

export default Logs;