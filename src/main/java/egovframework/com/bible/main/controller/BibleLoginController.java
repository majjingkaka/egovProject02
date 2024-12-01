package egovframework.com.bible.main.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.dao.CommonSqlDao;

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
	}
	
	
}
