package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.lang.AvgAlias;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "USERS")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "BIRTHDATE")
    private LocalDateTime birthdate;
    @AvgAlias(mapTo = "randomNumberResult")
    @Column(name = "RANDOM_NUMBER")
    private Long randomNumber;
    @Transient
    private Double randomNumberResult;
}
