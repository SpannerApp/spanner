package spannerapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

/**
 * Created by Siekacz on 10.03.2017.
 */
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class SpannerApp {

    public static void main(String[] args) {SpringApplication.run(SpannerApp.class, args); }

}
