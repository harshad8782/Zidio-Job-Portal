```markdown
# 💼 ZIDIO Connect – Job & Internship Portal

A full-stack web application to manage student-internship-job interactions using Spring Boot, JWT Security, and MySQL.

---

## 🚀 Getting Started

```bash
./mvnw clean install
./mvnw spring-boot:run
```

---

## 📦 Authentication APIs
```markdown
# ZIDIO Connect - Postman Testing Flow

## 🔐 1. Register Users (Student / Recruiter)
POST http://localhost:8080/api/auth/register
Content-Type: application/json

{
  "name": "Harshad",
  "email": "harshad3@example.com",
  "password": "123456",
  "role": "STUDENT"
}

# OR

{
  "name": "HR Manager",
  "email": "recruiter@example.com",
  "password": "123456",
  "role": "RECRUITER"
}


## 🔑 2. Login to Get JWT Token
POST http://localhost:8080/api/auth/login
Content-Type: application/json

{
  "email": "harshad3@example.com",
  "password": "123456"
}

> 📥 Response:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
  "message": "Login Successful"
}


## 🧪 3. Test Hello Endpoint (Optional)
GET http://localhost:8080/hello


## 👤 4. Create or Update Student Profile
POST http://localhost:8080/api/students
Authorization: Bearer <STUDENT_TOKEN>
Content-Type: application/json

{
  "id": null,
  "name": "Harshad",
  "email": "harshad3@example.com",
  "phone": "9876543210",
  "qualification": "B.Tech",
  "resumeleURL": "https://link.to/resume"
}


## 🔍 5. Get Student by Email
GET http://localhost:8080/api/students/email/harshad3@example.com


## 🏢 6. Create or Update Recruiter Profile
POST http://localhost:8080/api/recruiters
Authorization: Bearer <RECRUITER_TOKEN>
Content-Type: application/json

{
  "id": null,
  "name": "Recruiter Name",
  "email": "recruiter@example.com",
  "companyName": "ZIDIO Tech",
  "contactNumber": "1234567890"
}


## 🎯 7. Post a Job (Recruiter)
POST http://localhost:8080/api/jobPosts
Authorization: Bearer <RECRUITER_TOKEN>
Content-Type: application/json

{
  "id": null,
  "jobTitle": "Java Developer",
  "jobDescription": "Build REST APIs",
  "jobLocation": "Mumbai",
  "jobType": "Full Time",
  "companyName": "ZIDIO Tech",
  "postedByEmail": "recruiter@example.com",
  "postedDate": "2025-07-06T00:00:00.000+05:30"
}


## 🔍 8. Search Jobs
GET http://localhost:8080/api/jobPosts/jobTitle?jobTitle=Java Developer
GET http://localhost:8080/api/jobPosts/jobType?jobType=Full Time
GET http://localhost:8080/api/jobPosts/companyName?companyName=ZIDIO Tech
GET http://localhost:8080/api/jobPosts/recruiter?email=recruiter@example.com


## ✅ 9. Apply to a Job (Student)
POST http://localhost:8080/api/jobapplications
Authorization: Bearer <STUDENT_TOKEN>
Content-Type: application/json

{
  "id": null,
  "studentId": 1,
  "jobPostId": 1,      
  "applicationDate": "2025-07-06T00:00:00.000+05:30",
  "status": "PENDING"
}



## 📄 10. View Applications by Student
GET http://localhost:8080/api/jobapplications/student?email=harshad3@example.com
Authorization: Bearer <STUDENT_TOKEN>


## 🧾 11. View Applications by Recruiter
GET http://localhost:8080/api/jobapplications/recruiter?email=recruiter@example.com
Authorization: Bearer <RECRUITER_TOKEN>

## 🧾 12. Admin block/unblock
POST http://localhost:8080/api/admin/block
Authorization: Bearer <ADMIN_TOKEN>
Content-Type: application/json

{
  "email": "harshad@example.com", #student ID
  "block": true
}

## 🧾 13. Admin view status
GET http://localhost:8080/api/admin/status
Authorization: Bearer <ADMIN_TOKEN>

## 🧾 14. Admin view users
GET http://localhost:8080/api/admin/users
Authorization: Bearer <ADMIN_TOKEN>

## 🧾 13. Admin view summary
GET http://localhost:8080/api/admin/summary
Authorization: Bearer <ADMIN_TOKEN>

```
---

## 🔐 Notes

- Use `Authorization: Bearer <JWT_TOKEN>` for all protected routes
- All job and student-related endpoints require proper authentication
- You can register/login as STUDENT or RECRUITER

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Security + JWT
- MySQL
- Postman for testing

---

## ✅ Next Module

- Implement Job Application module:
  - Apply to job (STUDENT)
  - View applicants (RECRUITER)
  - Prevent duplicate applications

## admin 
 - admin dashboard analysis
 - admin can block and unblock both student and recuiter
 - admin can view status of both student and recuiter in real time active(online/offline)
---

## Key Modules
 - Authentication Module
    - Student, Recruiter, and Admin logins
    - Registration and role-based access
 
 - Student Dashboard
    - Profile management
    - Resume upload
    - View and apply to jobs/internships
    - Application status tracking
 
 - Recruiter Dashboard
    - Post job/internship listings
    - View applications
    - Shortlist or reject candidates
 
 - Admin Panel
    - User management (approve/block)
    - Content moderation
    - System analytics and reporting
 
 - Job/Internship Management
    - Listing, searching, and filtering opportunities
    - Bookmarking options
    - Notifications and updates

## Email notifcation
  - JavaMailSender

## upload file(resume)

## admin analytics total jobpost and jobapplication

## checking