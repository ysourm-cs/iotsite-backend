package com.project.iotsite.service;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.User;
import com.project.iotsite.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeviceServiceImp implements DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> findByname(String name) {
        return deviceRepository.findByName(name);
    }

    @Override
    public List<Device> findAll() {
        return deviceRepository.findAll();
    }

    @Override
    public Device save(Device d) {
        return deviceRepository.save(d);
    }

    @Override
    public void delete(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public void delete(Device d) {
        deviceRepository.delete(d);
    }

    @Override
    public Device findById(long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public List<Device> findAllByRoomId(long id) { return deviceRepository.findAllByRoomId(id); }

    @Override
    public Device closeDevice(long id) {
        Device d = deviceRepository.findById(id);
        d.setStatus(0);
        deviceRepository.save(d);
        return d;
    }


    //        probably doesn't work
    @Override
    public List<Device> changeRoomDevices(long userId, long room_id, long oldStatus, long newStatus) {
        List<Device> deviceList = deviceRepository.findAllByUsersIdAndRoomId(userId, room_id);

        Device d;
        for (int i=0; i< deviceList.toArray().length; i++){
            d = deviceList.get(i);
            deviceList.get(i).setStatus(newStatus);
            deviceRepository.save(d);
        }
        return deviceList;
    }

    @Override
    public Device openDevice(long id ) {
        Device d = deviceRepository.findById(id);
        d.setStatus( 1);
        deviceRepository.save(d);
        return d;
    }


    @Override
    public List<Device> findAllByUsersAndRoomId(User user, long roomId) {
        return deviceRepository.findAllByUsersAndRoomId(user, roomId);
    }

    @Override
    public List<Device> findAllByUsersIdAndRoomId(long userId, long roomId) {
        return deviceRepository.findAllByUsersIdAndRoomId(userId, roomId);
    }
}