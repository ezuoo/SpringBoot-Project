package iducs.springboot.a201712007.repository;

import iducs.springboot.a201712007.domain.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



@Repository
public class BlogRepositoryImpl implements BlogRepository{

    public final JdbcTemplate jdbcTemplate;

    public BlogRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * database query : CREATE execution.
     * @param blog
     * @return
     */
    @Override
    public int create(Blog blog) {
        return jdbcTemplate.update(
                "insert into blog (member_id, title, content, date, file) values(?, ?, ?, CURRENT_TIMESTAMP(), ?)",
                blog.getMember_id(),blog.getTitle(), blog.getContent(), blog.getFile());
    }

    /**
     * database query : SELECT ITEM execution.
     * @param no
     * @return
     */
    @Override
    public Blog readBlog(int no) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM blog WHERE no=?", (rs, rowNum) -> {
                Blog blog = new Blog();
                blog.setNo(rs.getInt("no"));
                blog.setMember_id(rs.getString("member_id"));
                blog.setTitle(rs.getString("title"));
                blog.setContent(rs.getString("content"));
                blog.setDate(rs.getString("date"));
                blog.setFile(rs.getString("file"));
                return blog;
            }, no);
        } catch(EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * database query : SELECT LIST execution.
     * @return
     */
    @Override
    public List<Blog> readBlogs() {
        try {
            return jdbcTemplate.query("SELECT * FROM blog", new RowMapper<Blog>() {
                @Override
                public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Blog blog = new Blog();
                    blog.setNo(rs.getInt("no"));
                    blog.setMember_id(rs.getString("member_id"));
                    blog.setTitle(rs.getString("title"));
                    blog.setContent(rs.getString("content"));
                    blog.setDate(rs.getString("date"));
                    blog.setFile(rs.getString("file"));
                    return blog;
                }

            });
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * database query : DELETE ITEM execution.
     * @param no
     * @return
     */
    @Override
    public int delete(int no) { return jdbcTemplate.update("DELETE FROM blog where no = ?", no); }

    /**
     * database query : UPDATE ITEM execution.
     * @param blog
     * @return
     */
    @Override
    public int update(Blog blog) {
        return jdbcTemplate.update(
                "UPDATE blog SET title=?, content=?, date=CURRENT_TIMESTAMP() WHERE no=?",
                blog.getTitle(),
                blog.getContent(),
                blog.getNo());
    }


}
