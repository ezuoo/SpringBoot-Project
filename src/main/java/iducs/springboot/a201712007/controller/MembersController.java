package iducs.springboot.a201712007.controller;

import iducs.springboot.a201712007.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/members")
public class MembersController {

    /**
     * Get Members
     * @return view
     */
    @GetMapping("")
    public String members() {

        System.out.println("Read List");

        return "main/index";
    }

    /**
     * Get a Member
     * @param id
     * @return view
     */
    @GetMapping("/{id}")
    public String member(@PathVariable String id) {

        System.out.println("Read item : " + id);

        return "main/index";
    }

    /**
     * Create Member
     * @param req
     * @return view
     */
    @PostMapping("")
    public String create(HttpServletRequest req, Member member) {

        System.out.println("Create");
        System.out.println(member.getName());

        return "main/index";
    }

    /**
     * Update Member
     * @return
     */
    @PutMapping("/{id}")
    public String update(@PathVariable String id) {
        return null;
    }

    /**
     * Delete Member
     * @return
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable String id) {
        return null;
    }

}
