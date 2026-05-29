export const courses = [
  {
    id: 1,
    title: 'React Development',
    category: 'Frontend',
    instructor: 'John Doe',
    duration: '8 Weeks',
    level: 'Intermediate',
    price: 4999,
    rating: 4.8,
    students: 1240,
    icon: '⚛️',
    color: '#61dafb',
    description: 'Master modern frontend development with React 19, hooks, state management, and real-world project building.',
    curriculum: [
      'React Basics & JSX',
      'Components, Props & State',
      'Event Handling & Forms',
      'React Router DOM',
      'Context API & Redux',
      'Custom Hooks',
      'Performance Optimization',
      'Final Project'
    ]
  },
  {
    id: 2,
    title: 'Java Full Stack',
    category: 'Backend',
    instructor: 'David Smith',
    duration: '12 Weeks',
    level: 'Advanced',
    price: 6999,
    rating: 4.7,
    students: 980,
    icon: '☕',
    color: '#f89820',
    description: 'Complete Java backend development including Spring Boot, REST APIs, Hibernate ORM, and microservices.',
    curriculum: [
      'Java Core Concepts',
      'OOP & Design Patterns',
      'Spring Framework',
      'Spring Boot REST APIs',
      'Hibernate & JPA',
      'Microservices',
      'Docker & Deployment',
      'Capstone Project'
    ]
  },
  {
  id: 3,
  title: "Python & AI",
  description:
    "This course is currently under development and will be launched soon.",
  price: "Coming Soon",
  icon: "🚧",
  color: "#64748b",
  category: "Upcoming",
  level: "Pending",
  duration: "Launching Soon",
  rating: "New",
  students: 0,
  comingSoon: true,
  },
  
]

export const students = [
  { id: 1,  name: 'Ayush ',   email: 'ayush@example.com',   course: 'React Development',   status: 'Active',    progress: 78, joined: 'Jan 2026' },
  { id: 2,  name: 'Rahul',    email: 'rahul@example.com',   course: 'Java Full Stack',      status: 'Active',    progress: 55, joined: 'Jan 2026' },
  { id: 3,  name: 'Snehil',    email: 'sneh@example.com',   course: 'Python & Data Science',status: 'Active',    progress: 90, joined: 'Feb 2026' },
  { id: 4,  name: 'Aman',    email: 'aman@example.com',   course: 'UI/UX Design',         status: 'Completed', progress: 100,joined: 'Dec 2025' },
  { id: 5,  name: 'Vikram',   email: 'vikram@example.com',  course: 'DevOps & Cloud',       status: 'Active',    progress: 33, joined: 'Mar 2026' },
  { id: 6,  name: 'Ritesh',     email: 'ritesh@example.com',  course: 'Node.js & Express',    status: 'Inactive',  progress: 20, joined: 'Feb 2026' },
  { id: 7,  name: 'Rohan',      email: 'rohan@example.com',   course: 'React Development',   status: 'Active',    progress: 65, joined: 'Mar 2026' },
  { id: 8,  name: 'Kavya',     email: 'kavya@example.com',   course: 'Python & Data Science',status: 'Active',    progress: 48, joined: 'Mar 2026' },
]

export const faculty = [
  { id: 1, name: 'John Doe',      role: 'React Trainer',     courses: ['React Development'],                    exp: '6 Years', rating: 4.8, students: 1240, avatar: 'JD', color: '#61dafb' },
  { id: 2, name: 'David Smith',   role: 'Java Trainer',      courses: ['Java Full Stack'],                      exp: '9 Years', rating: 4.7, students: 980,  avatar: 'DS', color: '#f89820' },
  { id: 3, name: 'Sarah Johnson', role: 'Data Science Lead', courses: ['Python & Data Science'],               exp: '7 Years', rating: 4.9, students: 1560, avatar: 'SJ', color: '#3776ab' },
  { id: 4, name: 'Mike Chen',     role: 'Backend Engineer',  courses: ['Node.js & Express'],                   exp: '5 Years', rating: 4.6, students: 740,  avatar: 'MC', color: '#68a063' },
  { id: 5, name: 'Priya Patel',   role: 'UX Designer',       courses: ['UI/UX Design'],                        exp: '4 Years', rating: 4.7, students: 890,  avatar: 'PP', color: '#ff6b6b' },
  { id: 6, name: 'Rahul Verma',   role: 'DevOps Architect',  courses: ['DevOps & Cloud'],                      exp: '8 Years', rating: 4.8, students: 610,  avatar: 'RV', color: '#ff9900' },
]