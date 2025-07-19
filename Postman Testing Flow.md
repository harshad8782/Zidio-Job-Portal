# Job Portal API - Postman Testing Guide

This document provides a complete, step-by-step Postman flow for testing the Job Portal API, including the correct Bearer token to use and sample JSON bodies for each request.

## Base URL
```
http://localhost:8080
```

## Authentication Flow

The API uses Bearer token authentication. You'll need to:
1. Register users (no token required)
2. Login to get JWT tokens
3. Use tokens in subsequent requests via `Authorization: Bearer <token>`

---

## Complete Testing Flow

### 1. Register Recruiter
**No token needed**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/auth/register`

**Request Body:**
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

---

### 2. Login Recruiter
**No token needed**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/auth/login`

**Request Body:**
```json
{
  "email": "alice@company.com",
  "password": "password123"
}
```

**⚠️ Important:** **Save the returned token as "Recruiter Token"**

---

### 3. Create Recruiter Profile
**Use Recruiter Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/recruiters`

**Header:** `Authorization: Bearer <Recruiter Token>`

**Request Body:**
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

---

### 4. Get Recruiter by ID
**Use Recruiter Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/recruiters/id/{id}`

**Header:** `Authorization: Bearer <Recruiter Token>`

---

### 5. Create Job Post
**Use Recruiter Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/jobPosts`

**Header:** `Authorization: Bearer <Recruiter Token>`

**Request Body:**
```json
{
  "jobTitle": "Software Engineer",
  "jobDescription": "Develop and maintain software.",
  "jobLocation": "Remote",
  "jobType": "Full-time",
  "companyName": "Tech Corp",
  "postedByEmail": "alice@company.com",
  "postedDate": "2025-07-19T10:00:00Z"
}
```

---

### 6. Get Job Posts by Recruiter Email
**Use Recruiter Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/jobPosts/recruiter?email=alice@company.com`

**Header:** `Authorization: Bearer <Recruiter Token>`

---

### 7. Register Student
**No token needed**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/auth/register`

**Request Body:**
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

---

### 8. Login Student
**No token needed**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/auth/login`

**Request Body:**
```json
{
  "email": "john@example.com",
  "password": "password123"
}
```

**⚠️ Important:** **Save the returned token as "Student Token"**

---

### 9. Create/Update Student Profile
**Use Student Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/students`

**Header:** `Authorization: Bearer <Student Token>`

**Request Body:**
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

### 10. Get Student by ID
**Use Student Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/students/id/{id}`

**Header:** `Authorization: Bearer <Student Token>`

---

## Summary

* Use the **Recruiter's token** for recruiter and job post endpoints.
* Use the **Student's token** for student endpoints.
* **Registration and login do not require a token.**

## Token Management

| Endpoint Type | Required Token |
|---------------|----------------|
| Registration (`/api/auth/register`) | None |
| Login (`/api/auth/login`) | None |
| Recruiter endpoints (`/api/recruiters/*`) | Recruiter Token |
| Job Posts endpoints (`/api/jobPosts/*`) | Recruiter Token |
| Student endpoints (`/api/students/*`) | Student Token |

## Quick Setup Checklist

1. ✅ Start your Job Portal API server on `localhost:8080`
2. ✅ Register a recruiter (Step 1)
3. ✅ Login recruiter and save token (Step 2)
4. ✅ Register a student (Step 7)
5. ✅ Login student and save token (Step 8)
6. ✅ Use appropriate tokens for protected endpoints

## Common Headers

For all authenticated requests, include:
```
Authorization: Bearer <your-jwt-token>
Content-Type: application/json
```

## Notes

- All timestamps should be in ISO 8601 format (e.g., `2025-07-19T10:00:00Z`)
- Replace placeholder values like `{id}` with actual IDs from previous responses
- Tokens expire based on your JWT configuration - re-login if you get 401 errors
- Make sure your API server is running before testing

---

## Job Application Testing Flow

For testing "apply for job" and related features in Postman, follow this flow:

### Prerequisites
* Register and login as a student to get a Bearer token.
* Create a student profile (already fixed to associate with authenticated user).
* Create a job post (as recruiter/admin).

