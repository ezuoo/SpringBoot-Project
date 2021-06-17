package iducs.springboot.a201712007.repository;


import iducs.springboot.a201712007.domain.Blog;

import java.util.List;

public interface BlogRepository {
    int create(Blog Blog);
    Blog readBlog(int no);
    List<Blog> readBlogs();
    int update(Blog blog);
    int delete(int no);
}
