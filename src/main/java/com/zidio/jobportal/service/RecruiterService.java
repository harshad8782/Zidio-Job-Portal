package com.zidio.jobportal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zidio.jobportal.dto.RecruiterDTO;
import com.zidio.jobportal.entity.Recruiter;
import com.zidio.jobportal.repository.RecruiterRepository;

@Service
public class RecruiterService {
    @Autowired
    private com.zidio.jobportal.repository.UserRepository userRepository;

    @Autowired
    private RecruiterRepository recruiterRepository;

    public RecruiterDTO createOrUpdateRecruiter(RecruiterDTO dto, String email) {
        Recruiter recruiter = new Recruiter();
        recruiter.setCompanyName(dto.companyName);
        recruiter.setCompanyDescription(dto.companyDescription);
        recruiter.setWebsite(dto.website);
        recruiter.setCompanyLogo(dto.companyLogo);
        recruiter.setDesignation(dto.designation);
        recruiter.setCompanyAddress(dto.companyAddress);
        recruiter.setIsVerified(dto.isVerified);
        // Set user relationship from authenticated email
        com.zidio.jobportal.entity.User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
        recruiter.setUser(user);
        Recruiter saved = recruiterRepository.save(recruiter);
        return mapToDTO(saved);
    }


    public RecruiterDTO getById(Long id) {
    Recruiter recruiter = recruiterRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Recruiter not found"));
            return mapToDTO(recruiter); // ensure this method exists
    }


    private RecruiterDTO mapToDTO(Recruiter recruiter) {
        RecruiterDTO dto = new RecruiterDTO();
        dto.id = recruiter.getRecruiterId();
        dto.companyName = recruiter.getCompanyName();
        dto.companyDescription = recruiter.getCompanyDescription();
        dto.website = recruiter.getWebsite();
        dto.companyLogo = recruiter.getCompanyLogo();
        dto.designation = recruiter.getDesignation();
        dto.companyAddress = recruiter.getCompanyAddress();
        dto.isVerified = recruiter.getIsVerified();
        return dto;
    }
}