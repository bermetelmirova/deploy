package kg.itacademy.springWebApp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole extends BaseEntity{
    @Column(name = "role_name")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
