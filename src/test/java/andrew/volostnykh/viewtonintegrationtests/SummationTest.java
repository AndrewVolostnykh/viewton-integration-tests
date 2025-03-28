package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.dto.ViewtonResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SummationTest extends AbstractViewtonTest {

    @Test
    void sumOfRandomNumbers() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("sum", "randomNumber"), User.class);

        assertEquals(291, response.getSum().getRandomNumber());
    }

    @Test
    void sumOfRandomNumbersFilterByName() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("sum", "randomNumber", "firstName", "Stew"), User.class);

        assertEquals(120, response.getSum().getRandomNumber());
    }
}
