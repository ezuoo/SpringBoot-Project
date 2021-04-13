package iducs.springboot.a201712007.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {

    /**
     * Get posts
     * @return view
     */
    @GetMapping("")
    public String posts() {

        return "blog/list-view";
    }


}
