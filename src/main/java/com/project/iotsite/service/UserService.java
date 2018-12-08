package com.project.iotsite.service;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.User;

import java.util.List;

public interface UserService {


    List<User> findByname(String name);

    User findByEmail(String email);

    User findById(Long id);

    List<User> findAll();

    User save(User d);

    void delete(Long id);

    void delete(User p);

    public List<Device> findAllByUserIdAndRoomId(long id, long roomId);

    List<Device> findAllByUserIdAndRoomId(User user, long roomId);
}

