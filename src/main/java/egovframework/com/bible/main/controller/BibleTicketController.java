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
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.dao.CommonSqlDao;

@Controller
public class BibleTicketController {
	
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	
	@RequestMapping("/bible/bibleTicket/list.do")
	public String list(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			) {
		log.debug("BibleTicketController bibleTicket list call...");
		
		Map<String, Object> param = new HashMap<>();
		
		
		return "bible/bibleTicket/list";
	}
	
}
