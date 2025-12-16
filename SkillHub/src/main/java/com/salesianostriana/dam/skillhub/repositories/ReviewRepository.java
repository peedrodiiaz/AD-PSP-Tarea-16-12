package com.salesianostriana.dam.skillhub.repositories;

import com.salesianostriana.dam.skillhub.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
