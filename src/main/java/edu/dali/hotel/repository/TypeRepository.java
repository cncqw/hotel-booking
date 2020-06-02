package edu.dali.hotel.repository;

import edu.dali.hotel.model.TypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<TypeEntity, Long> {
}
