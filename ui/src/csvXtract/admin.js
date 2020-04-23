import React from "react";

const rootURL = "http://192.168.1.5:32769/csv-extract-web-service-0.0.1-SNAPSHOT/rest";

class Admin extends React.Component {

    constructor(props) {
        super(props);
  
        this.state = {
          data : null
        };

        this.start = this.start.bind(this);
        this.stop = this.stop.bind(this);

      }

    getStatus() {
        var url = rootURL + "/getStatus"
        fetch(url)
        .then(resp => resp.json())
        .then((data) => { this.setState({csvXtractStatus: data.status}) } )
    }

    start() {
        var url = rootURL + "/start"
        fetch(url)
        //.then(resp => { debugger; resp.json() })
        .then(() => { setTimeout(() => { this.getStatus()}, 1000)})
        //.then((data) => { this.setState({username: data.name}) } )
    }

    stop() {
        var url = rootURL + "/stop"
        fetch(url)
        //.then(resp => resp.json())
        .then(() => { setTimeout(() => { this.getStatus()}, 1000)})
        //.then((data) => { this.setState({username: data.name}) } )
    }

    tick() {
        this.setState(state => ({
          seconds: state.seconds + 1
        }));
    }

    componentDidMount() {
        this.interval = setInterval(() => { this.setState({ time: Date.now() }); this.getStatus(); }, 1000);
    }
    
    componentWillUnmount() {
        clearInterval(this.interval);
    }

    render() {

        if (typeof this.state.csvXtractStatus == 'undefined') {
            this.getStatus();
        }

        return (
            <div>
                <div>
                    Timer: {this.state.time}
                </div>
                <p>CSVXtract is currently { this.state.csvXtractStatus } on this server</p>
                <button onClick={this.start}>
                    Start
                </button>
                <button onClick={this.stop}>
                    Stop
                </button>
            </div>
        )
    };

}

export default Admin;