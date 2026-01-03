
package com.example.EnrollmentMgmt.Feign;

import com.example.EnrollmentMgmt.DTO.CourseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "course-ms", url = "http://localhost:8082")
public interface CourseClient {
    @GetMapping("/courses/{id}")
    CourseDTO getCourseById(@PathVariable("id") Long id);
}
