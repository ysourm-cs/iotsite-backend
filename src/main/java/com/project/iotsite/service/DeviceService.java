package com.project.iotsite.service;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.User;

import java.util.List;

public interface DeviceService {

    List<Device> findByname(String name);


    List<Device> findAll();

    Device save(Device d);

    void delete(Long id);

    void delete(Device p);

    Device findById(long id);

    List<Device> findAllByRoomId(long id);

    Device openDevice(long id);

    Device closeDevice(long id);

    List<Device> changeRoomDevices(long userId, long room_id, long oldStatus, long newStatus);


    List<Device> findAllByUsersAndRoomId(User user, long roomId);
    List<Device> findAllByUsersIdAndRoomId(long userId, long roomId);
}
