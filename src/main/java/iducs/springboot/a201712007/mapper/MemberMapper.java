package iducs.springboot.a201712007.mapper;

import iducs.springboot.a201712007.domain.Member;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public Member getMemberById(String id);
    public Member getMemberByNo(int no);
    public Member checkMember(Member member);
    public int validateMemberById(String id);
    public int registerMember(Member member);
    public int updateMemberByNo(Member member);
    public int deleteMemberByNo(int no);
}
