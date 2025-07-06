package com.zidio.jobportal.dto;

import java.util.Date;

public class JobPostDTO {
    public Long id;
    public String jobTitle;
    public String jobDescription;
    public String jobLocation;
    public String jobType;
    public String companyName;
    public String postedByEmail;
    public Date postedDate;

    public JobPostDTO() {}

    public JobPostDTO(Long id, String jobTitle, String jobDescription,
                      String jobLocation, String jobType,
                      String companyName, String postedByEmail, Date postedDate) {
        this.id = id;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.jobType = jobType;
        this.companyName = companyName;
        this.postedByEmail = postedByEmail;
        this.postedDate = postedDate;
    }
}
