
import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import Post from './Post';
import Card from '@mui/material/Card';
import Typography from '@mui/material/Typography';
import CardContent from '@mui/material/CardContent';





const App = () => {

  const [messages, setMessages] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    // setLoading(true);
    
    fetchMessages();

    // fetch(`${process.env.REACT_APP_API_URL}/api/v1/messages`)
    //   .then(response => response.json())
    //   .then(data => {
    //     setMessage(data);
    //     setLoading(false);
    //   })
  }, []);

  const fetchMessages = async () => {
    const response = await fetch(`${process.env.REACT_APP_API_URL}`);
    const data = await response.json();
    setMessages(data);
  }

  if (loading) {
    return <p>Loading...</p>;
  }
<img src={logo} className="App-logo" alt="logo" />

  return (
    <div className="App">
      <header className="App-header">
        <img src="logo.png"/>
        <br/>

        <Post/>
        
        <div className="App-intro">
          
            {messages.map( (message) => (
              <div key={message.id}>
                <span className="ListStyle">
                  <Card>
                    <Typography >
                      {message.message}
                    </Typography>
                    <br/>
                    <br/>
                  </Card>
                </span>
              </div>
            ))}
          
        </div>


      </header>
    </div>
  );
}

export default App;
