package kg.itacademy.springWebApp.repository;

import kg.itacademy.springWebApp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
   List<Payment> findByCreateDateBetween(LocalDateTime createDate, LocalDateTime endTime);

}
