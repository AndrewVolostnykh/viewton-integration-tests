package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.dto.ViewtonResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Map;

class AvgTest extends AbstractViewtonTest {
    // {}/some-endpoint?avg=randomNumber,bla,bal[id,al,aslf]&name=Stew&email=<>jopa@email.com

    @Test
    void testAvgNoGroupBy() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("avg", "randomNumber[email]"), User.class);

        System.err.println(response);
    }
}
