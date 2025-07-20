# 💼 ZIDIO Connect – Job & Internship Portal

A comprehensive full-stack web application for managing student-internship-job interactions built with Spring Boot, JWT Security, and MySQL.

## 📋 Table of Contents
- [Getting Started](#-getting-started)
- [Tech Stack](#️-tech-stack)
- [Project Structure](#-project-structure)
- [Key Modules](#-key-modules)
- [API Testing Guide](#-api-testing-guide)
- [Authentication & Authorization](#-authentication--authorization)
- [Features](#-features)

---

## 🚀 Getting Started

### Prerequisites
- Java 17+
- MySQL 8.0+
- Maven 3.8+

### Quick Start
```bash
# Clone the repository
git clone <repository-url>
cd zidio-connect

# Install dependencies
./mvnw clean install

# Run the application
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

---

## 🛠️ Tech Stack

| Technology | Purpose |
|------------|---------|
| **Java 17** | Backend Language |
| **Spring Boot** | Framework |
| **Spring Security** | Authentication & Authorization |
| **JWT** | Token-based Authentication |
| **MySQL** | Database |
| **JavaMailSender** | Email Notifications |
| **Maven** | Build Tool |

---

## 📁 Project Structure

```
JOBPORTAL/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── zidio/
│       │           └── jobportal/
│       │               ├── controller/          # REST Controllers
│       │               ├── dto/                 # Data Transfer Objects
│       │               ├── entity/              # JPA Entities
│       │               ├── enums/               # Enumerations
│       │               ├── repository/          # Data Access Layer
│       │               ├── security/            # Security Configuration
│       │               ├── service/             # Business Logic
│       │               └── JobportalApplication.java
│       └── resources/
│           ├── application.properties           # Configuration
│           └── static/                          # Static Resources
└── pom.xml                                      # Maven Dependencies
```

---

## 🔧 Key Modules

### 1. Authentication Module
- **Multi-role Registration**: Student, Recruiter, Admin
- **JWT-based Authentication**: Secure token system
- **Role-based Access Control**: Endpoint protection by user roles

### 2. Student Dashboard
- **Profile Management**: Complete profile creation and updates
- **Resume Upload**: File upload functionality
- **Job Applications**: View and apply to opportunities
- **Application Tracking**: Real-time status monitoring

### 3. Recruiter Dashboard
- **Job Posting**: Create and manage job/internship listings
- **Application Management**: View and process applications
- **Candidate Actions**: Shortlist or reject applicants
- **Company Profile**: Manage company information

### 4. Admin Panel
- **User Management**: Block/unblock users
- **Content Moderation**: Oversee platform content
- **Analytics Dashboard**: System metrics and reporting
- **Real-time Monitoring**: User activity tracking

### 5. Job/Internship Management
- **Advanced Search**: Filter by location, type, company
- **Bookmarking**: Save interesting opportunities
- **Notifications**: Email updates and alerts
- **Duplicate Prevention**: One application per job per student

---

## 🧪 API Testing Guide

### Phase 1: Authentication Setup

#### 1. Register Admin User
```http
POST /api/auth/register
Content-Type: application/json

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
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "admin@company.com",
  "password": "admin123"
}
```
💾 **Save response token as "Admin Token"**

#### 3. Register Recruiter
```http
POST /api/auth/register
Content-Type: application/json

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
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "alice@company.com",
  "password": "password123"
}
```
💾 **Save response token as "Recruiter Token"**

#### 5. Register Student
```http
POST /api/auth/register
Content-Type: application/json

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
```http
POST /api/auth/login
Content-Type: application/json

{
  "email": "john@example.com",
  "password": "password123"
}
```
💾 **Save response token as "Student Token"**

---

### Phase 2: Profile Creation

#### 7. Create Recruiter Profile
```http
POST /api/recruiters
Authorization: Bearer <recruiter-token>
Content-Type: application/json

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
```http
POST /api/students
Authorization: Bearer <student-token>
Content-Type: application/json

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
```http
POST /api/jobPosts
Authorization: Bearer <recruiter-token>
Content-Type: application/json

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
```http
GET /api/jobPosts/recruiter?email=alice@company.com
Authorization: Bearer <recruiter-token>
```

#### 11. Get All Job Posts
```http
GET /api/jobPosts
Authorization: Bearer <any-token>
```

---

### Phase 4: Job Applications

#### 12. Apply for Job
```http
POST /api/jobapplications
Authorization: Bearer <student-token>
Content-Type: application/json

{
  "resumeLink": "https://example.com/resume.pdf",
  "studentId": 1,
  "jobPostId": 2
}
```
*Note: Use actual IDs from your database*

#### 13. Get Applications by Student
```http
GET /api/jobapplications/student/{studentId}
Authorization: Bearer <student-token>
```

#### 14. Get Applications by Job Post
```http
GET /api/jobapplications/job/{jobPostId}
Authorization: Bearer <recruiter-token>
```

---

### Phase 5: Profile Management

#### 15. Get Recruiter by ID
```http
GET /api/recruiters/id/{id}
Authorization: Bearer <recruiter-token>
```

#### 16. Get Student by ID
```http
GET /api/students/id/{id}
Authorization: Bearer <student-token>
```

---

### Phase 6: Admin Operations

#### 17. Block/Unblock User
```http
POST /api/admin/block
Authorization: Bearer <admin-token>
Content-Type: application/json

{
  "userId": 1,
  "block": true
}
```

#### 18. Get All User Statuses
```http
GET /api/admin/status
Authorization: Bearer <admin-token>
```

#### 19. Get Dashboard Summary
```http
GET /api/admin/summary
Authorization: Bearer <admin-token>
```

#### 20. Create a Notification
```http:
POST /api/notifications

Headers:
Authorization: Bearer <user-token>
(Use the token of the user who should receive the notification.)
Body Example:
{
  "title": "Welcome to ZIDIO Connect!",
  "message": "Your account has been successfully created.",
  "type": "INFO"
}
Expected Result:

The notification is saved in the database.
An email is sent to the user's email address.
```

#### 21. Get Notifications for the Logged-in User
```http:
GET /api/notifications

Headers:

Authorization: Bearer <user-token>
(Use the token of the user whose notifications you want to fetch.)
Expected Result:

A list of notifications for the logged-in user.
```
### 22. Mark a Notification as Read
```http:
POST /api/notifications/read/{id}

Headers:

Authorization: Bearer <user-token>
(Use the token of the user who owns the notification.)
Path Parameter:

{id}: The ID of the notification to mark as read.
Expected Result:

The notification's isRead field is updated to true.
The readAt timestamp is set.
Testing Tips:
Use Postman or any API client to send requests.
Check the email inbox of the user to verify email delivery.
Use the /api/notifications GET endpoint to confirm the notification is saved.
```
---

## 🔐 Authentication & Authorization

### Token Usage Matrix

| Endpoint Category | Required Token | Description |
|-------------------|----------------|-------------|
| `/api/auth/*` | None | Public authentication endpoints |
| `/api/admin/*` | Admin Token | Administrative operations |
| `/api/recruiters/*` | Recruiter Token | Recruiter profile management |
| `/api/jobPosts/*` | Recruiter (POST), Any (GET) | Job posting and viewing |
| `/api/students/*` | Student Token | Student profile management |
| `/api/jobapplications/*` | Student/Recruiter | Application management |

### Authentication Headers
For all protected endpoints, include:
```http
Authorization: Bearer <your-jwt-token>
Content-Type: application/json
```

---

## ✨ Features

### Core Features
- **Multi-role System**: Students, Recruiters, and Admins
- **Secure Authentication**: JWT-based token system
- **File Upload**: Resume and document management
- **Email Notifications**: Automated alerts and updates
- **Real-time Analytics**: Dashboard metrics and reporting

### Student Features
- Profile management with resume upload
- Job search and filtering
- Application tracking
- Bookmark favorite opportunities
- Email notifications for updates

### Recruiter Features
- Company profile management
- Job posting and management
- Application review and processing
- Candidate shortlisting
- Analytics and reporting

### Admin Features
- User management (block/unblock)
- Platform analytics
- Content moderation
- Real-time user status monitoring
- System health dashboard

---

## 🔍 Testing Tips

### Database Management
- **Use Actual IDs**: Always use real database IDs in requests
- **Check Relationships**: Ensure foreign key constraints are met
- **Data Validation**: Verify required fields are provided

### Token Management
- **Token Expiry**: Re-login if you receive 401 errors
- **Role-based Access**: Use appropriate tokens for each endpoint
- **Security**: Never share tokens in production

### Data Formats
- **Timestamps**: Use ISO 8601 format (`2025-07-19T10:00:00Z`)
- **Email Format**: Ensure valid email addresses
- **Phone Numbers**: Use proper phone number formats

### Common Issues
- **Duplicate Applications**: System prevents multiple applications to same job
- **User Permissions**: Students can only access their own data
- **Profile Dependencies**: Create profiles before posting jobs or applying

---

## ⚡ Quick Start Checklist

- [ ] Start API server on `localhost:8080`
- [ ] Configure MySQL database connection
- [ ] Register Admin, Recruiter, and Student users
- [ ] Login each user type and save tokens
- [ ] Create profiles for Recruiter and Student
- [ ] Create job posts as Recruiter
- [ ] Apply for jobs as Student
- [ ] Test admin operations
- [ ] Verify email notifications

---
