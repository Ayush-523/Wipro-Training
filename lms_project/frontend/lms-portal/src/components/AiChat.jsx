import { useState } from "react";

import API from "../api/api";

function AiChat() {

  const [message, setMessage] =
    useState("");

  const [chat, setChat] =
    useState([]);

  const [loading, setLoading] =
    useState(false);

  const sendMessage = async () => {

    if (!message.trim()) {

      return;
    }

    const userMessage = {

      sender: "user",

      text: message,

    };

    setChat((prev) => [

      ...prev,

      userMessage,

    ]);

    setLoading(true);

    try {

      const response =
        await API.post(
          "/ai/chat",
          {
            message,
          }
        );

      const aiMessage = {

        sender: "ai",

        text: response.data,

      };

      setChat((prev) => [

        ...prev,

        aiMessage,

      ]);

      setMessage("");

    } catch (error) {

      console.error(error);

      alert(
        "AI request failed"
      );
    }

    setLoading(false);
  };

  return (

    <div
      className="card shadow-lg border-0 p-4 mt-5"
      style={{
        borderRadius: "20px",
      }}
    >

      <h2 className="fw-bold mb-4">

        AI Tutor Assistant

      </h2>

      <div
        style={{
          height: "400px",
          overflowY: "auto",
          background: "#f8fafc",
          padding: "20px",
          borderRadius: "15px",
        }}
      >

        {
          chat.map((msg, index) => (

            <div
              key={index}

              className={`mb-3 d-flex ${
                msg.sender === "user"

                  ? "justify-content-end"

                  : "justify-content-start"
              }`}
            >

              <div
                className={`p-3 rounded-4 ${
                  msg.sender === "user"

                    ? "bg-primary text-white"

                    : "bg-light"
                }`}
                style={{
                  maxWidth: "75%",
                }}
              >

                {msg.text}

              </div>

            </div>

          ))
        }

        {
          loading && (

            <p className="text-muted">

              AI is typing...

            </p>

          )
        }

      </div>

      <div className="d-flex gap-3 mt-4">

        <input
          type="text"

          className="form-control p-3"

          placeholder="Ask AI anything..."

          value={message}

          onChange={(e) =>
            setMessage(
              e.target.value
            )
          }
        />

        <button
          className="btn btn-primary px-4"

          onClick={sendMessage}
        >

          Send

        </button>

      </div>

    </div>
  );
}

export default AiChat;