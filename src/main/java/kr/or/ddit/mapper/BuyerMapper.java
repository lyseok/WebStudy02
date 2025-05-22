package kr.or.ddit.mapper;

import kr.or.ddit.vo.BuyerVO;

/**
 * 제조사 관리용 Persistence layer
 */
public interface BuyerMapper {
	public BuyerVO selectBuyer(String buyerId);
}
