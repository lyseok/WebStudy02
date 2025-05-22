package kr.or.ddit.mapper.impl;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.mapper.ProdMapper;
import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class ProdMapperImplTest {
	private ProdMapper mapper = new ProdMpperImpl();
	
	@Test
	void testInsertProd() {
//		ProdVO prod = new ProdVO();
//		prod.setProdId("P101000008");
//		prod.setLprodGu("P101");
//		prod.setBuyerId("P10101");
//		prod.setProdName("testname");
		ProdVO prod = ProdVO.builder()
				.prodId("P101000009")
				.lprodGu("P101")
				.buyerId("P10101")
				.prodName("test name")
				.build();
		assertEquals(1, mapper.insertProd(prod));
	}

	@Test
	void testSelectProdList() {
		mapper.selectProdList().forEach((prod)->{
			System.out.println(prod);
		});
		assertNotNull(mapper.selectProdList());
	}
	
	@Test
	void testSelectProdListForMap() {
		mapper.selectProdListForMap()
			.forEach(map -> log.info("===> {}", map.get("BUYER_ADD1")));
	}

	@Test
	void testSelectProd() {
		assertNotNull(mapper.selectProd("P101000001"));
	}

	@Test
	void testUpdateProd() {
		ProdVO prod = ProdVO.builder()
				.prodId("P101000009")
				.lprodGu("P101")
				.buyerId("P10101")
				.prodName("update test")
				.build();
		assertEquals(1, mapper.updateProd(prod));
	}

}
