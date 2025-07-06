package com.zidio.jobportal.service;

import com.zidio.jobportal.dto.JobApplicationDTO;
import com.zidio.jobportal.entity.JobApplication;
import com.zidio.jobportal.entity.JobPost;
import com.zidio.jobportal.entity.Student;
import com.zidio.jobportal.repository.JobApplicationRepository;
import com.zidio.jobportal.repository.JobPostRepository;
import com.zidio.jobportal.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository applicationRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private JobPostRepository jobPostRepository;

    public JobApplicationDTO applyForJob(JobApplicationDTO dto) {
        Student student = studentRepository.findById(dto.studentId)
            .orElseThrow(() -> new RuntimeException("Student not found"));

        JobPost jobPost = jobPostRepository.findById(dto.jobPostId)
            .orElseThrow(() -> new RuntimeException("Job post not found"));

        JobApplication application = new JobApplication(
            dto.resumeLink,
            new Date(),
            student,
            jobPost
        );

        JobApplication saved = applicationRepository.save(application);
        return mapToDTO(saved);
    }

    public List<JobApplicationDTO> getByStudentId(Long studentId) {
        return applicationRepository.findByStudentId(studentId)
            .stream().map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    public List<JobApplicationDTO> getByJobPostId(Long jobPostId) {
        return applicationRepository.findByJobPostId(jobPostId)
            .stream().map(this::mapToDTO)
            .collect(Collectors.toList());
    }

    private JobApplicationDTO mapToDTO(JobApplication application) {
        return new JobApplicationDTO(
            application.getId(),
            application.getResumeLink(),
            application.getApplicationDate(),
            application.getStudent().getId(),
            application.getJobPost().getId()
        );
    }
}
