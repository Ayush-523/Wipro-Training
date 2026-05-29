import { useState } from 'react'

function ContactUs() {
  const [form, setForm] = useState({ name: '', email: '', subject: '', message: '' })
  const [sent, setSent] = useState(false)

  const handleSubmit = (e) => {
    e.preventDefault()
    setSent(true)
    setTimeout(() => setSent(false), 4000)
    setForm({ name: '', email: '', subject: '', message: '' })
  }

  const contacts = [
    { icon: '📧', label: 'Email',   value: 'support@learnhub.com',  sub: 'We reply within 24 hours' },
    { icon: '📞', label: 'Phone',   value: '+91 98765 43210',         sub: 'Mon–Fri, 9 AM to 6 PM' },
    { icon: '📍', label: 'Address', value: 'Bengaluru, Karnataka',    sub: 'India 560001' },
    { icon: '💬', label: 'Discord', value: 'discord.gg/learnhub',     sub: 'Community & support' },
  ]

  return (
    <div className="page-wrapper">
      <div className="container">
        <div className="section-header text-center mb-5">
          <div className="section-label">Get In Touch</div>
          <div className="section-title">We'd Love to <span>Hear From You</span></div>
          <p style={{ color: '#64748b', marginTop: '0.5rem', maxWidth: '480px', margin: '0.5rem auto 0' }}>
            Have a question, feedback or want to partner with us? Reach out anytime.
          </p>
        </div>

        <div className="row g-4">
          {/* Contact Info */}
          <div className="col-lg-4">
            <div className="d-flex flex-column gap-3">
              {contacts.map(c => (
                <div key={c.label} className="lms-card d-flex align-items-center gap-3">
                  <div style={{ width: 48, height: 48, background: '#eef2ff', borderRadius: '12px', display: 'flex', alignItems: 'center', justifyContent: 'center', fontSize: '1.3rem', flexShrink: 0 }}>
                    {c.icon}
                  </div>
                  <div>
                    <div style={{ fontSize: '0.75rem', color: '#94a3b8', fontWeight: 700, textTransform: 'uppercase', letterSpacing: '.5px' }}>{c.label}</div>
                    <div style={{ fontWeight: 600, fontSize: '0.9rem', marginTop: '2px' }}>{c.value}</div>
                    <div style={{ fontSize: '0.78rem', color: '#64748b' }}>{c.sub}</div>
                  </div>
                </div>
              ))}
            </div>
          </div>

          {/* Contact Form */}
          <div className="col-lg-8">
            <div className="lms-card">
              <h5 style={{ fontFamily: 'Sora, sans-serif', marginBottom: '1.5rem' }}>Send a Message</h5>
              {sent && (
                <div style={{ background: '#d1fae5', color: '#065f46', padding: '12px 16px', borderRadius: '8px', marginBottom: '1.25rem', fontSize: '0.87rem', fontWeight: 600 }}>
                  ✅ Your message has been sent! We'll get back to you within 24 hours.
                </div>
              )}
              <form onSubmit={handleSubmit}>
                <div className="row g-3">
                  <div className="col-md-6">
                    <label className="lms-label">Full Name</label>
                    <input className="lms-form-control" type="text" placeholder="Ayush Sharma"
                      value={form.name} onChange={e => setForm({ ...form, name: e.target.value })} required />
                  </div>
                  <div className="col-md-6">
                    <label className="lms-label">Email Address</label>
                    <input className="lms-form-control" type="email" placeholder="you@example.com"
                      value={form.email} onChange={e => setForm({ ...form, email: e.target.value })} required />
                  </div>
                  <div className="col-12">
                    <label className="lms-label">Subject</label>
                    <input className="lms-form-control" type="text" placeholder="How can we help?"
                      value={form.subject} onChange={e => setForm({ ...form, subject: e.target.value })} required />
                  </div>
                  <div className="col-12">
                    <label className="lms-label">Message</label>
                    <textarea className="lms-form-control" rows={5} placeholder="Write your message here..."
                      value={form.message} onChange={e => setForm({ ...form, message: e.target.value })}
                      style={{ resize: 'vertical' }} required />
                  </div>
                  <div className="col-12">
                    <button type="submit" className="btn-primary-lms" style={{ maxWidth: '200px' }}>
                      📨 Send Message
                    </button>
                  </div>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default ContactUs
