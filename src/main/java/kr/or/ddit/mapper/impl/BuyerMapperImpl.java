package kr.or.ddit.mapper.impl;

import kr.or.ddit.mapper.BuyerMapper;
import kr.or.ddit.mapper.util.MapperProxyTemplate;
import kr.or.ddit.vo.BuyerVO;

public class BuyerMapperImpl implements BuyerMapper {
	private MapperProxyTemplate<BuyerMapper> template = new MapperProxyTemplate<BuyerMapper>(BuyerMapper.class);

	@Override
	public BuyerVO selectBuyer(String buyerId) {
		return template.execute((mp)->mp.selectBuyer(buyerId));
	}

}
