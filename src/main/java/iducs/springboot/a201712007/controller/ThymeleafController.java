package iducs.springboot.a201712007.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ThymeleafController {

/************************** TEST CODE ****************************/

    @GetMapping("/th-text")
    public String thText() {
        return "th-text";
    }

    @GetMapping("login")
    public String login(HttpServletRequest req) {
        HttpSession session = req.getSession();
        session.setAttribute("login", "이주호");
        return "main/index";
    }

/*****************************************************************/

    /**
     * Mapping to index:main page
     * @return view
     */
    @GetMapping("/")
    public String main() { return "main/index"; }

    /**
     * Mapping to Sign Up page
     * @return view
     */
    @GetMapping("sign-up")
    public String signUp() {
        return "member/signup-form";
    }

    /**
     * Mapping to Sign In page
     * @return view
     */
    @GetMapping("sign-in")
    public String signIn() {
        return "member/signin-form";
    }

    /**
     * Set session and mapping to index:main page
     * @param req
     * @return view
     */
    @PostMapping("sign-in")
    public String signIn(HttpServletRequest req) {
        HttpSession session= req.getSession();

        String email = req.getParameter("email");

        session.setAttribute("email", email);

        return "main/index";
    }

    /**
     * Reset session data and mapping to index:main page
     * @param req
     * @return view
     */
    @GetMapping("logout")
    public String logout(HttpServletRequest req) {
        HttpSession session= req.getSession();
        session.invalidate();
//        session.setAttribute("email", null);
        return "main/index";
    }
}
