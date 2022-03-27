package com.example.case_study.repository;

import com.example.case_study.model.StandRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IStandRoomRepository extends JpaRepository<StandRoom,Long> {
}
