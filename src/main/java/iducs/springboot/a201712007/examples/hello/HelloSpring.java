package iducs.springboot.a201712007.examples.hello;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class HelloSpring {

    @GetMapping("/hello")
    public String HelloSpring() {
        return "Hello Spring !";
    }

}
