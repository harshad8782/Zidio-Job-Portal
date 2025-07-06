package com.zidio.jobportal.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.jobportal.dto.JobPostDTO;
import com.zidio.jobportal.entity.JobPost;
import com.zidio.jobportal.repository.JobPostRepository;

@Service
public class JobPostService {

    @Autowired
    private JobPostRepository jobPostRepository;

    public JobPostDTO postJob(JobPostDTO dto) {
        JobPost job = new JobPost();
        job.setJobTitle(dto.jobTitle);
        job.setJobDescription(dto.jobDescription);
        job.setJobLocation(dto.jobLocation);
        job.setJobType(dto.jobType);
        job.setCompanyName(dto.companyName);
        job.setPostedByEmail(dto.postedByEmail);
        job.setPostedDate(dto.postedDate);

        JobPost saved = jobPostRepository.save(job);
        return mapToDTO(saved);
    }

    public List<JobPostDTO> getByPostedByEmail(String email) {
        return jobPostRepository.findByPostedByEmail(email)
            .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<JobPostDTO> getByJobTitle(String jobTitle) {
        return jobPostRepository.findByJobTitle(jobTitle)
            .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<JobPostDTO> getByJobType(String jobType) {
        return jobPostRepository.findByJobType(jobType)
            .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public List<JobPostDTO> getByCompanyName(String companyName) {
        return jobPostRepository.findByCompanyName(companyName)
            .stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    private JobPostDTO mapToDTO(JobPost job) {
        return new JobPostDTO(
            job.getId(),
            job.getJobTitle(),
            job.getJobDescription(),
            job.getJobLocation(),
            job.getJobType(),
            job.getCompanyName(),
            job.getPostedByEmail(),
            job.getPostedDate()
        );
    }
}
