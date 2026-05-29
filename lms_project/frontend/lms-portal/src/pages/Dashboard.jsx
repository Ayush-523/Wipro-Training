import { useEffect, useState } from "react";

import { Link, useNavigate } from "react-router-dom";

import API from "../api/api";

import Sidebar from "../components/Sidebar";

function Dashboard() {

  const navigate = useNavigate();

  const [courses, setCourses] =
    useState([]);

  const [students, setStudents] =
    useState([]);

  useEffect(() => {

    fetchData();

  }, []);

  const fetchData = async () => {

    try {

      const courseResponse =
        await API.get("/courses");

      const studentResponse =
        await API.get("/students");

      setCourses(courseResponse.data);

      setStudents(studentResponse.data);

    } catch (error) {

      console.error(error);

    }
  };

  const logout = () => {

    localStorage.clear();

    navigate("/login");
  };

  return (

    <div className="d-flex">

      <Sidebar role="admin" />

      <div className="container-fluid p-5 bg-light min-vh-100">

        {/* TOP BUTTONS */}

        <div className="d-flex justify-content-between mb-4">

          <button
            className="btn btn-dark rounded-pill px-4"
            onClick={() => navigate(-1)}
          >
            ← Back
          </button>

          <button
            className="btn btn-danger rounded-pill px-4"
            onClick={logout}
          >
            Logout
          </button>

        </div>

        {/* TITLE */}

        <div className="mb-5">

          <h1 className="fw-bold display-5">

            Admin Dashboard

          </h1>

          <p className="text-muted fs-5">

            Manage courses and students
            dynamically from database

          </p>

        </div>

        {/* STATS */}

        <div className="row g-4 mb-5">

          <div className="col-md-4">

            <div
              className="card border-0 shadow-lg p-4 text-center h-100"
              style={{
                borderRadius: "20px",
              }}
            >

              <h1 className="fw-bold text-primary">

                {courses.length}

              </h1>

              <h5 className="text-muted">

                Total Courses

              </h5>

            </div>

          </div>

          <div className="col-md-4">

            <div
              className="card border-0 shadow-lg p-4 text-center h-100"
              style={{
                borderRadius: "20px",
              }}
            >

              <h1 className="fw-bold text-success">

                {students.length}

              </h1>

              <h5 className="text-muted">

                Total Students

              </h5>

            </div>

          </div>

          <div className="col-md-4">

            <div
              className="card border-0 shadow-lg p-4 text-center h-100"
              style={{
                borderRadius: "20px",
              }}
            >

              <h1 className="fw-bold text-warning">

                Active

              </h1>

              <h5 className="text-muted">

                LMS Status

              </h5>

            </div>

          </div>

        </div>

        {/* COURSES */}

        <div
          className="card border-0 shadow-lg p-4 mb-5"
          style={{
            borderRadius: "20px",
          }}
        >

          <div className="d-flex justify-content-between align-items-center mb-4">

            <h3 className="fw-bold">

              Courses

            </h3>

            <Link
              to="/courses"
              className="btn btn-primary rounded-pill px-4"
            >

              Manage Courses

            </Link>

          </div>

          <div className="table-responsive">

            <table className="table table-hover align-middle">

              <thead className="table-dark">

                <tr>

                  <th>ID</th>

                  <th>Title</th>

                  <th>Instructor</th>

                  <th>Category</th>

                  <th>Level</th>

                </tr>

              </thead>

              <tbody>

                {
                  courses.map((course) => (

                    <tr key={course.id}>

                      <td>{course.id}</td>

                      <td>{course.title}</td>

                      <td>{course.instructor}</td>

                      <td>{course.category}</td>

                      <td>{course.level}</td>

                    </tr>

                  ))
                }

              </tbody>

            </table>

          </div>

        </div>

        {/* STUDENTS */}

        <div
          className="card border-0 shadow-lg p-4"
          style={{
            borderRadius: "20px",
          }}
        >

          <div className="d-flex justify-content-between align-items-center mb-4">

            <h3 className="fw-bold">

              Students

            </h3>

            <Link
              to="/students"
              className="btn btn-success rounded-pill px-4"
            >

              Manage Students

            </Link>

          </div>

          <div className="table-responsive">

            <table className="table table-hover align-middle">

              <thead className="table-dark">

                <tr>

                  <th>ID</th>

                  <th>Name</th>

                  <th>Email</th>

                  <th>Status</th>

                </tr>

              </thead>

              <tbody>

                {
                  students.map((student) => (

                    <tr key={student.id}>

                      <td>{student.id}</td>

                      <td>{student.name}</td>

                      <td>{student.email}</td>

                      <td>

                        <span className="badge bg-success">

                          {student.status}

                        </span>

                      </td>

                    </tr>

                  ))
                }

              </tbody>

            </table>

          </div>

        </div>

      </div>

    </div>
  );
}

export default Dashboard;