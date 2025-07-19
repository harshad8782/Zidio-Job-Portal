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
## 📋 Complete Testing Flow

### Phase 1: Authentication Setup

#### 1. Register Admin User
**Method:** `POST` | **Endpoint:** `/api/auth/register` | **Token:** None

```json
{
  "username": "admin1",
  "firstName": "Admin",
  "lastName": "User",
  "phone": "0000000000",
  "email": "admin@company.com",
  "password": "admin123",
  "role": "ADMIN"
}
```

#### 2. Login Admin
**Method:** `POST` | **Endpoint:** `/api/auth/login` | **Token:** None

```json
{
  "email": "admin@company.com",
  "password": "admin123"
}
```
💾 **Save response token as "Admin Token"**

#### 3. Register Recruiter
**Method:** `POST` | **Endpoint:** `/api/auth/register` | **Token:** None

```json
{
  "username": "recruiter1",
  "firstName": "Alice",
  "lastName": "Smith",
  "phone": "9876543210",
  "email": "alice@company.com",
  "password": "password123",
  "role": "RECRUITER"
}
```

#### 4. Login Recruiter
**Method:** `POST` | **Endpoint:** `/api/auth/login` | **Token:** None

```json
{
  "email": "alice@company.com",
  "password": "password123"
}
```
💾 **Save response token as "Recruiter Token"**

#### 5. Register Student
**Method:** `POST` | **Endpoint:** `/api/auth/register` | **Token:** None

```json
{
  "username": "student1",
  "firstName": "John",
  "lastName": "Doe",
  "phone": "1234567890",
  "email": "john@example.com",
  "password": "password123",
  "role": "STUDENT"
}
```

#### 6. Login Student
**Method:** `POST` | **Endpoint:** `/api/auth/login` | **Token:** None

```json
{
  "email": "john@example.com",
  "password": "password123"
}
```
💾 **Save response token as "Student Token"**

---

### Phase 2: Profile Creation

#### 7. Create Recruiter Profile
**Method:** `POST` | **Endpoint:** `/api/recruiters` | **Token:** Recruiter

```json
{
  "companyName": "Tech Corp",
  "companyDescription": "Leading tech company",
  "website": "http://techcorp.com",
  "companyLogo": "http://techcorp.com/logo.png",
  "designation": "HR Manager",
  "companyAddress": "123 Tech Street",
  "isVerified": true
}
```

#### 8. Create Student Profile
**Method:** `POST` | **Endpoint:** `/api/students` | **Token:** Student

```json
{
  "collegeName": "ABC College",
  "degree": "B.Tech",
  "branch": "CSE",
  "graduationYear": 2025,
  "cgpa": 8.5,
  "skills": "Java, Spring Boot",
  "bio": "Enthusiastic learner",
  "resumeURL": "http://example.com/resume.pdf",
  "profilePicture": "http://example.com/pic.jpg"
}
```

---

### Phase 3: Job Management

#### 9. Create Job Post
**Method:** `POST` | **Endpoint:** `/api/jobPosts` | **Token:** Recruiter

```json
{
  "jobTitle": "Software Engineer",
  "jobDescription": "Develop and maintain software applications",
  "jobLocation": "Remote",
  "jobType": "Full-time",
  "companyName": "Tech Corp",
  "postedByEmail": "alice@company.com",
  "postedDate": "2025-07-19T10:00:00Z"
}
```

#### 10. Get Job Posts by Recruiter
**Method:** `GET` | **Endpoint:** `/api/jobPosts/recruiter?email=alice@company.com` | **Token:** Recruiter

#### 11. Get All Job Posts
**Method:** `GET` | **Endpoint:** `/api/jobPosts` | **Token:** Any

---

### Phase 4: Job Applications

#### 12. Apply for Job
**Method:** `POST` | **Endpoint:** `/api/jobapplications` | **Token:** Student

```json
{
  "resumeLink": "https://example.com/resume.pdf",
  "studentId": 1,
  "jobPostId": 2
}
```
*Note: Use actual IDs from your database*

#### 13. Get Applications by Student
**Method:** `GET` | **Endpoint:** `/api/jobapplications/student/{studentId}` | **Token:** Student

#### 14. Get Applications by Job Post
**Method:** `GET` | **Endpoint:** `/api/jobapplications/job/{jobPostId}` | **Token:** Recruiter

---

### Phase 5: Profile Management

#### 15. Get Recruiter by ID
**Method:** `GET` | **Endpoint:** `/api/recruiters/id/{id}` | **Token:** Recruiter

#### 16. Get Student by ID
**Method:** `GET` | **Endpoint:** `/api/students/id/{id}` | **Token:** Student

---

### Phase 6: Admin Operations

#### 17. Block/Unblock User
**Method:** `POST` | **Endpoint:** `/api/admin/block` | **Token:** Admin

```json
{
  "userId": 1,
  "block": true
}
```

#### 18. Get All User Statuses
**Method:** `GET` | **Endpoint:** `/api/admin/status` | **Token:** Admin

#### 19. Get Dashboard Summary
**Method:** `GET` | **Endpoint:** `/api/admin/summary` | **Token:** Admin

---

## 🔐 Authentication Headers

For all protected endpoints, include:
```
Authorization: Bearer <your-jwt-token>
Content-Type: application/json
```

## 📊 Token Usage Matrix

| Endpoint Category | Required Token |
|-------------------|----------------|
| `/api/auth/*` | None |
| `/api/admin/*` | Admin Token |
| `/api/recruiters/*` | Recruiter Token |
| `/api/jobPosts/*` | Recruiter Token (POST), Any Token (GET) |
| `/api/students/*` | Student Token |
| `/api/jobapplications/*` | Student Token (Apply), Student/Recruiter Token (View) |

## ⚡ Quick Start Checklist

- [ ] Start API server on `localhost:8080`
- [ ] Register Admin, Recruiter, and Student users
- [ ] Login each user type and save tokens
- [ ] Create profiles for Recruiter and Student
- [ ] Create job posts as Recruiter
- [ ] Apply for jobs as Student
- [ ] Test admin operations

## 🔍 Testing Tips

**Database IDs:** Always use actual IDs from your database responses, not the example values.

**Token Expiry:** If you get 401 errors, re-login to get fresh tokens.

**Timestamps:** Use ISO 8601 format: `2025-07-19T10:00:00Z`

**Security:** Student operations are restricted to the authenticated user's own data.

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

## Folder Sturcutre
---
```
JOBPORTAL/
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── zidio/
│                   └── jobportal/
│                       ├── controller/
│                       ├── dto/
│                       ├── entity/
│                       ├── enums/
│                       ├── repository/
│                       ├── security/
│                       ├── service/
│                       └── JobportalApplication.java
├── src/main/resources/
│   └── application.properties
```
---

