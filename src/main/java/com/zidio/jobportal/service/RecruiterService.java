package com.zidio.jobportal.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zidio.jobportal.dto.RecruiterDTO;
import com.zidio.jobportal.entity.Recruiter;
import com.zidio.jobportal.repository.RecruiterRepository;

@Service
public class RecruiterService {

    @Autowired
    private RecruiterRepository recruiterRepository;

    public RecruiterDTO createOrUpdateRecruiter(RecruiterDTO dto) {
        Recruiter recruiter = new Recruiter(
            dto.id, dto.name, dto.email, dto.phone, dto.company, dto.designation
        );
        Recruiter saved = recruiterRepository.save(recruiter);
        return mapToDTO(saved);
    }

    public RecruiterDTO getRecruiterByEmail(String email) {
        Recruiter recruiter = recruiterRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Recruiter not found"));
        return mapToDTO(recruiter);
    }

    public RecruiterDTO getById(Long id) {
    Recruiter recruiter = recruiterRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Recruiter not found"));
            return mapToDTO(recruiter); // ensure this method exists
    }


    private RecruiterDTO mapToDTO(Recruiter recruiter) {
        return new RecruiterDTO(
            recruiter.getId(),
            recruiter.getName(),
            recruiter.getEmail(),
            recruiter.getPhone(),
            recruiter.getCompany(),
            recruiter.getDesignation()
        );
    }
}