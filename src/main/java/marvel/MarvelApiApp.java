package marvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MarvelApiApp {

    @SuppressWarnings("resource")
    public static void main(String[] args) {

        SpringApplication.run(MarvelApiApp.class, args);
    }
}
