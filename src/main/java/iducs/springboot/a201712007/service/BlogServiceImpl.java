package iducs.springboot.a201712007.service;

import iducs.springboot.a201712007.domain.Blog;
import iducs.springboot.a201712007.repository.BlogRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepositoryImpl blogRepository;


    /**
     * GET a Blog
     * @param no
     * @return a Blog
     */
    @Override
    public Blog getBlog(int no) {
        return blogRepository.readBlog(no);
    }

    /**
     * GET Blogs
     * @return Blogs
     */
    @Override
    public List<Blog> getBlogs() {
        return blogRepository.readBlogs();
    }

    /**
     * POST a Blog
     * @param blog
     * @return success or fail value
     */
    @Override
    public int postBlog(Blog blog) {
        return blogRepository.create(blog);
    }

    /**
     * PATCH a Blog
     * @param blog
     * @return success or fail value
     */
    @Override
    public int updateBlog(Blog blog) {
        return blogRepository.update(blog);
    }

    /**
     * DELETE a Blog
     * @param no
     * @return success or fail value
     */
    @Override
    public int deleteBlog(int no) { return blogRepository.delete(no); }
}
