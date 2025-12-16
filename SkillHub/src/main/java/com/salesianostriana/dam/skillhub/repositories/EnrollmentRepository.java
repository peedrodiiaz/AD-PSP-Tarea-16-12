package com.salesianostriana.dam.skillhub.repositories;

import com.salesianostriana.dam.skillhub.models.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
}
