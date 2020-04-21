import React from "react";

const rootURL = "http://192.168.1.5:32769/csv-extract-web-service-0.0.1-SNAPSHOT/rest";

class WelcomeMsg extends React.Component {

    constructor(props) {
        super(props);
  
        this.state = {
          data : null
        };
      }

    getUserName() {
        var url = rootURL + "/helloworld"
        fetch(url)
        .then(resp => resp.json())
        .then((data) => { this.setState({username: data.name}) } )
    }

    render() {
        
        if (typeof this.state.username == 'undefined') {
            this.getUserName();
        }

        return (
            <div>
                <p>Welcome { this.state.username }</p>
            </div>
        )
    };

}

export default WelcomeMsg;