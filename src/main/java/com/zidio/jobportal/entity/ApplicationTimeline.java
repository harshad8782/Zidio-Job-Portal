package com.zidio.jobportal.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "application_timeline")
public class ApplicationTimeline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timelineId;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @Column(length = 20, nullable = false)
    private String status;

    @Column(columnDefinition = "TEXT")
    private String remarks;

    @Column(name = "created_at", updatable = false)
    private Timestamp createdAt;

    // Getters and setters
    public Long getTimelineId() { return timelineId; }
    public void setTimelineId(Long timelineId) { this.timelineId = timelineId; }
    public Application getApplication() { return application; }
    public void setApplication(Application application) { this.application = application; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}
