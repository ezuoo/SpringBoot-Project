package iducs.springboot.a201712007.service;

import iducs.springboot.a201712007.domain.Member;
import iducs.springboot.a201712007.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Repository에서 사용될 데이터를 넘겨주고
 * 가공된 데이터를 받아 Controller에 리턴해준다.
 */
@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) { // MemberRepository 유형의 등록된 객체를 Spring Framework이 자동 주입
        this.memberRepository = memberRepository;
    }


    @Override
    public Member getMember(long id) {
        return null;
    }

    @Override
    public Member getMemberByEmail(String email) {
        return null;
    }

    @Override
    public List<Member> getMembers() {
        System.out.println("Service : getMembers method");
        return null;
    }

    @Override
    public List<Member> getMembersByPage(int index, int size) {
        return null;
    }

    @Override
    public int postMember(Member member) {
        System.err.println("Service : postMember method");
        System.out.println("E-mail : " + member.getEmail());
        System.out.println("Password : " + member.getPw());
        System.out.println("Name : " + member.getName());
        System.out.println("P-H : " + member.getPhone());
        System.out.println("Address : " + member.getAddress());
        return 0;
    }

    @Override
    public int putMember(Member member) {
        return 0;
    }

    @Override
    public int deleteMember(Member member) {
        return 0;
    }
}
