import { Link } from "react-router-dom";

function Sidebar({ role }) {

  return (

    <div
      className="bg-dark text-white p-4 d-flex flex-column"
      style={{
        width: "260px",
        minHeight: "100vh",
      }}
    >

      <h2 className="fw-bold mb-5 text-warning">

        LMS Portal

      </h2>

      <div className="d-flex flex-column gap-3">

        {/* ADMIN SIDEBAR */}

        {
          role === "admin" && (

            <>

              <Link
                to="/dashboard"
                className="btn btn-outline-light text-start"
              >

                Dashboard

              </Link>

              <Link
                to="/courses"
                className="btn btn-outline-light text-start"
              >

                Manage Courses

              </Link>

              <Link
                to="/students"
                className="btn btn-outline-light text-start"
              >

                Manage Students

              </Link>

            </>

          )
        }

        {/* STUDENT SIDEBAR */}

        {
          role === "student" && (

            <>

              <Link
                to="/student-dashboard"
                className="btn btn-outline-light text-start"
              >

                Dashboard

              </Link>

            </>

          )
        }

      </div>

    </div>
  );
}

export default Sidebar;