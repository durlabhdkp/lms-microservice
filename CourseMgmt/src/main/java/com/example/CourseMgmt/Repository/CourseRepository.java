
package com.example.CourseMgmt.Repository;

import com.example.CourseMgmt.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
