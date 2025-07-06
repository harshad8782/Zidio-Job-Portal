package com.zidio.jobportal.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "job_applications")
public class JobApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resumeLink;

    private Date applicationDate;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "job_post_id")
    private JobPost jobPost;

    public JobApplication() {}

    public JobApplication(String resumeLink, Date applicationDate, Student student, JobPost jobPost) {
        this.resumeLink = resumeLink;
        this.applicationDate = applicationDate;
        this.student = student;
        this.jobPost = jobPost;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public String getResumeLink() {
        return resumeLink;
    }

    public void setResumeLink(String resumeLink) {
        this.resumeLink = resumeLink;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public JobPost getJobPost() {
        return jobPost;
    }

    public void setJobPost(JobPost jobPost) {
        this.jobPost = jobPost;
    }
}
