import { Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Login from "./pages/Login";
import Courses from "./pages/Courses";
import Students from "./pages/Students";
import Dashboard from "./pages/Dashboard";
import StudentDashboard from "./pages/StudentDashboard";
import CourseDetails from "./pages/CourseDetails";

import WithAuth from "./components/withAuth";

function App() {

  return (

    <Routes>

      <Route
        path="/"
        element={<Home />}
      />

      <Route
        path="/login"
        element={<Login />}
      />

      <Route
        path="/courses"
        element={<Courses />}
      />

      <Route
        path="/courses/:id"
        element={<CourseDetails />}
      />

      <Route
        path="/dashboard"
        element={
          <WithAuth>
            <Dashboard />
          </WithAuth>
        }
      />

      <Route
        path="/student-dashboard"
        element={
          <WithAuth>
            <StudentDashboard />
          </WithAuth>
        }
      />

      <Route
        path="/students"
        element={
          <WithAuth>
            <Students />
          </WithAuth>
        }
      />

    </Routes>
  );
}

export default App;