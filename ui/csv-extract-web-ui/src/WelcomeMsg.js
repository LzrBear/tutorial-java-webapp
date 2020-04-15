import React from "react";

class WelcomeMsg extends React.Component {

    constructor(props) {
        super(props);
  
        this.state = {
          data : null
        };
      }

    getUserName() {
        // var url = rootURL + "/GetUser/"
        // fetch(url)
        // .then(resp => resp.text())
        // .then((data) => { this.setState({username: data}) } )
    }

    render() {
        
        // if (typeof this.state.username == 'undefined') {
        //     this.getUserName();
        // }

        return (
            // <div>
            //     <h3>Welcome { this.state.username }</h3>
            // </div>
            <div>
            <h3>Welcome Koala!</h3>
        </div>
        )
    };

}

export default WelcomeMsg;