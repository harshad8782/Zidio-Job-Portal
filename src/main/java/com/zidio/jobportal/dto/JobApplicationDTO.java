package com.zidio.jobportal.dto;

import java.util.Date;

public class JobApplicationDTO {

    public Long id;
    public String resumeLink;
    public Date applicationDate;
    public Long studentId;
    public Long jobPostId;

    public JobApplicationDTO() {}

    public JobApplicationDTO(Long id, String resumeLink, Date applicationDate, Long studentId, Long jobPostId) {
        this.id = id;
        this.resumeLink = resumeLink;
        this.applicationDate = applicationDate;
        this.studentId = studentId;
        this.jobPostId = jobPostId;
    }
}
