package edu.dali.hotel.service;

import edu.dali.hotel.model.RoomEntity;

import java.util.List;

public interface RoomService {
    List<RoomEntity> listRoom();
    RoomEntity getRoomById(int id);
}
