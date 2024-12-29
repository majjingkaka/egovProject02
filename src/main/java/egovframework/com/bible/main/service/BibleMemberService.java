package egovframework.com.bible.main.service;

import java.util.Map;

/**
 * 주소록정보를 관리하기 위한 서비스 인터페이스 클래스
 * @author 공통컴포넌트팀 윤성록
 * @since 2009.09.25
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    --------    ---------------------------
 *   2009.9.25  윤성록          최초 생성
 *   2016.12.13 최두영          클래스명 변경
 * </pre>
 */
public interface BibleMemberService {
    
	public String insertBibleMember(BibleMemberVO bibleMemberVO) throws Exception;   
	public String insertBibleMemberAuth(BibleMemberVO bibleMemberVO) throws Exception;
}