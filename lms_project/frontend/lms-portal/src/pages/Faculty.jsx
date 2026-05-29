function Faculty({
  faculty,
  setFaculty,
}) {

  const deleteFaculty = (id) => {

    const updatedFaculty =
      faculty.filter(
        (item) => item.id !== id
      );

    setFaculty(updatedFaculty);
  };

  return (

    <div className="container py-5">

      <div className="dashboard-header">

        <h1 className="dashboard-title">
          Faculty <span>Management</span>
        </h1>

        <p className="dashboard-subtitle">
          Manage instructors and mentors
        </p>

      </div>

      <div className="row g-4">

        {faculty.map((item) => (

          <div
            className="col-lg-4 col-md-6"
            key={item.id}
          >

            <div className="dashboard-card h-100">

              <div className="d-flex align-items-center gap-3 mb-3">

                <div
                  className="student-avatar"
                  style={{
                    background: item.color,
                    width: "60px",
                    height: "60px",
                  }}
                >
                  {item.avatar}
                </div>

                <div>

                  <div className="fw-bold">
                    {item.name}
                  </div>

                  <small className="text-muted">
                    {item.role}
                  </small>

                </div>

              </div>

              <div className="mb-3">

                <div className="small text-muted mb-2">
                  Courses:
                </div>

                {item.courses.map((course) => (

                  <span
                    key={course}
                    className="badge bg-primary me-2"
                  >
                    {course}
                  </span>

                ))}

              </div>

              <div className="mb-2">
                ⭐ {item.rating} Rating
              </div>

              <div className="mb-2">
                👨‍🎓 {item.students} Students
              </div>

              <div className="mb-4">
                💼 {item.exp} Experience
              </div>

              <button
                className="btn btn-danger rounded-pill w-100"
                onClick={() =>
                  deleteFaculty(item.id)
                }
              >
                Delete Faculty
              </button>

            </div>

          </div>

        ))}

      </div>

    </div>

  );
}

export default Faculty;