import React from "react";
import config from 'react-global-configuration';

const rootURL = config.get("rootURL");

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