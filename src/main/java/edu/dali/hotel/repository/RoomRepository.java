package edu.dali.hotel.repository;

import edu.dali.hotel.model.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {
    RoomEntity findById(Integer id);
}
