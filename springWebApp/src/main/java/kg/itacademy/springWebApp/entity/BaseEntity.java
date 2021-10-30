package kg.itacademy.springWebApp.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_date")
    private LocalDateTime createDate;
    @Column(name = "update_date")
    private LocalDateTime updateDate;

    @PrePersist
    public void prePersist(){
        this.createDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate(){
        this.updateDate = LocalDateTime.now();
    }
}
