package edu.dali.hotel.service.implement;

import edu.dali.hotel.model.RoomEntity;
import edu.dali.hotel.model.TypeEntity;
import edu.dali.hotel.repository.TypeRepository;
import edu.dali.hotel.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class Type implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public List<TypeEntity> listType() {
        return typeRepository.findAll();
    }

}
