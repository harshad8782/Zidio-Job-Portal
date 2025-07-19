package com.zidio.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zidio.jobportal.dto.StudentDTO;
import com.zidio.jobportal.entity.Student;
import com.zidio.jobportal.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private com.zidio.jobportal.repository.UserRepository userRepository;

    public StudentDTO createOrUpdateStudent(StudentDTO dto, String email) {
        Student student = new Student();
        // Set fields from DTO to entity
        student.setCollegeName(dto.collegeName);
        student.setDegree(dto.degree);
        student.setBranch(dto.branch);
        student.setGraduationYear(dto.graduationYear);
        student.setCgpa(dto.cgpa);
        student.setSkills(dto.skills);
        student.setBio(dto.bio);
        student.setResumeUrl(dto.resumeURL);
        student.setProfilePicture(dto.profilePicture);
        // Set user relationship from authenticated email
        com.zidio.jobportal.entity.User user = userRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found for email: " + email));
        student.setUser(user);
        Student saved = studentRepository.save(student);
        return mapToDTO(saved);
    }


    public StudentDTO getStudentById(Long id) {
        Student student = studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
        return mapToDTO(student);
    }

    private StudentDTO mapToDTO(Student student) {
        StudentDTO dto = new StudentDTO();
        dto.id = student.getStudentId();
        dto.collegeName = student.getCollegeName();
        dto.degree = student.getDegree();
        dto.branch = student.getBranch();
        dto.graduationYear = student.getGraduationYear();
        dto.cgpa = student.getCgpa();
        dto.skills = student.getSkills();
        dto.bio = student.getBio();
        dto.resumeURL = student.getResumeUrl();
        dto.profilePicture = student.getProfilePicture();
        return dto;
    }
}
