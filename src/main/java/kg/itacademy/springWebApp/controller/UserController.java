package kg.itacademy.springWebApp.controller;

import kg.itacademy.springWebApp.entity.User;
import kg.itacademy.springWebApp.model.UserModel;
import kg.itacademy.springWebApp.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.save(user);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<String> signIn(@RequestBody UserModel userModel) {
        return ResponseEntity.ok(userService.getAutorizationToken(userModel));
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    public User deleteById(@PathVariable Long id) {
        try {
            return userService.deleteById(id);
        } catch (NullPointerException e) {
            return User.builder().login(e.getMessage()).build();
        }
    }

    @GetMapping("/get-current")
    public User getCurrentUser() {
        return userService.getCurrentUser();
    }
}
