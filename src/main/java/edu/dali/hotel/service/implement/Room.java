package edu.dali.hotel.service.implement;

import edu.dali.hotel.model.RoomEntity;
import edu.dali.hotel.repository.RoomRepository;
import edu.dali.hotel.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

}
