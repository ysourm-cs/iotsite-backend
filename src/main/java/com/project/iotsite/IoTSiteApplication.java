package com.project.iotsite;

import com.project.iotsite.entity.*;
import com.project.iotsite.repository.DeviceRepository;
import com.project.iotsite.repository.RoleRepository;
import com.project.iotsite.repository.RoomRepository;
import com.project.iotsite.repository.TypeRepository;
import com.project.iotsite.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class IoTSiteApplication {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private RoomRepository roomRepo;

    @Autowired
    private TypeRepository deviceTypeRepo;

    @Autowired
    private DeviceRepository deviceRepo;

    public static void main(String[] args) {
        SpringApplication.run(IoTSiteApplication.class, args);
    }

//    @Bean
//    ApplicationRunner init() {
//        return args -> {
//            Role admin = new Role("ADMIN");
//            roleRepo.save(admin);
//
//            Role userRole = new Role("USER");
//            roleRepo.save(userRole);
//
//            Random random = new Random(2);
//            Stream.of("Yannis", "Dimitris", "Helen", "George").forEach(name -> {
//                        User user = new User();
//                        user.setName(name);
//                        user.setSurname("Codingschool");
//                        user.setPassword("1");
//                        user.setEmail(name + "@gmail.com");
////                        user.setRole(random.nextInt() < 2 ? admin : userRole);
//                        if (user.getName().startsWith("Y")) {
//                            user.setRole(admin);
//                        } else {
//                            user.setRole(userRole);
//                        }
//                userService.save(user);
//                    }
//            );
//
//            userService.findAll().forEach(System.out::println);
//
//
//            Room kitchen = new Room("Kitchen");
//            Room bedroom = new Room("Bedroom");
//            Room bathroom = new Room("Bathroom");
//
//
//            Type coffeeMaker = new Type();
//            coffeeMaker.setName("CoffeeMaker");
//
//            Type television = new Type("Television");
//            deviceTypeRepo.save(coffeeMaker);
//            deviceTypeRepo.save(television);
//
//            Device nespressoCoffeeMaker = new Device("Nespresso Inisia", "We like it", 0, coffeeMaker);
//            deviceRepo.save(nespressoCoffeeMaker);
//
//            kitchen.addDevice(nespressoCoffeeMaker);
//            roomRepo.save(kitchen);
//
//            roomRepo.save(bedroom);
//            roomRepo.save(bathroom);
//
//            User me = userService.findById(3L);
//            if (me != null) {
//              me.addDevice(nespressoCoffeeMaker);
//             // userService.save(me);
//            }
//
//            Device krups = new Device("Krups", "", 0, coffeeMaker);
//            krups.setRoom(bedroom);
//            deviceRepo.save(krups);
//
//
//
//        };
//    }


}
