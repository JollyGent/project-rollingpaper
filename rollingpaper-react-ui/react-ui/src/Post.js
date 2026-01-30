import { useState } from "react";

const Post = () => {

    const [message, setMessage] = useState('');

    const data = {
        message
    }

    const postMessage = (e) => {

        //fetch(`${process.env.REACT_APP_API_URL}`, {
        fetch("api/v1/messages", {
            method : 'POST',
            headers: {"Content-Type" : "application/json"},
            body: JSON.stringify(data)
        }).then(() => {
            console.log("message posted");
        })
    }

    return (
        <div>
            <form onSubmit={postMessage}>
                <input className="Message" 
                       placeholder="Say something about me..."
                       onChange={(e) => setMessage(e.target.value)}/>
                <br/>
                <button>Post</button>
            </form>
        </div>
    );
}

export default Post