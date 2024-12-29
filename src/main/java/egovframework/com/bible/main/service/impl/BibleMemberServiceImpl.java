package egovframework.com.bible.main.service.impl;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import egovframework.com.bible.main.service.BibleMemberDAO;
import egovframework.com.bible.main.service.BibleMemberService;
import egovframework.com.bible.main.service.BibleMemberVO;


@Service("bibleMemberService")
public class BibleMemberServiceImpl extends EgovAbstractServiceImpl implements BibleMemberService{

	@Resource(name = "bibleMemberDAO")
    private BibleMemberDAO bibleMemberDAO;

	@Override
	public String insertBibleMember(BibleMemberVO bibleMemberVO) throws Exception {
		return bibleMemberDAO.insertBibleMember(bibleMemberVO);
	}
	
	@Override
	public String insertBibleMemberAuth(BibleMemberVO bibleMemberVO) throws Exception {
		return bibleMemberDAO.insertBibleMemberAuth(bibleMemberVO);
	}
	
}
