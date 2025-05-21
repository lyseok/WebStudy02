package kr.or.ddit.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;

class MbtiVOTest {

	@Test
	void test() {
		MbtiVO newMbti = MbtiVO.builder()
								.mtSort(3)
								.mtSort(5)
								.mtType("istp")
								.mtTitle("istp 요약")
								.build();
		System.out.println(newMbti);
		ProdService test1 = new ProdServiceImpl();

	}

}
