package iducs.springboot.a201712007.controller;

import iducs.springboot.a201712007.domain.Blog;
import iducs.springboot.a201712007.service.BlogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogServiceImpl blogService;


    /**
     * GET : request view and datas
     * @return view
     */
    @GetMapping("")
    public ModelAndView get(HttpServletRequest request, ModelAndView mav) {

        HttpSession session = request.getSession();

        // mapping to create-view
        if(request.getParameter("a").equals("c")) {
            mav.setViewName("/blog/create-form");
        }

        // mapping to update-view
        else if(request.getParameter("a").equals("u")) {
            int no = (int) request.getSession().getAttribute("no");

            if(blogService.getBlog(no) != null) {
                mav.addObject("blog", blogService.getBlog(no));
                mav.setViewName("/blog/update-form");
            } else {
                mav.addObject("msg", "데이터 불러오기 오류");
                mav.setViewName("/errors/message");
            }
        }

        // mapping to list-view
        else {
            mav.addObject("blogs", blogService.getBlogs());
            mav.setViewName("/blog/list-view");
        }
        mav.addObject("member", session.getAttribute("member"));
        return mav;
    }

    /**
     * GET : request view and data
     * @param no
     * @param mav
     * @param request
     * @return view and data
     */
    @GetMapping("/{no}")
    public ModelAndView get(@PathVariable int no, ModelAndView mav, HttpServletRequest request) {
        if (blogService.getBlog(no) != null) {
            request.getSession().setAttribute("no", no);
            mav.addObject("blog", blogService.getBlog(no));
            mav.setViewName("/blog/read-view");
        } else {
            mav.addObject("msg", "데이터 불러오기 오류");
            mav.setViewName("/errors/message");
        }
        mav.addObject("member", request.getSession().getAttribute("member"));
        return mav;
    }

    /**
     * POST : request to save data
     * @param blog
     * @param mav
     * @return view and object
     */
    @PostMapping("")
    public ModelAndView post(Blog blog, ModelAndView mav, @RequestBody MultipartFile filepath, HttpServletRequest request) {
        if(filepath != null) {
            try {
                String path = "C:/Users/juho0/Desktop/Cactus/About Programing/3학년 1학기/Spring/project_jdbc/src/main/resources/static/files/";
                filepath.transferTo(new File(path + System.currentTimeMillis() + filepath.getOriginalFilename()));
                blog.setFile(filepath.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            blog.setFile("");
        }

        if(blogService.postBlog(blog) > 0) {

            mav.addObject("blogs", blogService.getBlogs());
            mav.setViewName("/blog/list-view");
        }
        else {
            mav.addObject("msg", "글 등록 실패");
            mav.setViewName("/errors/message");
        }
        mav.addObject("member", request.getSession().getAttribute("member"));
        return mav;
    }


    /**
     * PATCH : request to update data
     * @param blog
     * @param no
     * @param mav
     * @return view and object
     */
    @PatchMapping("/{no}")
    public ModelAndView patch(@RequestBody final Blog blog, @PathVariable int no, ModelAndView mav) {
        blog.setNo(no);

        if(blogService.updateBlog(blog) > 0) {
            mav.addObject("blog", blogService.getBlog(no));
            mav.setViewName("/blog/read-view");
        } else {
            mav.addObject("msg", "글 수정 실패");
            mav.setViewName("/errors/message");
        }

        return mav;
    }

    /**
     * DELETE : request to delete data
     * @param no
     * @param mav
     * @return view and object
     */
    @DeleteMapping("/{no}")
    public ModelAndView delete(@PathVariable int no, ModelAndView mav, HttpServletRequest request) {
        if(request.getSession().getAttribute("no").equals(no)) {
            if (blogService.deleteBlog(no) > 0) {
                request.getSession().setAttribute("no", "");
                mav.addObject("blogs", blogService.getBlogs());
                mav.setViewName("/blog/list-view");
            } else {
                mav.addObject("msg", "글 삭제 실패");
                mav.setViewName("/errors/message");
            }
        } else {
            mav.addObject("msg", "글 삭제 실패");
            mav.setViewName("/errors/message");
        }

        return mav;
    }
}
