# Job & Internship Portal Data Model (Left-to-Right Flow)

```mermaid
%%{init: {"theme": "dark", "flowchart": {"curve": "basis", "rankdir": "LR"}}}%%
flowchart LR
    %% USERS TABLE
    users[["🧑 USERS<br/>user_id (PK)<br/>username<br/>email<br/>password_hash<br/>first_name<br/>last_name<br/>phone<br/>user_type (enum)<br/>is_active<br/>created_at<br/>updated_at<br/>last_login"]]
    style users fill:#FFD700,stroke:#333,stroke-width:1px

    %% STUDENTS TABLE
    students[["🎓 STUDENTS<br/>student_id (PK)<br/>user_id (FK)<br/>college_name<br/>degree<br/>branch<br/>graduation_year<br/>cgpa<br/>skills<br/>bio<br/>resume_url<br/>profile_picture<br/>created_at<br/>updated_at"]]
    style students fill:#1E90FF,stroke:#333,stroke-width:1px

    %% RECRUITERS TABLE
    recruiters[["💼 RECRUITERS<br/>recruiter_id (PK)<br/>user_id (FK)<br/>company_name<br/>company_description<br/>website<br/>company_logo<br/>designation<br/>company_address<br/>is_verified<br/>created_at<br/>updated_at"]]
    style recruiters fill:#FF8C00,stroke:#333,stroke-width:1px

    %% ADMINS TABLE
    admins[["🛡️ ADMINS<br/>admin_id (PK)<br/>user_id (FK)<br/>role<br/>permissions<br/>created_at"]]
    style admins fill:#FF6347,stroke:#333,stroke-width:1px

    %% JOBS TABLE
    jobs[["📄 JOBS<br/>job_id (PK)<br/>recruiter_id (FK)<br/>title<br/>description<br/>company_name<br/>location<br/>employment_type (enum)<br/>salary_min<br/>salary_max<br/>currency<br/>required_skills<br/>qualifications<br/>experience_required<br/>status (enum)<br/>application_deadline<br/>created_at<br/>updated_at"]]
    style jobs fill:#32CD32,stroke:#333,stroke-width:1px

    %% INTERNSHIPS TABLE
    internships[["📄 INTERNSHIPS<br/>internship_id (PK)<br/>recruiter_id (FK)<br/>title<br/>description<br/>company_name<br/>location<br/>duration_months<br/>stipend<br/>currency<br/>required_skills<br/>qualifications<br/>status (enum)<br/>application_deadline<br/>created_at<br/>updated_at"]]
    style internships fill:#87CEEB,stroke:#333,stroke-width:1px

    %% APPLICATIONS TABLE
    applications[["📤 APPLICATIONS<br/>application_id (PK)<br/>student_id (FK)<br/>job_id (FK)<br/>internship_id (FK)<br/>application_type (enum)<br/>status (enum)<br/>cover_letter<br/>resume_url<br/>notes<br/>applied_at<br/>last_updated"]]
    style applications fill:#8A2BE2,stroke:#333,stroke-width:1px

    %% BOOKMARKS TABLE
    bookmarks[["🔖 BOOKMARKS<br/>bookmark_id (PK)<br/>student_id (FK)<br/>job_id (FK)<br/>internship_id (FK)<br/>bookmark_type (enum)<br/>created_at"]]
    style bookmarks fill:#FF69B4,stroke:#333,stroke-width:1px

    %% NOTIFICATIONS TABLE
    notifications[["🔔 NOTIFICATIONS<br/>notification_id (PK)<br/>user_id (FK)<br/>title<br/>message<br/>type (enum)<br/>is_read<br/>created_at<br/>read_at"]]
    style notifications fill:#20B2AA,stroke:#333,stroke-width:1px

    %% APPLICATION TIMELINE TABLE
    application_timeline[["⏱️ APPLICATION_TIMELINE<br/>timeline_id (PK)<br/>application_id (FK)<br/>status (enum)<br/>remarks<br/>created_at"]]
    style application_timeline fill:#A9A9A9,stroke:#333,stroke-width:1px

    %% SYSTEM LOGS TABLE
    system_logs[["📊 SYSTEM_LOGS<br/>log_id (PK)<br/>user_id (FK)<br/>action<br/>details<br/>ip_address<br/>created_at"]]
    style system_logs fill:#000000,stroke:#FFF,stroke-width:1px,color:#FFF

    %% RELATIONSHIPS
    students --> users
    recruiters --> users
    admins --> users
    notifications --> users
    system_logs --> users

    jobs --> recruiters
    internships --> recruiters

    applications --> students
    applications --> jobs
    applications --> internships

    bookmarks --> students
    bookmarks --> jobs
    bookmarks --> internships

    application_timeline --> applications
