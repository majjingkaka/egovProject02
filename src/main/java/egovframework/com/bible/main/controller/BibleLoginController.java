package egovframework.com.bible.main.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.security.core.context.SecurityContext;

import egovframework.com.bible.domain.MemberVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.dao.CommonSqlDao;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.bible.service.member.sec.BibleUserDetails;

@Controller
public class BibleLoginController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	
	
	
	@RequestMapping("/bible/bibleLogin/login.do")
	public String forlogin(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			) {
		log.debug("BibleLoginController forlogin login call...");
		
		Map<String, Object> param = new HashMap<>();
		
		
		return "bible/bibleLogin/login";
	}
	
	@RequestMapping("/bible/bibleLogin/toLogin.do")
	public String toLogin(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request, ModelMap model
			) {
		log.debug("BibleLoginController toLogin call...");
		
		Map<String, Object> param = new HashMap<>();
		
		MemberVO user = (MemberVO)EgovUserDetailsHelper.getAuthenticatedUser();
		
		
		//MemberVO vo = new MemberVO();
		//vo.setUserId("doochuli2");
		//vo.setPassword("123");
		
		//setAuthentication2(vo,request);
		
		return "redirect:/bible/main.do";
	}
	
	public void setAuthentication2(MemberVO vo, HttpServletRequest request) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
    	SimpleGrantedAuthority vnameAuthority = new SimpleGrantedAuthority("ROLE_ADMIN1");
    	//SimpleGrantedAuthority vnameAuthority2 = new SimpleGrantedAuthority("ROLE_VNAME");
    	authorities.add(vnameAuthority);
    	//authorities.add(vnameAuthority2);
    	SecurityContext securityContext = SecurityContextHolder.getContext();
    	BibleUserDetails userDetail = new BibleUserDetails(String.valueOf(vo.getUserId()), vo.getPassword(), true, vo);
    	securityContext.setAuthentication(new UsernamePasswordAuthenticationToken(userDetail,String.valueOf(vo.getUserId()), authorities));
		HttpSession session =  request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", securityContext);
	}
	
	
	@RequestMapping(value = "/bible/bibleLogin/logout.do")
	public String actionLogout(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			) throws Exception {
		
		/*String userIp = EgovClntInfo.getClntIP(request);

		// 1. Security 연동
		return "redirect:/j_spring_security_logout";*/

		request.getSession().setAttribute("loginVO", null);
		// 세션모드인경우 Authority 초기화
		// List<String> authList = (List<String>)EgovUserDetailsHelper.getAuthorities();
		request.getSession().setAttribute("accessUser", null);
		
		if (request.getSession() != null) {
			request.getSession().invalidate();
		}
		
		SecurityContextHolder.clearContext();
		
		//return "redirect:/egovDevIndex.jsp";
		return "redirect:/bible/main.do";
		//return "index";
	}
	
	
}
