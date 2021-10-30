package kg.itacademy.springWebApp.service;

import kg.itacademy.springWebApp.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User getById(Long id);

    User save(User user);

    User deleteById(Long id);

    User updateUser(User user);

    User getByLogin(String login);

    User getCurrentUser();
}
