import { Link } from 'react-router-dom'

const Footer = () => (
  <footer className="lms-footer">
    <div className="container">
      <div className="row g-4">
        <div className="col-md-4">
          <div className="footer-brand mb-2">🎓 LearnHub</div>
          <p style={{ fontSize: '0.87rem', color: '#64748b', lineHeight: 1.7 }}>
            Empowering learners with industry-ready skills through expert-led courses
            and hands-on projects.
          </p>
        </div>
        <div className="col-md-2 col-6">
          <div style={{ fontSize: '0.78rem', fontWeight: 700, textTransform: 'uppercase', letterSpacing: '.5px', color: '#94a3b8', marginBottom: '0.75rem' }}>Platform</div>
          {['Courses', 'Dashboard', 'Students', 'Faculty'].map(l => (
            <Link key={l} to={`/${l.toLowerCase()}`} className="footer-link">{l}</Link>
          ))}
        </div>
        <div className="col-md-2 col-6">
          <div style={{ fontSize: '0.78rem', fontWeight: 700, textTransform: 'uppercase', letterSpacing: '.5px', color: '#94a3b8', marginBottom: '0.75rem' }}>Company</div>
          {['About Us', 'Careers', 'Blog', 'Press'].map(l => (
            <a key={l} href="#" className="footer-link">{l}</a>
          ))}
        </div>
        <div className="col-md-4">
          <div style={{ fontSize: '0.78rem', fontWeight: 700, textTransform: 'uppercase', letterSpacing: '.5px', color: '#94a3b8', marginBottom: '0.75rem' }}>Newsletter</div>
          <p style={{ fontSize: '0.82rem', color: '#64748b', marginBottom: '0.75rem' }}>Get weekly learning tips & new course alerts.</p>
          <div className="d-flex gap-2">
            <input type="email" placeholder="your@email.com"
              style={{ flex: 1, padding: '8px 12px', borderRadius: '8px', border: '1px solid #334155', background: '#1e293b', color: 'white', fontSize: '0.85rem', outline: 'none' }} />
            <button style={{ background: '#4f46e5', color: 'white', border: 'none', padding: '8px 16px', borderRadius: '8px', fontWeight: 600, cursor: 'pointer', fontSize: '0.85rem' }}>
              Subscribe
            </button>
          </div>
        </div>
      </div>
      <hr className="footer-divider" />
      <div className="d-flex justify-content-between align-items-center flex-wrap gap-2">
        <span className="footer-copy">© 2026 LearnHub. All rights reserved.</span>
        <div className="d-flex gap-3">
          {['Privacy', 'Terms', 'Cookies'].map(l => (
            <a key={l} href="#" style={{ fontSize: '0.82rem', color: '#475569', textDecoration: 'none' }}>{l}</a>
          ))}
        </div>
      </div>
    </div>
  </footer>
)

export default Footer
