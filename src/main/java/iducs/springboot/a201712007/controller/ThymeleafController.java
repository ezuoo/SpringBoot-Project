package iducs.springboot.a201712007.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ThymeleafController {

    /**
     * Mapping to index:main page
     * @return view
     */
    @GetMapping("/")
    public ModelAndView main(ModelAndView mav, HttpServletRequest request) {
        mav.addObject("member", request.getSession().getAttribute("member"));
        mav.setViewName("/main/index");
        return mav;
    }


}
