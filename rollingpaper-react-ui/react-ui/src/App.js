import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import Card from '@mui/material/Card';
import Typography from '@mui/material/Typography';


const App = () => {

  const [messages, setMessages] = useState([]);
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchMessages();
  }, []);

  const fetchMessages = async () => {
    const response = await fetch(`${process.env.REACT_APP_API_URL}`);
    const data = await response.json();
    setMessages(data);
  };

  const postMessage = async() => {
    
     if(!message) return;
     const data = {message};
     const response = await fetch(`${process.env.REACT_APP_API_URL}`, {
        method : 'POST',
        headers: {'Content-Type' : 'application/json',},
        body: JSON.stringify(data)
        });

      if(response.ok) {
        setMessage('');
        fetchMessages();
      }
      else {
        setMessage("Bad Request - posting failed!")
      }
  };

<img src={logo} className="App-logo" alt="logo" />

  return (
    <div className="App">
      <header className="App-header">
        <img src="logo.png"/>
        <br/>

        <div className="App-intro">
            <div>
                <input className="Message"
                       value={message} 
                       placeholder="Say something about me..."
                       onChange={(e) => setMessage(e.target.value)}/>
                       
                <br/>
                <button onClick={postMessage}>Post</button>
            </div> 

            {messages.map( (message) => 
              <div key={message.id}>
                <span className="ListStyle">
                  <Card>
                    <Typography >
                      {message.message}
                    </Typography>
                    <br/>
                  </Card>
                </span>
              </div>
            )}
          
        </div>
      </header>
    </div>
  );
}

export default App;
