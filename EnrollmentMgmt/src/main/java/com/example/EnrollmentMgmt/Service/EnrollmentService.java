package com.example.EnrollmentMgmt.Service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.EnrollmentMgmt.Entity.Enrollment;
import com.example.EnrollmentMgmt.Exception.EnrollmentNotFoundException;
import com.example.EnrollmentMgmt.Repository.EnrollmentRepository;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public Enrollment createEnrollment(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id)
                .orElseThrow(() -> new EnrollmentNotFoundException("Enrollment with ID " + id + " not found"));
    }

    public Enrollment updateEnrollment(Long id, Enrollment enrollmentDetails) {
        Enrollment existingEnrollment = getEnrollmentById(id);
        existingEnrollment.setStatus(enrollmentDetails.getStatus());
        existingEnrollment.setProgress(enrollmentDetails.getProgress());
        return enrollmentRepository.save(existingEnrollment);
    }

    public void deleteEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
