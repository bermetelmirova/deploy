package kg.itacademy.springWebApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {
    @Column(name = "login", nullable = false)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    private Long isActive;
}
