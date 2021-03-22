package iducs.springboot.a201712007.examples.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 엔드포인트의 흐름 제어
 */
@Controller
public class SimpleController {
    @GetMapping("/")
    public String home() {
        return "index.html";
    }

    @GetMapping("/test")
    public String test() {
        return "test.html";
    }
}
