package egovframework.com.bible.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.egovframe.rte.fdl.idgnr.EgovIdGnrService;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.bible.main.service.BibleMemberService;
import egovframework.com.bible.main.service.BibleMemberVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.dao.CommonSqlDao;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.sim.service.EgovFileScrty;

@Controller
public class BibleMemberController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	
	
	
	@Resource(name = "bibleMemberService")
	protected BibleMemberService bibleMemberService;
	
	//@Resource(name="passwordEncoder")
	//private PasswordEncoder passwordEncoder;
	
	
	/** egovUsrCnfrmIdGnrService */
	@Resource(name="egovUsrCnfrmIdGnrService")
	private EgovIdGnrService idgenService;
	
	
	
	
	@RequestMapping("/bible/bibleMember/forInsert.do")
	public String forInsert(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			) {
		log.debug("BibleMemberController forInsert call...");
		
		Map<String, Object> param = new HashMap<>();
		
		
		return "bible/bibleMember/reg";
	}
	
	@RequestMapping("/bible/bibleMember/insert.do")
	public String insert(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @ModelAttribute("bibleMemberVO") BibleMemberVO bibleMemberVO
			) throws Exception {
		log.debug("BibleMemberController insert call...");
		
		Map<String, Object> param = new HashMap<>();
		
		//고유아이디 셋팅
		String uniqId = idgenService.getNextStringId();
		bibleMemberVO.setUniqId(uniqId);
		//String password = passwordEncoder.encode(bibleMemberVO.getPassword());
		
		String encryptPass = EgovFileScrty.encryptPassword(bibleMemberVO.getPassword(), bibleMemberVO.getUserId());
		bibleMemberVO.setPassword(encryptPass);
		bibleMemberVO.setMberSttus("P");
		
		String v = bibleMemberService.insertBibleMember(bibleMemberVO);
		
		
		bibleMemberVO.setMberTyCode("USR01");
		bibleMemberVO.setAuthorCode("ROLE_USER");
		String v2 = bibleMemberService.insertBibleMemberAuth(bibleMemberVO);
		
		log.debug("v : "+v);
		log.debug("v2 : "+v2);
		
		
		//LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
        //Boolean isAuthenticated = EgovUserDetailsHelper.isAuthenticated();
		
		
		
		
		
		
		
		
		return "redirect:/bible/main.do";
	}
}
