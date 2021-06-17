package iducs.springboot.a201712007.service;

import iducs.springboot.a201712007.domain.Blog;
import java.util.List;

public interface BlogService {
    Blog getBlog(int no);
    List<Blog> getBlogs();
    int postBlog(Blog blog);
    int updateBlog(Blog blog);
    int deleteBlog(int no);
}
