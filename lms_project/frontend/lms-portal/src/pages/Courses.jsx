import React, { useEffect, useState } from "react";
import axios from "axios";

function Courses() {

  const [courses, setCourses] = useState([]);

  const [formData, setFormData] = useState({
    title: "",
    instructor: "",
    category: "",
    level: "",
    description: "",
  });

  useEffect(() => {
    fetchCourses();
  }, []);

  const fetchCourses = async () => {

    try {

      const response = await axios.get(
        "http://localhost:8080/api/courses"
      );

      setCourses(response.data);

    } catch (error) {

      console.log(error);

    }

  };

  const handleChange = (e) => {

    setFormData({
      ...formData,
      [e.target.name]: e.target.value,
    });

  };

  const addCourse = async () => {

    try {

      await axios.post(
        "http://localhost:8080/api/courses",
        formData
      );

      alert("Course Added Successfully");

      setFormData({
        title: "",
        instructor: "",
        category: "",
        level: "",
        description: "",
      });

      fetchCourses();

    } catch (error) {

      console.log(error);

      alert("Operation Failed");

    }

  };

  const deleteCourse = async (id) => {

    try {

      await axios.delete(
        `http://localhost:8080/api/courses/${id}`
      );

      fetchCourses();

    } catch (error) {

      console.log(error);

    }

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

        <button
          style={sidebarBtn}
          onClick={() => window.location.href = "/dashboard"}
        >
          Dashboard
        </button>

        <button
          style={sidebarBtn}
        >
          Manage Courses
        </button>

        <button
          style={sidebarBtn}
          onClick={() => window.location.href = "/students"}
        >
          Manage Students
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
            onClick={() => {

              localStorage.clear();

              window.location.href = "/login";

            }}
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
          Course Management
        </h1>

        <p
          style={{
            color: "#555",
            marginBottom: "30px",
            fontSize: "22px",
          }}
        >
          Add and manage LMS courses
        </p>

        {/* Form Card */}

        <div style={card}>

          <h2
            style={{
              marginBottom: "25px",
              fontSize: "24px",
            }}
          >
            Add Course
          </h2>

          <div style={grid}>

            <input
              type="text"
              name="title"
              placeholder="Course Title"
              value={formData.title}
              onChange={handleChange}
              style={input}
            />

            <input
              type="text"
              name="instructor"
              placeholder="Instructor"
              value={formData.instructor}
              onChange={handleChange}
              style={input}
            />

            <input
              type="text"
              name="category"
              placeholder="Category"
              value={formData.category}
              onChange={handleChange}
              style={input}
            />

            <input
              type="text"
              name="level"
              placeholder="Level"
              value={formData.level}
              onChange={handleChange}
              style={input}
            />

          </div>

          <textarea
            name="description"
            placeholder="Course Description"
            value={formData.description}
            onChange={handleChange}
            style={textarea}
          />

          <button
            onClick={addCourse}
            style={addBtn}
          >
            Add Course
          </button>

        </div>

        {/* Courses */}

        <div style={card}>

          <h2
            style={{
              marginBottom: "20px",
              fontSize: "24px",
            }}
          >
            Available Courses
          </h2>

          <table
            style={{
              width: "100%",
              borderCollapse: "collapse",
            }}
          >

            <thead>

              <tr
                style={{
                  background: "#1f2937",
                  color: "white",
                }}
              >

                <th style={th}>ID</th>
                <th style={th}>Title</th>
                <th style={th}>Instructor</th>
                <th style={th}>Category</th>
                <th style={th}>Level</th>
                <th style={th}>Actions</th>

              </tr>

            </thead>

            <tbody>

              {courses.map((course) => (

                <tr key={course.id}>

                  <td style={td}>{course.id}</td>
                  <td style={td}>{course.title}</td>
                  <td style={td}>{course.instructor}</td>
                  <td style={td}>{course.category}</td>
                  <td style={td}>{course.level}</td>

                  <td style={td}>

                    <button
                      onClick={() => deleteCourse(course.id)}
                      style={deleteBtn}
                    >
                      Delete
                    </button>

                  </td>

                </tr>

              ))}

            </tbody>

          </table>

        </div>

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

const card = {
  background: "white",
  padding: "25px",
  borderRadius: "20px",
  marginBottom: "40px",
  boxShadow: "0 4px 10px rgba(0,0,0,0.05)",
};

const grid = {
  display: "grid",
  gridTemplateColumns: "1fr 1fr",
  gap: "20px",
};

const input = {
  padding: "16px",
  border: "1px solid #ddd",
  borderRadius: "10px",
  fontSize: "16px",
};

const textarea = {
  width: "100%",
  marginTop: "20px",
  minHeight: "150px",
  padding: "16px",
  borderRadius: "10px",
  border: "1px solid #ddd",
  fontSize: "16px",
};

const addBtn = {
  marginTop: "20px",
  background: "#2563eb",
  color: "white",
  border: "none",
  padding: "14px 30px",
  borderRadius: "12px",
  cursor: "pointer",
  fontSize: "16px",
};

const th = {
  padding: "15px",
  textAlign: "left",
};

const td = {
  padding: "15px",
  borderBottom: "1px solid #eee",
};

const deleteBtn = {
  background: "#ef4444",
  color: "white",
  border: "none",
  padding: "10px 18px",
  borderRadius: "10px",
  cursor: "pointer",
};

export default Courses;