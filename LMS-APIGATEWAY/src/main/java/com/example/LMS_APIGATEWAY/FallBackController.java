
package com.example.LMS_APIGATEWAY;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallBackController {

    @GetMapping("/user-fallback")
    public String userFallback() {
        return "User Service is down - served by API Gateway Fallback Mechanism";
    }

    @GetMapping("/course-fallback")
    public String courseFallback() {
        return "Course Service is down - served by API Gateway Fallback Mechanism";
    }

    @GetMapping("/enrollment-fallback")
    public String enrollmentFallback() {
        return "Enrollment Service is down - served by API Gateway Fallback Mechanism";
    }
}
