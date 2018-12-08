package com.project.iotsite.service;

import com.project.iotsite.entity.Device;

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

    List<Device> changeRoomDevices(long room_id, long oldStatus, long newStatus);
}
