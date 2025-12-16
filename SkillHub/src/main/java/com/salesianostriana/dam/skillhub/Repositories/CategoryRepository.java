package com.salesianostriana.dam.skillhub.Repositories;

import com.salesianostriana.dam.skillhub.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
