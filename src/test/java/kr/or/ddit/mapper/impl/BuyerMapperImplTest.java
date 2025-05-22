package kr.or.ddit.mapper.impl;

import org.junit.jupiter.api.Test;

import kr.or.ddit.mapper.BuyerMapper;
import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerMapperImplTest {
	BuyerMapper mapper = new BuyerMapperImpl();
	
	@Test
	void testSelectbuyer() {
		BuyerVO buyer = mapper.selectBuyer("P10101");
		log.info("제조사 정보 : {} {} {}",
				buyer.getBuyerName(), buyer.getBuyerAdd2(), buyer.getLprod().getLprodName());
		buyer.getProdList().forEach((prod) -> log.info("거래상품목 : {} {} {}", prod.getProdName(), prod.getProdCost(), prod.getBuyerId()));
		
	}

}
