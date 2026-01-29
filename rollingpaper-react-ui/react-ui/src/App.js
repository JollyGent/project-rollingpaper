
import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import Post from './Post';
import { Route, Router } from 'react-router-dom';


const App = () => {

  const [messages, setMessage] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('api/v1/messages')
      .then(response => response.json())
      .then(data => {
        setMessage(data);
        setLoading(false);
      })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }
<img src={logo} className="App-logo" alt="logo" />

  return (
    <div className="App">
      <header className="App-header">
        <h1 style={{color:'#1C1C1C'}}>RollingPaper</h1>

        <Post/>
        
        <div className="App-intro">
          {messages.map(message =>
            <div key={message.id}>
              {message.message}
            </div>
          )}
        </div>


      </header>
    </div>
  );
}

export default App;
