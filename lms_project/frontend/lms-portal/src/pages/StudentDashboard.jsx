import React, { useEffect, useState } from "react";
import axios from "axios";

function StudentDashboard() {

  const [courses, setCourses] = useState([]);
  const [studentName, setStudentName] = useState("Student");
  const [selectedCourse, setSelectedCourse] = useState(null);

  useEffect(() => {

    const username =
      localStorage.getItem("loggedInUser");

    const displayName =
      localStorage.getItem("displayName");

    if (displayName) {
      setStudentName(displayName);
    }

    fetchStudentCourses(username);

  }, []);

  const fetchStudentCourses = async (username) => {

    try {

      const response = await axios.get(
        `http://localhost:8086/api/students/dashboard/${username}`
      );

      setCourses(response.data);

    } catch (error) {

      console.log(error);

    }

  };

  const logout = () => {

    localStorage.clear();

    window.location.href = "/login";

  };

  return (

    <div
      style={{
        display: "flex",
        minHeight: "100vh",
        background: "#f3f4f6",
      }}
    >

      {/* Sidebar */}

      <div
        style={{
          width: "220px",
          background: "#020817",
          color: "white",
          padding: "20px",
        }}
      >

        <h1
          style={{
            color: "#facc15",
            fontSize: "28px",
            marginBottom: "40px",
          }}
        >
          LMS Portal
        </h1>

        <button style={sidebarBtn}>
          Dashboard
        </button>

      </div>

      {/* Main Content */}

      <div
        style={{
          flex: 1,
          padding: "40px",
        }}
      >

        {/* Top Buttons */}

        <div
          style={{
            display: "flex",
            justifyContent: "space-between",
            alignItems: "center",
            marginBottom: "20px",
          }}
        >

          <button
            onClick={() => window.history.back()}
            style={backBtn}
          >
            ← Back
          </button>

          <button
            onClick={logout}
            style={logoutBtn}
          >
            Logout
          </button>

        </div>

        {/* Heading */}

        <h1
          style={{
            fontSize: "48px",
            fontWeight: "bold",
            marginBottom: "10px",
          }}
        >
          Welcome {studentName}
        </h1>

        <p
          style={{
            color: "#555",
            marginBottom: "30px",
            fontSize: "22px",
          }}
        >
          View your enrolled courses and assignments
        </p>

        {/* Course Cards */}

        <div
          style={{
            display: "grid",
            gridTemplateColumns:
              "repeat(auto-fit,minmax(350px,1fr))",
            gap: "25px",
          }}
        >

          {courses.map((course) => (

            <div
              key={course.id}
              style={courseCard}
            >

              <div
                style={{
                  display: "flex",
                  justifyContent: "space-between",
                  alignItems: "center",
                  marginBottom: "15px",
                }}
              >

                <h2
                  style={{
                    margin: 0,
                  }}
                >
                  {course.title}
                </h2>

                <span style={badge}>
                  {course.level}
                </span>

              </div>

              <p
                style={{
                  color: "#555",
                  marginBottom: "15px",
                }}
              >
                {course.description}
              </p>

              <p>
                <strong>Instructor:</strong>{" "}
                {course.instructor}
              </p>

              <p>
                <strong>Category:</strong>{" "}
                {course.category}
              </p>

              <div style={assignmentBox}>

                <h3
                  style={{
                    marginBottom: "10px",
                  }}
                >
                  Assignments
                </h3>

                <ul>

                  <li>Complete weekly tasks</li>

                  <li>Submit mini project</li>

                  <li>Complete quizzes</li>

                </ul>

              </div>

              <button
                style={viewBtn}
                onClick={() =>
                  setSelectedCourse(course)
                }
              >
                View Course
              </button>

            </div>

          ))}

        </div>

        {/* Course Details */}

        {selectedCourse && (

          <div style={detailsCard}>

            <h1
              style={{
                marginBottom: "20px",
              }}
            >
              {selectedCourse.title}
            </h1>

            <p>
              <strong>Instructor:</strong>{" "}
              {selectedCourse.instructor}
            </p>

            <p>
              <strong>Category:</strong>{" "}
              {selectedCourse.category}
            </p>

            <p>
              <strong>Level:</strong>{" "}
              {selectedCourse.level}
            </p>

            <p>
              <strong>Description:</strong>
            </p>

            <div style={descriptionBox}>
              {selectedCourse.description}
            </div>

          </div>

        )}

      </div>

    </div>

  );

}

const sidebarBtn = {
  width: "100%",
  padding: "14px",
  marginBottom: "15px",
  background: "transparent",
  border: "1px solid #374151",
  color: "white",
  borderRadius: "10px",
  cursor: "pointer",
  fontSize: "16px",
};

const backBtn = {
  background: "#111827",
  color: "white",
  border: "none",
  padding: "12px 24px",
  borderRadius: "30px",
  cursor: "pointer",
  fontSize: "16px",
};

const logoutBtn = {
  background: "#ef4444",
  color: "white",
  border: "none",
  padding: "12px 24px",
  borderRadius: "30px",
  cursor: "pointer",
  fontSize: "16px",
};

const courseCard = {
  background: "white",
  padding: "25px",
  borderRadius: "20px",
  boxShadow: "0 4px 10px rgba(0,0,0,0.05)",
};

const badge = {
  background: "#2563eb",
  color: "white",
  padding: "8px 14px",
  borderRadius: "10px",
  fontSize: "14px",
};

const assignmentBox = {
  background: "#f9fafb",
  padding: "15px",
  borderRadius: "10px",
  marginTop: "20px",
};

const viewBtn = {
  marginTop: "20px",
  background: "#2563eb",
  color: "white",
  border: "none",
  padding: "12px 20px",
  borderRadius: "10px",
  cursor: "pointer",
};

const detailsCard = {
  background: "white",
  marginTop: "40px",
  padding: "30px",
  borderRadius: "20px",
  boxShadow: "0 4px 10px rgba(0,0,0,0.05)",
};

const descriptionBox = {
  marginTop: "15px",
  background: "#f9fafb",
  padding: "20px",
  borderRadius: "12px",
  lineHeight: "1.8",
};

export default StudentDashboard;