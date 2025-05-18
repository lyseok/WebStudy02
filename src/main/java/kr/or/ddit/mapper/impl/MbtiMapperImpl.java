package kr.or.ddit.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mapper.MbtiMapper;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MbtiVO;

public class MbtiMapperImpl implements MbtiMapper {
	SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
	
	@Override
	public int insertMbti(MbtiVO mbti) {
		try (SqlSession sqlSession = factory.openSession()) {
			int res = sqlSession.insert("kr.or.ddit.mapper.MbtiMapper.insertMbti", mbti);
			if(res >= 1) sqlSession.commit();
			return res;
		}
	}

	@Override
	public List<MbtiVO> selectMbtiList() {
		try (SqlSession sqlSession = factory.openSession()) {
			return sqlSession.selectList("kr.or.ddit.mapper.MbtiMapper.selectMbtiList");
		}
	}

	@Override
	public MbtiVO selectMbti(String mtType) {
		try (SqlSession sqlSession = factory.openSession()) {
			return sqlSession.selectOne("kr.or.ddit.mapper.MbtiMapper.selectMbti", mtType);
		}
	}

	@Override
	public int updateMbti(MbtiVO mbti) {
		try (SqlSession sqlSession = factory.openSession()) {
			int res = sqlSession.update("kr.or.ddit.mapper.MbtiMapper.updateMbti", mbti);
			if(res >= 1) sqlSession.commit();
			return res;
		}
	}

	@Override
	public int deleteMbti(String mtType) {
		try (SqlSession sqlSession = factory.openSession()) {
			int res = sqlSession.delete("kr.or.ddit.mapper.MbtiMapper.deleteMbti", mtType);	
			if(res >= 1) sqlSession.commit();
			return res;
		}
	}

}
