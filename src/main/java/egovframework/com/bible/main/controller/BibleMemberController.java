package egovframework.com.bible.main.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.bible.main.service.BibleMemberVO;
import egovframework.com.cmm.dao.CommonSqlDao;

@Controller
public class BibleMemberController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	
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
			) {
		log.debug("BibleMemberController insert call...");
		
		Map<String, Object> param = new HashMap<>();
		
		
		return "redirect:/bible/main.do";
	}
}
