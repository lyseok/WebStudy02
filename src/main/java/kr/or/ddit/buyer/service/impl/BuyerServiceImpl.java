package kr.or.ddit.buyer.service.impl;

import java.util.Optional;

import kr.or.ddit.buyer.service.BuyerService;
import kr.or.ddit.mapper.BuyerMapper;
import kr.or.ddit.mapper.impl.BuyerMapperImpl;
import kr.or.ddit.vo.BuyerVO;

public class BuyerServiceImpl implements BuyerService {
	BuyerMapper mapper = new BuyerMapperImpl();
	
	@Override
	public Optional<BuyerVO> readBuyer(String buyerId) {
		return Optional.ofNullable(mapper.selectBuyer(buyerId));
	}

}
