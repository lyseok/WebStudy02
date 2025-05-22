package kr.or.ddit.buyer.service;

import java.util.Optional;

import kr.or.ddit.vo.BuyerVO;

/**
 * 제조사 관리용 business logic layer
 */
public interface BuyerService {	
	public Optional<BuyerVO> readBuyer(String buyerId);
}
