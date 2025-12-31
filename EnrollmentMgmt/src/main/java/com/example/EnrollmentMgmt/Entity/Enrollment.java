
package com.example.EnrollmentMgmt.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "enrollments")
@Getter
@Setter
public class Enrollment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Course ID cannot be null")
    private Long courseId;

    @NotBlank(message = "Status cannot be blank")
    private String status; // e.g., ACTIVE, COMPLETED

    @OneToOne(mappedBy = "enrollment", cascade = CascadeType.ALL)
    private Progress progress;
}
