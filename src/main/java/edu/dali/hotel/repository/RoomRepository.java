package edu.dali.hotel.repository;

import edu.dali.hotel.model.RoomEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    RoomEntity findById(Integer id);
    List<RoomEntity> findAll(Specification<RoomEntity> roomEntitySpecification);
}
