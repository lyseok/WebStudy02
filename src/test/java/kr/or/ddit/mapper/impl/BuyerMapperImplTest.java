package kr.or.ddit.mapper.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import kr.or.ddit.mapper.BuyerMapper;
import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerMapperImplTest {
	BuyerMapper mapper = new BuyerMapperImpl();
	
	@Test
	void testInsert() {
		BuyerVO buyer = new BuyerVO();
		buyer.setBuyerName("신규제조사");
		buyer.setLprodGu("P101");
		buyer.setBuyerBank("하나");
		buyer.setBuyerBankname("계좌주");
		assertEquals(1, mapper.insertBuyer(buyer)); 
	}
	
	@Test
	void testSelectbuyer() {
		BuyerVO buyer = mapper.selectBuyer("P10101");
		log.info("제조사 정보 : {} {} {}",
				buyer.getBuyerName(), buyer.getBuyerAdd2(), buyer.getLprod().getLprodName());
		buyer.getProdList().forEach((prod) -> log.info("거래상품목 : {} {} {}", prod.getProdName(), prod.getProdCost(), prod.getBuyerId()));
		
	}
	
	@Test
	void testSelectBuyerList() {
		List<BuyerVO> list = mapper.selectBuyerList();
		list.forEach(buyer -> log.info("제조사 정보 : {} {} {}", buyer.getBuyerName(),buyer.getLprod().getLprodName() , buyer.getProdList().size()));
	}

}
