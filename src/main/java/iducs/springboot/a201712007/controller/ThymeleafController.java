package iducs.springboot.a201712007.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ThymeleafController {

    @GetMapping("/th-text")
    public String thText() {
        return "th-text";
    }

    @GetMapping("/index")
    public String main() {

        return "main/index";
    }

    @GetMapping("login")
    public String login(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("login", "flwngh");
        return "main/index";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest req) {
        HttpSession session= req.getSession();
        session.setAttribute("login", null);
        return "main/index";
    }
}
