package com.sparta.panda.uos_manager.generalPublic.services;

import com.sparta.panda.uos_manager.common.entities.RecreationalRoomType;
import com.sparta.panda.uos_manager.common.repositories.RecreationalRoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecreationalRoomTypeService {
    private final RecreationalRoomTypeRepository recreationalRoomTypeRepository;
    @Autowired
    public RecreationalRoomTypeService(RecreationalRoomTypeRepository recreationalRoomTypeRepository) {
        this.recreationalRoomTypeRepository = recreationalRoomTypeRepository;
    }
    public List<RecreationalRoomType> getRecRoomTypes(){
        return (List<RecreationalRoomType>) recreationalRoomTypeRepository.findAll();
    }
}
