package hello.servlet.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

// 테스트는 순서가 보장이 안됨 -> 독립적으로 해야함 ( clearStore )
class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    void save() {
        // given
        Member member = new Member("ko", 28);

        // when
        Member saveMember = memberRepository.save(member);

        // then
        Member findMember = memberRepository.findById(saveMember.getId());
        Assertions.assertThat(findMember).isEqualTo(saveMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("ko", 28);
        Member member2 = new Member("go", 29);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> allMembers = memberRepository.findAll();

        //then
        Assertions.assertThat(allMembers.size()).isEqualTo(2);
        Assertions.assertThat(allMembers).contains(member1, member2);
    }

}