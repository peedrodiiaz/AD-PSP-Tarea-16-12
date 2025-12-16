package com.salesianostriana.dam.skillhub.services;

import com.salesianostriana.dam.skillhub.models.Category;
import com.salesianostriana.dam.skillhub.models.Course;
import com.salesianostriana.dam.skillhub.repositories.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Set<Course> getCoursesByCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new EntityNotFoundException("Categoría no encontrada"));

        return category.getCourses();
    }


}
