package com.salesianostriana.dam.skillhub.services;

import com.salesianostriana.dam.skillhub.models.Course;
import com.salesianostriana.dam.skillhub.models.Enrollment;
import com.salesianostriana.dam.skillhub.models.User;
import com.salesianostriana.dam.skillhub.repositories.CourseRepository;
import com.salesianostriana.dam.skillhub.repositories.EnrollmentRepository;
import com.salesianostriana.dam.skillhub.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final UserRepository userRepository;
    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    public Enrollment UserInCurso(Long userid, Long cursoId){

        User user= userRepository.findById(userid).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrdo el usaurio con id %d".formatted(userid))
        );
        Course course = courseRepository.findById(cursoId).orElseThrow(
                ()-> new EntityNotFoundException("No se ha encontrado un curso con id %d".formatted(cursoId))
        );


      return  enrollmentRepository.save(Enrollment.builder()
                        .enrolledAt(LocalDate.now())
                        .course(course)
                        .user(user)
                        .progressPercent(0)
                        .build());

    }

    public Enrollment actualizarProgreso (int progreso, Long id){

        Enrollment enrollment = enrollmentRepository.findById(id).orElseThrow(
                ()-> new EntityNotFoundException("No se he encontrado un enrollment")
        );
         enrollment.setProgressPercent(progreso);
        return enrollment;
    }
}
