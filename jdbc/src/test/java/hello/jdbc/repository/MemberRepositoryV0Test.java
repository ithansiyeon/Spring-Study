package hello.jdbc.repository;

import hello.jdbc.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
class MemberRepositoryV0Test {
	MemberRepositoryV0 repository = new MemberRepositoryV0();
	@Test
	void crud() throws SQLException {
		//save
		Member member = new Member("memberV6", 10000);
		repository.save(member);

		//find
		Member findMember = repository.findById(member.getMemberId());
		log.info("findMember={}", findMember);
		log.info("member != findMember {}", member == findMember);
		// 롬복 쓰면 EqualsAndHashCode 자동으로 make
		log.info("member equals findMember {}", member.equals(findMember));
		assertThat(findMember).isEqualTo(member);

		//update: money : 10000 -> 20000
		repository.update(member.getMemberId(), 20000);
		Member updatedMember = repository.findById(member.getMemberId());
		assertThat(updatedMember.getMoney()).isEqualTo(20000);

		//delete
		repository.delete(member.getMemberId());
		Assertions.assertThatThrownBy(() -> repository.findById(member.getMemberId()))
				.isInstanceOf(NoSuchElementException.class)
                .hasMessageContaining("member not found memberId=" + member.getMemberId());
	}
}