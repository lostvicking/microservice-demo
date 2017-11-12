package hello;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class BookService {

    @Autowired
    private  RestTemplate restTemplate;

    // can come from a property file/database, etc
    private String SERVICE = "BOOKSTORE-SERVICE";

    @HystrixCommand(fallbackMethod = "fallback")
    public String readingList() {
        String result = "";

        URI uri = URI.create("http://"+SERVICE+"/recommended");
        result = restTemplate.getForObject(uri, String.class);

        return result;
    }

    public String fallback() {
        return "Service Temporarily Unavailable";
    }

}