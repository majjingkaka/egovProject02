package egovframework.com.bible.main.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.com.cmm.dao.CommonSqlDao;

@Controller
public class BibleIndexController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	
	
	@RequestMapping("/bible/index.do")
	public String index(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			) {
		log.debug("BibleIndexController index call...");
		
		
		return "bible/main/bibleIndex";
	}
	
}
