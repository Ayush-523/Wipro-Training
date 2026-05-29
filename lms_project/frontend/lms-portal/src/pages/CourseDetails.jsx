import React from "react";
import { useLocation, useNavigate } from "react-router-dom";

function CourseDetails() {

  const navigate = useNavigate();

  const location = useLocation();

  const course = location.state;

  const convertToEmbedUrl = (url) => {

    if (!url) return "";

    const videoId = url.split("v=")[1];

    return `https://www.youtube.com/embed/${videoId}`;
  };

  return (

    <div className="container py-5">

      <button
        className="btn btn-dark mb-4"
        onClick={() => navigate(-1)}
      >
        ← Back
      </button>

      <div className="card shadow-lg border-0 p-4">

        <h1 className="fw-bold mb-3">
          {course.title}
        </h1>

        <p>
          <strong>Instructor:</strong> {course.instructor}
        </p>

        <p>
          <strong>Category:</strong> {course.category}
        </p>

        <p>
          <strong>Level:</strong> {course.level}
        </p>

        <p>
          <strong>Description:</strong>
          <br />
          {course.description}
        </p>

        <hr />

        <h3 className="mb-3">
          Modules
        </h3>

        <div className="bg-light p-3 rounded mb-4">

          <pre style={{ whiteSpace: "pre-wrap" }}>
            {course.modules}
          </pre>

        </div>

        <h3 className="mb-3">
          Course Roadmap
        </h3>

        <div className="bg-light p-3 rounded mb-4">

          <pre style={{ whiteSpace: "pre-wrap" }}>
            {course.courseContent}
          </pre>

        </div>

        <h3 className="mb-3">
          Video Lecture
        </h3>

        <div className="ratio ratio-16x9 mb-4">

          <iframe
            src={convertToEmbedUrl(course.videoUrl)}
            title="Course Video"
            allowFullScreen
          ></iframe>

        </div>

        <h3 className="mb-3">
          Assignments
        </h3>

        <ul className="list-group">

          <li className="list-group-item">
            Complete Module Quiz
          </li>

          <li className="list-group-item">
            Submit Assignment PDF
          </li>

          <li className="list-group-item">
            Build Mini Project
          </li>

        </ul>

      </div>

    </div>
  );
}

export default CourseDetails;