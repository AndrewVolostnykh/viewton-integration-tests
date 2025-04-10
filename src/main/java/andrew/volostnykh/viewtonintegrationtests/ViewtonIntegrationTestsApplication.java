package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.config.EnableViewton;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableViewton
@SpringBootApplication
public class ViewtonIntegrationTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViewtonIntegrationTestsApplication.class, args);
    }

}
