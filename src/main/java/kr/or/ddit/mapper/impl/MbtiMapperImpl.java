package kr.or.ddit.mapper.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mapper.MbtiMapper;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MbtiVO;


/**
 * 1. SqlSessionFactory 를 싱글턴으로 빌드
 * 2. SqlSessionFactory 로부터 SqlSession open
 * 3. myBatis 내부의 쿼리를 쿼리 아이디를 이용해 실행함
 * 	쿼리 아이디: xml's namespace + "." + 쿼리 id 속성값
 * 	ex) kr.or.ddit.mapper.MbtiMapper.insertMbti 
 * 4. insert/update/delete 쿼리를 실행한 경우, 트랜잭션 종료 작업 필요(commit, rollback)
 * 		myBatis의 rollback표현
 * 		: Sqlsession이 close 될때까지, 커밋되지 않은 모든 데이터는 자동 롤백
 */
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
