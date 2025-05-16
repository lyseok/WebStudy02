package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.mapper.impl.MbtiMapperImpl;

class MbtiMapperTest {
	MbtiMapper mapper = new MbtiMapperImpl();
	
	@Test
	void testInsertMbti() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectMbtiList() {
		mapper.selectMbtiList()
			.forEach(System.out::println);
	}

	@Test
	void testSelectMbti() {
		System.out.println(mapper.selectMbti("istp"));
	}

	@Test
	void testUpdateMbti() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteMbti() {
		fail("Not yet implemented");
	}

}
