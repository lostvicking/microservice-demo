package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Created by vic on 2017/11/10.
 */
@RestController
@SpringBootApplication
public class CallingService {


    @RequestMapping("/callservice")
    public void readingList() {
        for (int i=0; i<10000; i++) {
            RestTemplate restTemplate = new RestTemplate();
            URI uri = URI.create("http://localhost:8080/to-read");

            long start = System.currentTimeMillis();
            String result = restTemplate.getForObject(uri, String.class);
            long end = System.currentTimeMillis();

            System.out.println("call took " + (end - start)+" millis");
        }

    }


    public static void main(String[] args) {
            SpringApplication.run(CallingService.class, args);
        }

}
