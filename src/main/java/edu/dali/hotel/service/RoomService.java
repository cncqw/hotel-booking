package edu.dali.hotel.service;

import edu.dali.hotel.model.RoomEntity;
import edu.dali.hotel.service.vo.RoomQuery;

import java.util.List;

public interface RoomService {
    List<RoomEntity> listRoom();
    RoomEntity getRoomById(int id);
    List<RoomEntity> listRoom(RoomQuery blog);
}
