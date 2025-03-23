package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.dto.ViewtonResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class FieldSelectionTest extends AbstractViewtonTest {

    @Test
    @DisplayName("Select email only")
    void selectEmailOnly() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("attributes", "email"), User.class);

        response.getList().forEach(user -> {
            assertNull(user.getId());
            assertNull(user.getFirstName());
            assertNull(user.getLastName());
            assertNull(user.getRandomNumber());
            assertNotNull(user.getEmail());
        });
    }

    @Test
    @DisplayName("Select all fields by default")
    void selectAllByDefault() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of(), User.class);

        response.getList().forEach(user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getFirstName());
            assertNotNull(user.getLastName());
            assertNotNull(user.getRandomNumber());
            assertNotNull(user.getEmail());
        });
    }

    @Test
    @DisplayName("Select all fields by attributes")
    void selectAllByAttributes() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("attributes", "id,firstName,lastName,email,birthdate,randomNumber"), User.class);

        response.getList().forEach(user -> {
            assertNotNull(user.getId());
            assertNotNull(user.getFirstName());
            assertNotNull(user.getLastName());
            assertNotNull(user.getRandomNumber());
            assertNotNull(user.getEmail());
            assertNotNull(user.getBirthdate());
        });
    }

    @Test
    @DisplayName("Select count")
    void selectCount() {
        ViewtonResponseDto<User> viewtonUsers = viewtonRepository.list(Map.of("count", "true"), User.class);
        assertEquals(9, viewtonUsers.getCount());
    }

    @Test
    @DisplayName("Select distinct")
    void selectDistinct() {
        ViewtonResponseDto<User> viewtonUsers = viewtonRepository.list(Map.of("distinct", "true", "attributes", "firstName"), User.class);
        assertEquals(7, viewtonUsers.getList().size());
    }
}
