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
		// TODO Auto-generated method stub
		return 0;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMbti(String mtType) {
		// TODO Auto-generated method stub
		return 0;
	}

}
