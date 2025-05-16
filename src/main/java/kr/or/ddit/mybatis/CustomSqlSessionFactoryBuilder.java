package kr.or.ddit.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.builder.BuilderException;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class CustomSqlSessionFactoryBuilder {
	private static SqlSessionFactory sqlSessionFactory;

	static {
		String location = "kr/or/ddit/mybatis/Configuration.xml";
		try (Reader rd = Resources.getResourceAsReader(location)) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
		} catch (IOException e) {
			throw new BuilderException(e);
		}
	}
	
	public static SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}
}
