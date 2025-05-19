package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.mapper.impl.MbtiMapperImpl;
import kr.or.ddit.vo.MbtiVO;

class MbtiMapperTest {
	MbtiMapper mapper = new MbtiMapperImpl();
	
	@Test
	void testInsertMbti() {
		MbtiVO newMbti = new MbtiVO("AAAA");
		newMbti.setMtTitle("AAAA 타입 요약");
		newMbti.setMtContent("content");
		int cnt = mapper.insertMbti(newMbti);
		assertEquals(1, cnt);
	}

	@Test
	void testSelectMbtiList() {
		mapper.selectMbtiList()
			.forEach(System.out::println);
	}

	@Test
	void testSelectMbti() {
		assertNotNull(mapper.selectMbti("istp"));
	}

	@Test
	void testUpdateMbti() {
		MbtiVO newMbti = mapper.selectMbti("AAAA");
		newMbti.setMtTitle("AAAA 수정");
		newMbti.setMtContent("content 수정");
		int cnt = mapper.updateMbti(newMbti);
		assertEquals(1, cnt);
	}

	@Test
	void testDeleteMbti() {
		int cnt = mapper.deleteMbti("AAAA");
		assertEquals(1, cnt);
	}

}
