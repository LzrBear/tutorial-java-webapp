import React from "react";
import config from 'react-global-configuration';

const rootURL = config.get("rootURL");

class Config extends React.Component {
     
    constructor(props) {
        super(props);
  
        this.state = {
          selectedFile : null // Initially, no file is selected 
        };
    }

    // On file select (from the pop up) 
    onFileChange = event => { 
        // Update the state 
        this.setState({ selectedFile: event.target.files[0] }); 
    };

     // On file upload (click the upload button) 
    onFileUpload = () => { 
     
        // Create an object of formData 
        const formData = new FormData(); 
        
        // Update the formData object 
        formData.append( 
            "configurationPropertiesFile", 
            this.state.selectedFile, 
            this.state.selectedFile.name 
        ); 
        
        // Details of the uploaded file 
        console.log(this.state.selectedFile); 
        
        // Request made to the backend api 
        // Send formData object 
        //axios.post("api/uploadfile", formData); 

        var url = rootURL + "/Config/Upload"
        fetch(url, {
            method: 'post',
            body: formData
        })
        .then(resp => resp.json() )
        .then((data) => { console.log(data) } )
    }; 

    render() {
        return (
            <div>
                <h3>Configuration</h3>
                <input type="file" accept=".properties" onChange={this.onFileChange} />
                <button onClick={this.onFileUpload}>
                    Upload
                </button>
                {/* <button onClick={this.getLogs}>
                    Download
                </button> */}
            </div>
        )
    };

}

export default Config;