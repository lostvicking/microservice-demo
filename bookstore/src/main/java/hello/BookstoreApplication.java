package hello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class BookstoreApplication {

    @Value("${readingList}")
    private String readingList;

    @RequestMapping(value = "/recommended", method = RequestMethod.GET)
    public String getReadingList(){
        return readingList;
    }

    // java -jar target/bookstore-1.0-SNAPSHOT.jar --readingList="Wut" --server.port=8091

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }
}