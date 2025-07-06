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

### ✅ Register (Student / Recruiter)
```http
POST /api/auth/register
Content-Type: application/json
```
```json
{
  "name": "John",
  "email": "john@example.com",
  "password": "123456",
  "role": "STUDENT" // or "RECRUITER"
}
```

---

### ✅ Login
```http
POST /api/auth/login
Content-Type: application/json
```
```json
{
  "email": "john@example.com",
  "password": "123456"
}
```

✅ Copy the `token` from the response and use in Authorization headers:
```
Authorization: Bearer <token>
```

---

## 🧑‍🎓 STUDENT FLOW

### 🔹 Create / Update Student Profile
```http
POST /api/students
Authorization: Bearer <token>
Content-Type: application/json
```
```json
{
  "id": 1,
  "name": "Student One",
  "email": "student1@example.com",
  "phone": "9876543210",
  "qualification": "BTech",
  "resumeleURL": "https://link.to/resume.pdf"
}
```

### 🔹 Get Student by Email
```http
GET /api/students/email/student1@example.com
Authorization: Bearer <token>
```

### 🔹 Get Student by ID
```http
GET /api/students/id/1
Authorization: Bearer <token>
```

---

## 🧑‍💼 RECRUITER FLOW

### 🔹 Create Recruiter Profile
```http
POST /api/recruiters
Authorization: Bearer <token>
Content-Type: application/json
```
```json
{
  "name": "Recruiter One",
  "email": "recruiter1@example.com",
  "company": "Tech Corp",
  "position": "HR Manager"
}
```

### 🔹 Post a Job
```http
POST /api/jobPosts
Authorization: Bearer <token>
Content-Type: application/json
```
```json
{
  "jobTitle": "Software Intern",
  "jobDescription": "Work on backend services",
  "jobLocation": "Remote",
  "jobType": "Internship",
  "companyName": "Tech Corp",
  "postedByEmail": "recruiter1@example.com",
  "postedDate": "2025-07-07"
}
```

### 🔹 Get Jobs Posted by Recruiter
```http
GET /api/jobPosts/recruiter?email=recruiter1@example.com
Authorization: Bearer <token>
```

### 🔹 Filter Jobs by Title / Type / Company
```http
GET /api/jobPosts/jobTitle?jobTitle=Software Intern
GET /api/jobPosts/jobType?jobType=Internship
GET /api/jobPosts/companyName?companyName=Tech Corp
Authorization: Bearer <token>
```

---

## ✅ Test Endpoint

```http
GET /hello
```

Returns: `Hello world!` (used to verify JWT authentication)

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

---


