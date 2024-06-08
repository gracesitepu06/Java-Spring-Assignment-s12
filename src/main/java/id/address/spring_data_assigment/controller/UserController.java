package id.address.spring_data_assigment.controller;

import id.address.spring_data_assigment.entity.User;
import id.address.spring_data_assigment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public String addUser(@RequestBody User user) {
        User createdUser = userService.addUser(user);
        return "Berhasil menambahkan user: " + createdUser.getName();
    }

    @GetMapping
    public List<User> getAll() {
        return userService.findAll();
    }

    @GetMapping("/search")
    public List<User> findByName(@RequestParam String name) {
        return userService.findByName(name);
    }
}
