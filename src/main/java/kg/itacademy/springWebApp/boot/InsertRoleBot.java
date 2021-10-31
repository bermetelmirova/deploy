package kg.itacademy.springWebApp.boot;

import kg.itacademy.springWebApp.entity.User;
import kg.itacademy.springWebApp.entity.UserRole;
import kg.itacademy.springWebApp.repository.UserRoleRepository;
import kg.itacademy.springWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InsertRoleBot implements CommandLineRunner {
    @Autowired
    private UserRoleRepository userRoleRepository;
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setLogin("admin");
        user.setPassword("admin");
        userService.save(user);
        UserRole roleAdmin = new UserRole();
        roleAdmin.setRoleName("ROLE_ADMIN");
        roleAdmin.setUser(user);
    }
}
