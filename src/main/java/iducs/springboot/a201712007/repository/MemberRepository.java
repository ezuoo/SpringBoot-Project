package iducs.springboot.a201712007.repository;

import iducs.springboot.a201712007.domain.Member;

import java.util.List;

public interface MemberRepository {
    int create(Member member);
    Member readMember(int id);
    List<Member> readMembers();
    int update(Member member);
    int delete(int id);
}
