package edu.dali.hotel.service.implement;

import edu.dali.hotel.model.RoomEntity;
import edu.dali.hotel.repository.RoomRepository;
import edu.dali.hotel.service.RoomService;
import edu.dali.hotel.service.vo.RoomQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.*;

@Service
public class Room implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<RoomEntity> listRoom() {
        return roomRepository.findAll();
    }

    @Override
    public RoomEntity getRoomById(int id) {
        return roomRepository.findById(id);
    }


    @Override
    public List<RoomEntity> listRoom(RoomQuery room) {
        return roomRepository.findAll(new Specification<RoomEntity>() {
            @Override
            public Predicate toPredicate(Root<RoomEntity> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                if (!"".equals(room.getName()) && room.getName() != null) {
                    predicates.add(cb.like(root.<String>get("name"), "%" + room.getName() + "%"));
                }
                if (room.getTypeId() != null) {
                    predicates.add(cb.equal(root.<Type>get("type").get("id"), room.getTypeId()));
                }
                if (room.isBreakfast()) {
                    predicates.add(cb.equal(root.<Boolean>get("breakfast"), room.isBreakfast()));
                }
                cq.where(predicates.toArray(new Predicate[predicates.size()]));
                return null;
            }
        });
    }

}
