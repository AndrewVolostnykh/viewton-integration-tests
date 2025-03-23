package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.dto.ViewtonResponseDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class FieldFilteringTest extends AbstractViewtonTest {

    @Test
    void filterByUserName() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("firstName", "Stew"), User.class);

        assertEquals(3, response.getList().size());
        assertTrue(response.resultStream().allMatch(user -> "Stew".equals(user.getFirstName())));
    }

    @Test
    void filterByUserNameAndEmail() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("firstName", "Stew", "email", "stewdoan@gmail.com"), User.class);

        assertEquals(2, response.getList().size());
        assertTrue(response.resultStream().allMatch(user -> "Stew".equals(user.getFirstName())));
        assertTrue(response.resultStream().allMatch(user -> "stewdoan@gmail.com".equals(user.getEmail())));
    }

    @Test
    void filterEmailNot() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("email", "<>stewdoan@gmail.com"), User.class);

        assertEquals(7, response.getList().size());
        assertTrue(response.resultStream().noneMatch(user -> "stewdoan@gmail.com".equals(user.getEmail())));
    }

    @Test
    void filterEmailOr() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("email", "stewdoan@gmail.com|johnboscassi@email.com"), User.class);

        assertEquals(3, response.getList().size());
        assertEquals(2, response.resultStream().filter(user -> "stewdoan@gmail.com".equals(user.getEmail())).count());
        assertEquals(1, response.resultStream().filter(user -> "johnboscassi@email.com".equals(user.getEmail())).count());
    }

    @Test
    void filterWithIgnoreCase() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("email", "^sickSonIva@gmail.com"), User.class);

        assertEquals(1  , response.getList().size());
        assertTrue(response.resultStream().allMatch(user -> "sickSonIva@gmail.com".equals(user.getEmail())));
    }

    @Test
    void filterByLikePattern() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("email", "%@gmail.com"), User.class);

        assertEquals(5 , response.getList().size());
        assertTrue(response.resultStream().allMatch(user -> user.getEmail().contains("@gmail.com")));
    }

    @Test
    void filterGreaterThan() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("randomNumber", ">10"), User.class);

        assertEquals(7, response.getList().size());
        assertTrue(response.resultStream().noneMatch(user -> 10L == user.getRandomNumber()));
    }

    @Test
    void filterGreaterOrEquals() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("randomNumber", ">=16"), User.class);

        assertEquals(6, response.getList().size());
        assertTrue(response.resultStream().allMatch(user -> user.getRandomNumber() >= 16));
    }

    @Test
    void filterLessThan() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("randomNumber", "<16"), User.class);

        assertEquals(3, response.getList().size());
        assertTrue(response.resultStream().noneMatch(user -> 16L < user.getRandomNumber()));
    }

    @Test
    void filterLessOrEquals() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("randomNumber", "<=16"), User.class);

        assertEquals(4, response.getList().size());
        assertTrue(response.resultStream().allMatch(user -> user.getRandomNumber() <= 16));
    }

    @Test
    void filterRange() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("birthdate", "1992-01-20T20:29:20.536783..2000-01-20T20:29:20.536784"), User.class);

        assertEquals(4, response.getList().size());
        assertTrue(response.resultStream().allMatch(user ->
                user.getBirthdate().isBefore(LocalDateTime.parse("2000-01-20T20:29:20.536784")) ||
                        user.getBirthdate().isAfter(LocalDateTime.parse("1992-01-20T20:29:20.536783"))
        ));
    }
}
