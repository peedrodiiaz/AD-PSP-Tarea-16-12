package com.salesianostriana.dam.skillhub.Repositories;

import com.salesianostriana.dam.skillhub.models.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRespository extends JpaRepository<Lesson,Long> {
}
