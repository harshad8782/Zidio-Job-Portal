package com.zidio.jobportal.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "bookmarks")
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookmarkId;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "internship_id")
    private Internship internship;

    @Column(name = "bookmark_type", length = 20, nullable = false)
    private String bookmarkType;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    // Getters and setters
    public Long getBookmarkId() { return bookmarkId; }
    public void setBookmarkId(Long bookmarkId) { this.bookmarkId = bookmarkId; }
    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
    public Job getJob() { return job; }
    public void setJob(Job job) { this.job = job; }
    public Internship getInternship() { return internship; }
    public void setInternship(Internship internship) { this.internship = internship; }
    public String getBookmarkType() { return bookmarkType; }
    public void setBookmarkType(String bookmarkType) { this.bookmarkType = bookmarkType; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
