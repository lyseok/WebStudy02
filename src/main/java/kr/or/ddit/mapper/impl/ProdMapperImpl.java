package kr.or.ddit.mapper.impl;

import java.util.List;

import kr.or.ddit.mapper.ProdMapper;
import kr.or.ddit.mapper.util.MapperProxyTemplate;
import kr.or.ddit.vo.ProdVO;

public class ProdMapperImpl implements ProdMapper {
//	SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	MapperProxyTemplate<ProdMapper> template = new MapperProxyTemplate(ProdMapper.class);
	
	@Override
	public int insertProd(ProdVO prod) {
		return template.execute(mp -> mp.insertProd(prod));
	}

	@Override
	public List<ProdVO> selectProdList() {
		return template.execute(mp -> mp.selectProdList());
	}

	@Override
	public ProdVO selectProd(String prodId) {
		return template.execute(mp -> mp.selectProd(prodId));
	}

	@Override
	public int updateProd(ProdVO prod) {
		return template.execute(mp -> mp.updateProd(prod));
	}

}
