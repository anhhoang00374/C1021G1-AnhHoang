package com.example.case_study.service.impl;

import com.example.case_study.model.StandRoom;
import com.example.case_study.repository.IStandRoomRepository;
import com.example.case_study.service.IStandRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandRoomServiceImpl implements IStandRoomService {
    @Autowired
    IStandRoomRepository standRoomRepository;
    @Override
    public List<StandRoom> findAll() {
        return standRoomRepository.findAll();
    }
}
