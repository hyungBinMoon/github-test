package hello.springbasic.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import domain.Member;
import repository.MemberRepository;
import repository.MemoryMemberRepository;

class MemoryMemberRepositoryTest {
	MemoryMemberRepository repository = new MemoryMemberRepository();
	
	@AfterEach			//AfterEach 어노테이션은 @Test 가 실행될 때마다 실행되도록 설
	public void afterEach() {
		repository.storeClear();
	}
	
	@Test
	public void save() {
		//given
		Member member = new Member();
		member.setName("spring");
		
		//when
		repository.save(member);
	
		//then
		Member result = repository.findById(member.getId()).get();
		Assertions.assertEquals(member, result); 
		
	}
}
