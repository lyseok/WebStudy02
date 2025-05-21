package kr.or.ddit.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.mapper.impl.MbtiMapperImpl;
import kr.or.ddit.vo.MbtiVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class MbtiMapperTest {
//	Logger log = LoggerFactory.getLogger(MbtiMapperTest.class);
	MbtiMapper mapper = new MbtiMapperImpl();
	
	@Test
	void testInsertMbti() {
		MbtiVO newMbti = new MbtiVO("eeee");
		newMbti.setMtTitle("AAAA 타입 요약");
		newMbti.setMtContent("content");
		int cnt = mapper.insertMbti(newMbti);
		assertEquals(1, cnt);
	}

	@Test
	void testSelectMbtiList() {
		List<MbtiVO> list = mapper.selectMbtiList();
		if(log.isTraceEnabled()) {
			log.trace("기록이 되냐");			
		} else {
//			log.info("기록좀 해라 {}", list);
//			list.forEach((mbti)->log.info("===>{}", mbti));
		}
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
