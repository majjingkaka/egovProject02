package egovframework.com.bible.service.member.sec;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import egovframework.com.bible.domain.MemberVO;

public class MngUserMapping implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
    	String userId = rs.getString("USER_ID");
    	String password = rs.getString("PASSWORD");

    	MemberVO memberVO = new MemberVO();
    	memberVO.setMngrAt("Y");
    	//memberVO.setUserSn(rs.getLong("USER_SN"));
    	memberVO.setUserId(userId);
    	memberVO.setUserPin(userId);
    	memberVO.setPassword(password);
    	memberVO.setUserNm(rs.getString("USER_NM"));
    	memberVO.setAuthorCd(rs.getString("AUTHOR_CD"));
    	//memberVO.setDeptId(rs.getString("DEPT_ID"));
    	//memberVO.setDeptNm(rs.getString("DEPT_NM"));
    	memberVO.setUserEmad(rs.getString("USER_EMAD"));
    	memberVO.setUserCpno(rs.getString("USER_CPNO"));
    	//memberVO.setDutyNm(rs.getString("DUTY_NM"));
    	
        return new BibleUserDetails(userId, password, true, true, true, true, AuthorityUtils.NO_AUTHORITIES, memberVO);
    }

}
