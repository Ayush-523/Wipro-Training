import { useEffect, useState } from "react";

import API from "../api/api";

import Sidebar from "../components/Sidebar";

import { useNavigate } from "react-router-dom";

function Students() {

  const navigate = useNavigate();

  const [students, setStudents] =
    useState([]);

  const [courses, setCourses] =
    useState([]);

  const [formData, setFormData] =
    useState({

      name: "",
      email: "",
      status: "Active",
      courses: [],

    });

  useEffect(() => {

    fetchStudents();

    fetchCourses();

  }, []);

  const fetchStudents = async () => {

    try {

      const response =
        await API.get("/students");

      setStudents(response.data);

    } catch (error) {

      console.error(error);

    }
  };

  const fetchCourses = async () => {

    try {

      const response =
        await API.get("/courses");

      setCourses(response.data);

    } catch (error) {

      console.error(error);

    }
  };

  const handleChange = (e) => {

    const { name, value } =
      e.target;

    setFormData({

      ...formData,

      [name]: value,

    });
  };

  const handleCourseChange = (
    courseId
  ) => {

    const exists =
      formData.courses.includes(
        courseId
      );

    if (exists) {

      setFormData({

        ...formData,

        courses:
          formData.courses.filter(
            (id) => id !== courseId
          ),

      });

    } else {

      setFormData({

        ...formData,

        courses: [
          ...formData.courses,
          courseId,
        ],

      });
    }
  };

  const handleSubmit = async (
    e
  ) => {

    e.preventDefault();

    try {

      await API.post(
        "/students",
        formData
      );

      alert(
        "Student enrolled successfully"
      );

      setFormData({

        name: "",
        email: "",
        status: "Active",
        courses: [],

      });

      fetchStudents();

    } catch (error) {

      console.error(error);

      alert(
        "Enrollment failed"
      );
    }
  };

  const deleteStudent = async (
    id
  ) => {

    const confirmDelete =
      window.confirm(
        "Delete this student?"
      );

    if (!confirmDelete) {

      return;
    }

    try {

      await API.delete(
        `/students/${id}`
      );

      alert(
        "Student deleted successfully"
      );

      fetchStudents();

    } catch (error) {

      console.error(error);

      alert(
        "Delete failed"
      );
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

            Student Enrollment

          </h1>

          <p className="text-muted fs-5">

            Enroll students and assign
            courses dynamically

          </p>

        </div>

        {/* ENROLL FORM */}

        <div
          className="card border-0 shadow-lg p-4 mb-5"
          style={{
            borderRadius: "20px",
          }}
        >

          <h3 className="fw-bold mb-4">

            Enroll Student

          </h3>

          <form onSubmit={handleSubmit}>

            <div className="row g-4">

              {/* NAME */}

              <div className="col-md-6">

                <input
                  type="text"
                  name="name"
                  value={formData.name}
                  onChange={handleChange}
                  className="form-control p-3"
                  placeholder="Student Name"
                  required
                />

              </div>

              {/* EMAIL */}

              <div className="col-md-6">

                <input
                  type="email"
                  name="email"
                  value={formData.email}
                  onChange={handleChange}
                  className="form-control p-3"
                  placeholder="Student Email"
                  required
                />

              </div>

              {/* COURSES */}

              <div className="col-12">

                <label className="fw-bold mb-3">

                  Assign Courses

                </label>

                <div
                  className="border rounded p-4"
                  style={{
                    background: "#f8fafc",
                  }}
                >

                  {
                    courses.map((course) => (

                      <div
                        className="form-check mb-3"
                        key={course.id}
                      >

                        <input
                          type="checkbox"
                          className="form-check-input"

                          checked={
                            formData.courses.includes(
                              course.id
                            )
                          }

                          onChange={() =>
                            handleCourseChange(
                              course.id
                            )
                          }
                        />

                        <label
                          className="form-check-label fw-semibold"
                        >

                          {course.title}

                        </label>

                      </div>

                    ))
                  }

                </div>

              </div>

            </div>

            {/* BUTTON */}

            <button
              type="submit"
              className="btn btn-primary rounded-pill px-5 py-2 mt-4"
            >

              Enroll Student

            </button>

          </form>

        </div>

        {/* STUDENTS TABLE */}

        <div
          className="card border-0 shadow-lg p-4"
          style={{
            borderRadius: "20px",
          }}
        >

          <h3 className="fw-bold mb-4">

            Enrolled Students

          </h3>

          <div className="table-responsive">

            <table className="table table-hover align-middle">

              <thead className="table-dark">

                <tr>

                  <th>Name</th>

                  <th>Email</th>

                  <th>Status</th>

                  <th>Courses</th>

                  <th>Actions</th>

                </tr>

              </thead>

              <tbody>

                {
                  students.map((student) => (

                    <tr key={student.id}>

                      <td>

                        {student.name}

                      </td>

                      <td>

                        {student.email}

                      </td>

                      <td>

                        <span className="badge bg-success">

                          {student.status}

                        </span>

                      </td>

                      <td>

                        {
                          student.courses?.length > 0

                            ? (

                                student.courses.map(
                                  (course) => (

                                    <span
                                      key={course.id}
                                      className="badge bg-primary me-2"
                                    >

                                      {course.title}

                                    </span>

                                  )
                                )

                              )

                            : (

                                <span className="text-muted">

                                  No Courses

                                </span>

                              )
                        }

                      </td>

                      {/* ACTIONS */}

                      <td>

                        <button
                          className="btn btn-danger btn-sm rounded-pill px-3"

                          onClick={() =>
                            deleteStudent(
                              student.id
                            )
                          }
                        >

                          Delete

                        </button>

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

export default Students;