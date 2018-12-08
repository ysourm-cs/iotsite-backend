package com.project.iotsite.service;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.User;
import com.project.iotsite.repository.DeviceRepository;
import com.project.iotsite.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserRepository usrRep;

    @Autowired
    private DeviceRepository deviceRepository;

//    @Autowired
//    private BCryptPasswordEncoder encoder;

    @Override
    public List<User> findByname(String name) {
        return usrRep.findByname(name);
    }

    @Override
    public User findByEmail(String email) {
        return usrRep.findByEmail( email);
    }

    @Override
    public User findById(Long id) {
        Optional<User> user =  usrRep.findById(id);
        return user.orElse(null);
    }

    @Override
    public List<User> findAll() {
        return usrRep.findAll();
    }

    @Override
    public User save(User d) {
        return usrRep.save(d);
    }

    @Override
    public void delete(Long id) {
        usrRep.deleteById(id);
    }

    @Override
    public void delete(User d) {
        usrRep.delete(d);
    }

    @Override
    public List<Device> findAllByUserIdAndRoomId(long id, long roomId) {
        return deviceRepository.findAllByUsersIdAndRoomId(id, roomId);
    }

    @Override
    public List<Device> findAllByUserIdAndRoomId(User user, long roomId){
        return deviceRepository.findAllByUsersAndRoomId(user, roomId);
    }

}