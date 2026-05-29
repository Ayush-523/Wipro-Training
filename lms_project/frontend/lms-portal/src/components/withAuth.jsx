import { Navigate } from "react-router-dom";

function WithAuth({ children }) {

  const isLoggedIn =
    localStorage.getItem("isLoggedIn");

  if (!isLoggedIn) {

    return <Navigate to="/login" />;
  }

  return children;
}

export default WithAuth;