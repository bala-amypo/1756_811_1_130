// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService service;

//     public AuthController(UserService service) {
//         this.service = service;
//     }

//     // REGISTER USER
//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return service.save(user);   // OUTPUT
//     }

//     // GET ALL USERS
//     @GetMapping("/users")
//     public List<User> getAllUsers() {
//         return service.getAll();     // OUTPUT
//     }

//     // GET USER BY ID
//     @GetMapping("/users/{id}")
//     public User getUserById(@PathVariable Long id) {
//         return service.getById(id);  // OUTPUT
//     }
// }
