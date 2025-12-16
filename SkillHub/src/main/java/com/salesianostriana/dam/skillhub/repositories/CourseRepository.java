package com.salesianostriana.dam.skillhub.repositories;

import com.salesianostriana.dam.skillhub.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course,Long> {
}
