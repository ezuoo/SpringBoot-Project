package iducs.springboot.a201712007.service;


import iducs.springboot.a201712007.domain.Member;


public interface MemberService {
    int registerMember(Member member);
    Member checkMember(Member member);
    boolean validateMember(String id);
    Member getMember(int no);
    int updateMember(Member member);
    int deleteMemberByNo(int no);
}