---

### 11. Apply for Job
**Use Student Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/jobapplications`

**Headers:**
* `Authorization: Bearer <student_token>`
* `Content-Type: application/json`

**Request Body:**
```json
{
  "resumeLink": "https://example.com/resume.pdf",
  "studentId": 1,
  "jobPostId": 2
}
```

*Note: Use the actual studentId and jobPostId from your database*

---

### 12. Get Applications by Student
**Use Student Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/jobapplications/student/{studentId}`

**Headers:**
* `Authorization: Bearer <student_token>`

*Replace `{studentId}` with the actual student ID*

---

### 13. Get Applications by Job
**Use Recruiter Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/jobapplications/job/{jobPostId}`

**Headers:**
* `Authorization: Bearer <recruiter_token>` (or admin token)

*Replace `{jobPostId}` with the actual job post ID*

---

---

## Complete API Endpoints Reference

### 1. Admin Features (`/api/admin`)

#### Block/Unblock User
**Use Admin Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/admin/block`

**Headers:**
* `Authorization: Bearer <admin_token>`
* `Content-Type: application/json`

**Request Body:**
```json
{
  "userId": 1,
  "block": true
}
```

#### Get All User Statuses
**Use Admin Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/admin/status`

**Headers:**
* `Authorization: Bearer <admin_token>`

#### Dashboard Summary
**Use Admin Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/admin/summary`

**Headers:**
* `Authorization: Bearer <admin_token>`

---

### 2. Auth Features (`/api/auth`)

#### Register
**No Token Required**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/auth/register`

**Request Body:**
```json
{
  "name": "John",
  "email": "john@example.com",
  "password": "pass",
  "role": "STUDENT"
}
```

#### Login
**No Token Required**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/auth/login`

**Request Body:**
```json
{
  "email": "john@example.com",
  "password": "pass"
}
```

---

### 3. Job Post Features (`/api/jobPosts`)

#### Create Job Post
**Use Recruiter Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/jobPosts`

**Headers:**
* `Authorization: Bearer <recruiter_token>`
* `Content-Type: application/json`

**Request Body:**
```json
{
  "title": "Java Dev",
  "companyName": "ABC",
  "jobType": "Full-Time"
}
```

#### Get by Recruiter
**Use Recruiter Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/jobPosts/recruiter?email=...`

**Headers:**
* `Authorization: Bearer <recruiter_token>`

---

### 4. Job Application Features (`/api/jobapplications`)

#### Apply for Job
**Use Student Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/jobapplications`

**Headers:**
* `Authorization: Bearer <student_token>`
* `Content-Type: application/json`

**Request Body:**
```json
{
  "resumeLink": "...",
  "studentId": 1,
  "jobPostId": 2
}
```

#### Get Applications by Student
**Use Student Token**

**Method:** `GET`  
**URL:** `http://localhost:8080/api/jobapplications/student/{studentId}`

**Headers:**
* `Authorization: Bearer <student_token>`

---

### 5. Recruiter Features (`/api/recruiters`)

#### Create/Update Recruiter
**Use Recruiter Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/recruiters`

**Headers:**
* `Authorization: Bearer <recruiter_token>`
* `Content-Type: application/json`

**Request Body:**
```json
{
  "companyName": "ABC"
}
```

---

### 6. Student Features (`/api/students`)

#### Create/Update Student
**Use Student Token**

**Method:** `POST`  
**URL:** `http://localhost:8080/api/students`

**Headers:**
* `Authorization: Bearer <student_token>`
* `Content-Type: application/json`

**Request Body:**
```json
{
  "collegeName": "XYZ"
}
```

---

## Important Notes

**Security:**
* The studentId must match the authenticated user. For best security, you should fetch the student entity by the authenticated user's email in the service, not from the request body.

**Troubleshooting:**
* If you get a foreign key error, ensure both `studentId` and `jobPostId` exist in your database.
* Make sure to use the correct tokens for each endpoint type.

---

Let me know if you need help with any specific request or response!

*Happy testing! 🚀*