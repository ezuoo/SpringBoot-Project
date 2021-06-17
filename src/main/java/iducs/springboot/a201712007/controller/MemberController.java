package iducs.springboot.a201712007.controller;

import iducs.springboot.a201712007.domain.Blog;
import iducs.springboot.a201712007.domain.Member;
import iducs.springboot.a201712007.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    /**
     * GET : request view and datas
     * @param request , mav
     * @return view
     */
    @GetMapping("")
    public ModelAndView get(HttpServletRequest request, ModelAndView mav) {

        HttpSession session = request.getSession();

        // mapping to create-view
        if(request.getParameter("a").equals("c")) mav.setViewName("/member/signup-form");

        // mapping to sign-in-view
        else if(request.getParameter("a").equals("i")) mav.setViewName("/member/signin-form");

        // mapping to index-view
        else if(request.getParameter("a").equals("o")) {
            session.setAttribute("member", null);
            mav.setViewName("/main/index");
        }

        else if(request.getParameter("a").equals("d")) {
            mav.addObject("member", session.getAttribute("member"));
            mav.setViewName("/member/delete-form");
        } else {
           System.out.println("else");
        }


        return mav;
    }

    /**
     * Get a Member
     * @param no
     * @return view
     */
    @GetMapping("/{no}")
    public ModelAndView getMember(@PathVariable int no, HttpServletRequest request, ModelAndView mav) {

        Member member = memberService.getMember(no);
        request.getSession().setAttribute("member", member);
        mav.addObject("member", member);
        mav.setViewName("/member/detail-form");

        return mav;
    }

    /**
     * POST : request to save data
     * @param member , mav
     * @return view and object
     */
    @PostMapping("")
    public ModelAndView post(Member member, ModelAndView mav, HttpServletRequest request) {

        HttpSession session = request.getSession();

        if(request.getParameter("action").equals("in")) {
            if(memberService.checkMember(member) == null) {
                mav.addObject("msg", "존재하지 않는 회원");
                mav.addObject("member", null);
                mav.setViewName("/errors/message");
            } else {
                session.setAttribute("member", memberService.checkMember(member));
                mav.addObject("member", memberService.checkMember(member));
                mav.setViewName("/main/index");
            }
        } else {

            if(memberService.validateMember(member.getId())) {
                if(memberService.registerMember(member) > 0) mav.setViewName("/member/signin-form");
                else {
                    mav.addObject("msg", "회원 등록 실패");
                    mav.setViewName("/errors/message");
                }
            } else {
                mav.addObject("msg", "중복 아이디 존재");
                mav.setViewName("/errors/message");
            }
        }
        return mav;
    }

    /**
     * PATCH : request to update data
     * @param no
     * @return
     */
    @PatchMapping("/{no}")
    public Boolean patch(@PathVariable int no, @RequestBody final Member member, ModelAndView mav) {
        member.setNo(no);

        if(memberService.updateMember(member) == 1 ) return true;

        else return false;
    }

    /**
     * Delete Member
     */
    @DeleteMapping("/{no}")
    public void delete(@PathVariable int no, @RequestBody final Member member, HttpServletRequest request) {
        try {
            if(memberService.checkMember(member) != null) {
                memberService.deleteMemberByNo(no);
                request.getSession().setAttribute("member", null);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
