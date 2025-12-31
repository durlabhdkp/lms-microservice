
package com.example.EnrollmentMgmt.Repository;

import com.example.EnrollmentMgmt.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
