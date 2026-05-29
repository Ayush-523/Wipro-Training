import { NavLink, Link } from 'react-router-dom'

const Header = () => {
  return (
    <nav className="navbar navbar-expand-lg lms-navbar px-3 py-2">
      <div className="container">
        <Link className="navbar-brand fw-bold text-warning navbar-brand" to="/">
          🎓 LearnHub
        </Link>

        <button className="navbar-toggler border-secondary" type="button"
          data-bs-toggle="collapse" data-bs-target="#navbarNav">
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarNav">
          <ul className="navbar-nav mx-auto gap-1">
            {[
              { to: '/',         label: 'Home'      },
              { to: '/courses',  label: 'Courses'   },
              { to: '/dashboard',label: 'Dashboard' },
              { to: '/students', label: 'Students'  },
              { to: '/faculty',  label: 'Faculty'   },
              { to: '/contact',  label: 'Contact'   },
            ].map(({ to, label }) => (
              <li className="nav-item" key={to}>
                <NavLink
                  className={({ isActive }) =>
                    `nav-link text-white fw-medium px-3 py-2 rounded ${isActive ? 'active' : ''}`
                  }
                  to={to}
                  end={to === '/'}
                >
                  {label}
                </NavLink>
              </li>
            ))}
          </ul>

          <div className="d-flex gap-2 align-items-center">
            <Link className="btn btn-outline-light btn-sm px-3 rounded-pill" to="/login">
              Sign In
            </Link>
            <Link className="btn btn-warning btn-sm px-3 fw-bold rounded-pill" to="/login">
              Get Started
            </Link>
          </div>
        </div>
      </div>
    </nav>
  )
}

export default Header
