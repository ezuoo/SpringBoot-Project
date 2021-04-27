package iducs.springboot.a201712007.controller;

import iducs.springboot.a201712007.domain.Member;
import iducs.springboot.a201712007.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/members")
public class MembersController {


    private MemberService memberService;

    @Autowired // Spring Framework 가 주입함.
    public void MemberController(MemberService memberService) {
        this.memberService = memberService; // 오른쪽 memberService 객체는 등록된 객체를 주입
    }
    /**
     * Get Members
     * @return view
     */
    @GetMapping("")
    public ModelAndView getMembers(ModelAndView mav) {
        System.err.println("Controller : Read List");
        memberService.getMembers();

        mav.setViewName("main/index");
        return mav;
    }

    /**
     * Get a Member
     * @param id
     * @return view
     */
    @GetMapping("/{id}")
    public String getMember(@PathVariable String id) {

        System.out.println("Read item : " + id);

        return "main/index";
    }

    /**
     * Create Member
     * @param req
     * @return view
     */
    @PostMapping("")
    public String createMember(HttpServletRequest req, Member member) {
        System.err.println("Controller : Create");

        memberService.postMember(member);

        return "main/index";
    }

    /**
     * Update Member
     * @return
     */
    @PutMapping("/{id}")
    public String updateMember(@PathVariable String id) {
        return null;
    }

    /**
     * Delete Member
     * @return
     */
    @DeleteMapping("/{id}")
    public String deleteMember(@PathVariable String id) {
        return null;
    }

}
