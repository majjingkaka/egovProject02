package egovframework.com.cmm.dao;

import javax.annotation.Resource;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.egovframe.rte.psl.dataaccess.EgovAbstractMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository("commonSqlDao")
public class CommonSqlDao extends EgovAbstractMapper{ //extends EgovAbstractMapper
	private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name="egov.sqlSession")
	public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
		super.setSqlSessionFactory(sqlSession);
		//super.setSqlSessionTemplate(new SqlSessionTemplate(sqlSession, ExecutorType.SIMPLE));
	}
	
	
	
}
