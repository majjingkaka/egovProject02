package egovframework.com.bible.service.member.sec;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import egovframework.com.bible.domain.MemberVO;

public class BibleUserMapping implements RowMapper<UserDetails> {

	@Override
	public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
		String username = rs.getString("username");
    	String password = rs.getString("password");

    	MemberVO memberVO = new MemberVO();
    	//memberVO.setUserSn(rs.getInt("USER_SN"));
    	memberVO.setUserId(username);
    	memberVO.setPassword(password);
    	memberVO.setUserNm(rs.getString("USER_NM"));
    	memberVO.setUserEmad(rs.getString("USER_EMAD"));
    	memberVO.setUserCpno(rs.getString("USER_CPNO"));
    	memberVO.setAuthorCd(rs.getString("AUTHOR_CD"));
    	//memberVO.setUserPin(rs.getString("USER_PIN"));
    	//memberVO.setCrtfcSeCd(rs.getString("CRTFC_SE_CD"));
    	//memberVO.setChldCrtfcAt(rs.getString("CHLD_CRTFC_AT"));
    	//memberVO.setBrthdy(rs.getString("BRTHDY"));
    	//memberVO.setSexCd(rs.getString("SEX_CD"));
    	//memberVO.setMmbrTypCd(rs.getString("MMBR_TYP_CD"));
    	//memberVO.setMediaName(rs.getString("MEDIA_NAME"));
    	//memberVO.setWrtrNcknm(rs.getString("WRTR_NCKNM"));
    	
    	
    	
    	
        return new BibleUserDetails(username, password, true, true, true, true, AuthorityUtils.NO_AUTHORITIES, memberVO);
    }

}
