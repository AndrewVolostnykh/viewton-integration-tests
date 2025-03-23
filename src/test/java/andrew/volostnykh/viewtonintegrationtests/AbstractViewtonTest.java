package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.ViewtonRepository;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Basic test class for all integration tests.
 * Uses random port when start application.
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
public abstract class AbstractViewtonTest {

    @Autowired
    protected ViewtonRepository viewtonRepository;

}
