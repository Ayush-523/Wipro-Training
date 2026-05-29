import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {

  const navigate = useNavigate();

  const [username, setUsername] =
    useState("");

  const [password, setPassword] =
    useState("");

  const [error, setError] =
    useState("");

  const handleLogin = (e) => {

    e.preventDefault();

    // ADMIN LOGIN

    if (
      username === "admin" &&
      password === "admin123"
    ) {

      localStorage.setItem(
        "isLoggedIn",
        "true"
      );

      localStorage.setItem(
        "role",
        "ADMIN"
      );

      localStorage.setItem(
        "username",
        username
      );

      navigate("/dashboard");

    }

    // STUDENT LOGIN

    else if (
      username === "student" &&
      password === "student123"
    ) {

      localStorage.setItem(
        "isLoggedIn",
        "true"
      );

      localStorage.setItem(
        "role",
        "STUDENT"
      );

      localStorage.setItem(
        "username",
        username
      );

      navigate("/student-dashboard");

    }

    // INVALID LOGIN

    else {

      setError(
        "Invalid username or password"
      );

    }

  };

  return (

    <div
      className="container-fluid d-flex justify-content-center align-items-center"
      style={{
        minHeight: "100vh",
        background:
          "linear-gradient(135deg,#0f172a,#1e293b)",
      }}
    >

      <div className="col-lg-4 col-md-6">

        <div
          className="lms-card"
          style={{
            padding: "40px",
            borderRadius: "24px",
          }}
        >

          <div className="text-center mb-4">

            <h1 className="dashboard-title">
              LMS <span>Login</span>
            </h1>

            <p className="dashboard-subtitle">
              Login to continue
            </p>

          </div>

          {error && (

            <div className="alert alert-danger">

              {error}

            </div>

          )}

          <form onSubmit={handleLogin}>

            <div className="mb-3">

              <label className="form-label fw-bold">
                Username
              </label>

              <input
                type="text"
                className="form-control"
                value={username}
                onChange={(e) =>
                  setUsername(e.target.value)
                }
                required
              />

            </div>

            <div className="mb-4">

              <label className="form-label fw-bold">
                Password
              </label>

              <input
                type="password"
                className="form-control"
                value={password}
                onChange={(e) =>
                  setPassword(e.target.value)
                }
                required
              />

            </div>

            <button
              type="submit"
              className="btn-primary-lms"
            >
              Login
            </button>

          </form>

        </div>

      </div>

    </div>

  );
}

export default Login;