
package com.example.CourseMgmt.Service;

import com.example.CourseMgmt.Entity.Course;
import com.example.CourseMgmt.Exception.CourseNotFoundException;
import com.example.CourseMgmt.Repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }


public List<Course> getAllCourses() {
    return courseRepository.findAll();
}

public Course getCourseById(Long id) {
    return courseRepository.findById(id)
            .orElseThrow(() -> new CourseNotFoundException("Course with ID " + id + " not found"));
}


    public Course updateCourse(Long id, Course courseDetails) {
        Course existingCourse = getCourseById(id);
        existingCourse.setName(courseDetails.getName());
        existingCourse.setDescription(courseDetails.getDescription());
        existingCourse.setPrice(courseDetails.getPrice());
        existingCourse.setModules(courseDetails.getModules());
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }
}
