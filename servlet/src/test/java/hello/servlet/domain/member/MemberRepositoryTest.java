package hello.servlet.domain.member;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

	
	//싱글톤이기 때문에 new로 생성하면 안됨. => spring을 쓰면 싱클톤 굳이 만들어줄 필요 없음.
	MemberRepository memberRepository = MemberRepository.getInstance();
	
	
	@AfterEach
	void afterEach() {
		memberRepository.clearStore();
	}
	
	@Test
	void save() {
		//given
		Member member = new Member("hello", 20);
		
		//when
		Member savedMember = memberRepository.save(member);
		
		//then
		Member findMember = memberRepository.findById(savedMember.getId());
		
		//findMember이 savedMember과 같은가?
		Assertions.assertThat(findMember).isEqualTo(savedMember);
	}
	
	@Test
	void findAll() {
		//given
		Member member1 = new Member("member1",20);
		Member member2 = new Member("member2",30);
		
		memberRepository.save(member1);
		memberRepository.save(member2);
		
		//when
		List<Member> result = memberRepository.findAll();
		
		//then
		assertThat(result.size()).isEqualTo(2);
		
		//result안에 member1, member2가 있는가?
		assertThat(result).contains(member1, member2);
	}
	
}
