package kg.itacademy.springWebApp.service.impl;

import kg.itacademy.springWebApp.entity.User;
import kg.itacademy.springWebApp.entity.UserRole;
import kg.itacademy.springWebApp.repository.UserRepository;
import kg.itacademy.springWebApp.repository.UserRoleRepository;
import kg.itacademy.springWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Long id) {
        return userRepository
                .findById(id)
                .orElse(null);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);

        UserRole userRole = new UserRole();
        userRole.setRoleName("ROLE_USER");
        userRole.setUser(user);
        userRoleRepository.save(userRole);

        return user;
    }


    @Override
    public User deleteById(Long id) {
        User userForDelete = getById(id);
        userRepository.delete(userForDelete);
        return userForDelete;
    }

    @Override
    public User updateUser(User user) {
        User userForUpdate = getById(user.getId());

        if (user.getCreateDate() != null) userForUpdate.setCreateDate(user.getCreateDate());
        if (user.getLogin() != null) userForUpdate.setLogin(user.getLogin());
        if (user.getPassword() != null) userForUpdate.setPassword(user.getPassword());

        return userRepository.save(userForUpdate);
    }

    @Override
    public User getByLogin(String login) {
        return userRepository.findByLogin(login).orElse(null);
    }

    @Override
    public User getCurrentUser() {
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        return getByLogin(userName);
    }
}
