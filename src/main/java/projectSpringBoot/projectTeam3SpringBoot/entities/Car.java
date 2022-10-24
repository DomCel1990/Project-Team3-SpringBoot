package projectSpringBoot.projectTeam3SpringBoot.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDateTime checkIn;
    private LocalDateTime checkOut;
    public Car() {}

    public Car(LocalDateTime checkIn, LocalDateTime checkOut) {
        this.setCheckIn(checkIn);
        this.setCheckOut(checkOut);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDateTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDateTime checkOut) {
        this.checkOut = checkOut;
    }
}
