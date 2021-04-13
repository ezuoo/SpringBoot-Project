package iducs.springboot.a201712007.repository;

import iducs.springboot.a201712007.domain.Member;
import iducs.springboot.a201712007.repository.MemberRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemberRepositoryImpl implements MemberRepository {
    @Override
    public int create(Member member) {
        return 0;
    }

    @Override
    public Member readMember(int id) {
        return null;
    }

    @Override
    public List<Member> readMembers() {
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
}
