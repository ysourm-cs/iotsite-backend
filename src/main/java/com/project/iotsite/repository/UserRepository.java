package com.project.iotsite.repository;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.Room;
import com.project.iotsite.entity.Type;
import com.project.iotsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    List<User> findByname(String name);

    User findByEmail(String email);

    List<Room> findRoomsById(long userId);


}

