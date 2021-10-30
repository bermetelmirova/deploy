package kg.itacademy.springWebApp.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User user;
    private BigDecimal amount;
    private Long status;
}
