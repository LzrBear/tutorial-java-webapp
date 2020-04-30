import React from "react";
import config from 'react-global-configuration';

const rootURL = config.get("rootURL");

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
        var url = rootURL + "/Admin/Status"
        fetch(url)
        .then(resp => resp.json())
        .then((data) => { this.setState({csvXtractStatus: data.status}) } )
    }

    start() {
        var url = rootURL + "/Admin/Start"
        fetch(url)
        //.then(resp => { debugger; resp.json() })
        .then(() => { setTimeout(() => { this.getStatus()}, 1000)})
        //.then((data) => { this.setState({username: data.name}) } )
    }

    stop() {
        var url = rootURL + "/Admin/Stop"
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