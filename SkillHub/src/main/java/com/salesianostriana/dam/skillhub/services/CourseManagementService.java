package com.salesianostriana.dam.skillhub.services;

import java.util.Set;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.skillhub.models.Course;
import com.salesianostriana.dam.skillhub.models.CursoState;
import com.salesianostriana.dam.skillhub.models.Lesson;
import com.salesianostriana.dam.skillhub.models.UserRol;
import com.salesianostriana.dam.skillhub.repositories.CourseRepository;
import com.salesianostriana.dam.skillhub.repositories.LessonRespository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CourseManagementService {

    private final CourseRepository courseRepository;
    private final LessonRespository lessonRespository;

    public Course publishCourse(Long courseId){
        Course course = courseRepository.findById(courseId).orElseThrow(
            ()-> new EntityNotFoundException(
                "No se ha encotrado un curso con id %d".formatted(courseId))
        );

        if(course.getLessons().isEmpty()){
            throw new IllegalArgumentException("El curso tiene menos de 1 lección");
        }
        // Este metodo sería conveniente tenerlo cuando se crea el curso mejor que aquí creo
        if (course.getUser().getUserRol() != UserRol.INSTRUCTOR) {
            throw new IllegalArgumentException("El usuario deber ser instructor");

        }

        course.setCursoState(CursoState.PUBLISHED);

        courseRepository.save(course);

        return course;

    
        
    }


    public void addLesson(Long courseId, Lesson lesson){
        Course course = courseRepository.findById(courseId).orElseThrow(
            ()-> new EntityNotFoundException(
                "No se ha encotrado un curso con id %d".formatted(courseId))
        );

        if (course.getCursoState()==CursoState.ARCHIVED) {
            throw new IllegalArgumentException("No se pueden aniadir lecciones a un curso archivado");        }

        Set<Lesson>lessons= course.getLessons();

        lessons.add(lesson);

        lessonRespository.save(lesson);

        

    }
}
