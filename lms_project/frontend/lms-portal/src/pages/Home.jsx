import { useEffect, useState } from "react";
import { Link } from "react-router-dom";

import API from "../api/api";

function Home() {

  const [courses, setCourses] = useState([]);

  useEffect(() => {

    fetchCourses();

  }, []);

  const fetchCourses = async () => {

    try {

      const response =
        await API.get("/courses");

      setCourses(response.data);

    } catch (error) {

      console.error(error);

    }
  };

  return (

    <div>

      {/* HERO SECTION */}

      <section
        className="container-fluid text-white py-5"
        style={{
          background:
            "linear-gradient(to right, #0f172a, #1e293b)",
          minHeight: "90vh",
          display: "flex",
          alignItems: "center",
        }}
      >

        <div className="container">

          <div className="row align-items-center">

            <div className="col-lg-6">

              <h1
                className="fw-bold display-3 mb-4"
              >
                Learn Without
                <span className="text-warning">
                  {" "}Limits
                </span>
              </h1>

              <p
                className="lead mb-4"
                style={{
                  color: "#cbd5e1",
                }}
              >
                Modern LMS Portal using
                React + Spring Boot.
                Explore courses, manage
                students and continue
                your learning journey.
              </p>

              <div className="d-flex gap-3">

                <button
                  className="btn btn-warning fw-bold px-4 py-3 rounded-pill"
                  onClick={() => {

                    document
                      .getElementById(
                        "courses-section"
                      )
                      .scrollIntoView({
                        behavior: "smooth",
                      });

                  }}
                >
                  Explore Courses →
                </button>

                <Link
                  to="/login"
                  className="btn btn-outline-light px-4 py-3 rounded-pill"
                >
                  Login
                </Link>

              </div>

            </div>

            <div className="col-lg-6 text-center">

              <img
                src="https://cdn-icons-png.flaticon.com/512/3135/3135755.png"
                alt="LMS"
                className="img-fluid"
                style={{
                  maxWidth: "420px",
                }}
              />

            </div>

          </div>

        </div>

      </section>

      {/* FEATURES SECTION */}

      <section className="container py-5">

        <div className="text-center mb-5">

          <h2 className="fw-bold">
            Why Choose Our LMS?
          </h2>

          <p className="text-muted">
            Smart learning experience
            for students and admins.
          </p>

        </div>

        <div className="row g-4">

          <div className="col-md-4">

            <div
              className="card shadow border-0 h-100 p-4 text-center"
            >

              <div
                style={{
                  fontSize: "50px",
                }}
              >
                📚
              </div>

              <h4 className="fw-bold mt-3">
                Dynamic Courses
              </h4>

              <p className="text-muted">
                Courses are fetched
                directly from the backend
                database dynamically.
              </p>

            </div>

          </div>

          <div className="col-md-4">

            <div
              className="card shadow border-0 h-100 p-4 text-center"
            >

              <div
                style={{
                  fontSize: "50px",
                }}
              >
                👨‍🎓
              </div>

              <h4 className="fw-bold mt-3">
                Student Dashboard
              </h4>

              <p className="text-muted">
                Students can view
                assigned courses,
                mentors and assignments.
              </p>

            </div>

          </div>

          <div className="col-md-4">

            <div
              className="card shadow border-0 h-100 p-4 text-center"
            >

              <div
                style={{
                  fontSize: "50px",
                }}
              >
                ⚙️
              </div>

              <h4 className="fw-bold mt-3">
                Admin Control
              </h4>

              <p className="text-muted">
                Full course and student
                management with CRUD
                operations.
              </p>

            </div>

          </div>

        </div>

      </section>

      {/* COURSES SECTION */}

      <section
        className="container py-5"
        id="courses-section"
      >

        <div className="text-center mb-5">

          <h2 className="fw-bold">
            Available Courses
          </h2>

          <p className="text-muted">
            Explore all courses from
            backend database
          </p>

        </div>

        <div className="row g-4">

          {
            courses.map((course) => (

              <div
                className="col-md-4"
                key={course.id}
              >

                <div
                  className="card border-0 shadow-lg h-100"
                  style={{
                    borderRadius: "20px",
                  }}
                >

                  <div className="card-body p-4">

                    <h4 className="fw-bold mb-3">
                      {course.title}
                    </h4>

                    <p className="text-muted">
                      {course.description}
                    </p>

                    <div className="mb-2">

                      <strong>
                        Instructor:
                      </strong>{" "}

                      {course.instructor}

                    </div>

                    <div className="mb-2">

                      <strong>
                        Category:
                      </strong>{" "}

                      {course.category}

                    </div>

                    <div className="mb-3">

                      <strong>
                        Level:
                      </strong>{" "}

                      {course.level}

                    </div>

                    <button
                      className="btn btn-primary rounded-pill w-100"
                    >
                      View Course
                    </button>

                  </div>

                </div>

              </div>

            ))
          }

        </div>

      </section>

      {/* FOOTER */}

      <footer
        className="text-center text-white py-4"
        style={{
          background: "#0f172a",
        }}
      >

        <h5 className="mb-2">
          LMS Portal
        </h5>

        <p
          style={{
            color: "#cbd5e1",
          }}
        >
          React + Spring Boot Learning
          Management System
        </p>

      </footer>

    </div>
  );
}

export default Home;