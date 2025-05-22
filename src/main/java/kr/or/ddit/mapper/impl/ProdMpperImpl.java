package kr.or.ddit.mapper.impl;

import java.util.List;
import java.util.Map;


import kr.or.ddit.mapper.ProdMapper;
import kr.or.ddit.mapper.util.MapperProxyTemplate;
import kr.or.ddit.vo.ProdVO;

public class ProdMpperImpl implements ProdMapper {
	private MapperProxyTemplate<ProdMapper> template = new MapperProxyTemplate(ProdMapper.class);

	@Override
	public int insertProd(ProdVO prod) {
		return template.execute((mp)->mp.insertProd(prod));
	}

	@Override
	public List<ProdVO> selectProdList() {
//		1. 세션 개방
//		2. 메소드 실행
//		3. 세션 종료
		return template.execute((mp)->mp.selectProdList());
//		try (
//			SqlSession sqlSession = factory.openSession()
//		){
//			ProdMapper proxy = sqlSession.getMapper(ProdMapper.class);
//			return proxy.selectProdList();
//			
////			return sqlSession.selectList("kr.or.ddit.mapper.ProdMapper.selectProdList");
//		}
	}
	
	@Override
	public List<Map<String, Object>> selectProdListForMap() {
		// TODO Auto-generated method stub
		return template.execute((mp)->mp.selectProdListForMap());
	}
	
	@Override
	public ProdVO selectProd(String prodId) {
		return template.execute((mp)->mp.selectProd(prodId));
//		1. 세션 개방
//		2. Mapper proxy 생성
//		3. proxy가 가진 메소드 실행
//		4. 세션 종료
//		try (
//			SqlSession sqlSession = factory.openSession()
//		) {
//			ProdMapper proxy = sqlSession.getMapper(ProdMapper.class);
//			return proxy.selectProd(prodId);			
//			
////			return sqlSession.selectOne("kr.or.ddit.mapper.ProdMapper.selectProd", prodId);
//		}
	}

	@Override
	public int updateProd(ProdVO prod) {
		return template.execute((mp)->mp.updateProd(prod));
	}

}
