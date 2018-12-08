package com.project.iotsite.controller;

import com.project.iotsite.entity.Device;
import com.project.iotsite.entity.Room;
import com.project.iotsite.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collection;

@RestController
@CrossOrigin
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping("/rooms")
    public Collection<Room> getAllRooms() {

        return roomService.findAll();
    }

    @GetMapping("/rooms/{id}")
    public Room getRoom(@PathVariable long id) {
        return roomService.findById(id);
    }

    @PutMapping("/rooms/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable long id, @RequestBody Room room) {
        Room updated = roomService.save(room);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @PostMapping("/rooms")
    public ResponseEntity<Void> addRoom(@RequestBody Room room) {

        Room saved = roomService.save(room);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(saved.getId()).toUri();
        return ResponseEntity.created(uri).build();

    }

    @DeleteMapping("/rooms/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable long id) {
        Room roomDeleted = roomService.findById(id);
        roomService.delete(id);
        //return ResponseEntity.noContent().build();
        return new ResponseEntity<>(roomDeleted, HttpStatus.OK);
    }
}