package kr.or.ddit.mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

class CustomSqlSessionFactoryBuilderTest {

	@Test
	void testGetSqlSesssionFactory() {
		SqlSessionFactory factory = CustomSqlSessionFactoryBuilder.getSqlSessionFactory();
		try (SqlSession sqlSession = factory.openSession()) {
			System.out.println(sqlSession);
		}
	}

}
