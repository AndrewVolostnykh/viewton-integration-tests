package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.dto.ViewtonResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, properties = "viewton.request.default-page-size=5")
class PaginationTest extends AbstractViewtonTest {

    /**
     * sorting used to assert result data that exactly the first page queried.
     * */
    @Test
    void paginationSizeIs5WithSorting() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("page_size", "3", "page", "1", "sorting", "-firstName"), User.class);

        assertEquals(3, response.getList().size());
        assertTrue(response.resultStream().findFirst().filter(user -> user.getEmail().equals("vladathebest@email.com")).isPresent());
    }

    /**
     * sorting used to assert result data that exactly the second page queried.
     * */
    @Test
    void paginationSizeIs5GetSecondPage() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of("page_size", "3", "page", "2", "sorting", "-firstName"), User.class);

        assertTrue(response.resultStream().findFirst().filter(user -> user.getFirstName().equals("Stew")).isPresent());
    }

    @Test
    void defaultPageSize() {
        ViewtonResponseDto<User> response = viewtonRepository.list(Map.of(), User.class);
        assertEquals(5, response.getList().size());
    }
}
