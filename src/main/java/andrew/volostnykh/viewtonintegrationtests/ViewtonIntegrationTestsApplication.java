package andrew.volostnykh.viewtonintegrationtests;

import com.viewton.config.EnableViewton;
import com.viewton.config.ViewtonConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableViewton
@SpringBootApplication
public class ViewtonIntegrationTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ViewtonIntegrationTestsApplication.class, args);
    }

}
