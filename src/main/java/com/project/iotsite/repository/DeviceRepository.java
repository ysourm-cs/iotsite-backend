package com.project.iotsite.repository;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("deviseRepository")
public interface DeviceRepository extends JpaRepository<Device, Long> {

    List<Device> findAll();
    List<Device> findByname(String name);
    Device findById(long id);

    List<Device> findAllByRoomId(long id);
    List<Device> findAllByRoomIdAndStatus(long room_id, long status);


}