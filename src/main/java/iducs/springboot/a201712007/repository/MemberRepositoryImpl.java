package iducs.springboot.a201712007.repository;

import iducs.springboot.a201712007.domain.Member;
import iducs.springboot.a201712007.repository.MemberRepository;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * DB 작업 영역
 */
@Repository
public class MemberRepositoryImpl implements MemberRepository {

    private SqlSession sqlSession;


    @Override
    public int create(Member member) {
        return 0;
    }

    @Override
    public Member readMember(int id) {
        return null;
    }



    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int delete(int id) {
        return 0;
    }

    @Override
    public List<Member> readMembers() {
        System.out.println("func readMembers in repository");
        sqlSession.selectList("");
        return null;
    }
}
