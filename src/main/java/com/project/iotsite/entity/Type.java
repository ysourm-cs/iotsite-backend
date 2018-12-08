package com.project.iotsite.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "type")
    private List<Device> devices;

    public Type() {
    }

    public Type(String name) {
        this.name = name;
    }

    public Type(String name, List<Device> devices) {
        this.name = name;
        this.devices = devices;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
