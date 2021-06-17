package iducs.springboot.a201712007.service;
import iducs.springboot.a201712007.domain.Member;
import iducs.springboot.a201712007.mapper.MemberMapper;
import iducs.springboot.a201712007.mapper.TestMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Repository에서 사용될 데이터를 넘겨주고
 * 가공된 데이터를 받아 Controller에 리턴해준다.
 */
@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    MemberMapper memberMapper;


    /**
     * check member when login
     * @param member
     * @return member object
     */
    @Override
    public Member checkMember(Member member) {
        return memberMapper.checkMember(member);
    }

    /**
     * validate member
     * @param id
     * @return Whether the value exists.
     */
    @Override
    public boolean validateMember(String id) {
        return memberMapper.validateMemberById(id) >= 1 ? false : true;
    }

    /**
     * register member
     * @param member
     * @return member count
     */
    @Override
    public int registerMember(Member member) {
        return memberMapper.registerMember(member);
    }

    /**
     * get member
     * @param no
     * @return member
     */
    @Override
    public Member getMember(int no) { return memberMapper.getMemberByNo(no); }


    /**
     * update member
     * @param member
     * @return 1 or 0
     */
    @Override
    public int updateMember(Member member) { return memberMapper.updateMemberByNo(member); }

    /**
     * delete member
     * @param no
     * @return 1 or 0
     */
    @Override
    public int deleteMemberByNo(int no) { return memberMapper.deleteMemberByNo(no); }

}
