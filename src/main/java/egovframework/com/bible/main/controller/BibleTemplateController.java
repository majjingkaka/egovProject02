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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.WebUtils;

import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.dao.CommonSqlDao;

@Controller
public class BibleTemplateController {

Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	
	//@RequestMapping("/{siteId}/**")
	//@RequestMapping(value = { "/{siteId}/**" })
	public void bibleTemplate(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @PathVariable String siteId
			//, @PathVariable String path
			) throws Exception{
		log.debug("BibleTemplateController bibleTemplate call... siteId:"+siteId);
		
		Map<String, Object> param = new HashMap<>();
		
		/*
		String requestUri = request.getRequestURI();
		String currentUri = requestUri.substring(siteId.length() + 1);
		String[] mcode = requestUri.split("/");
		
		
		model.addAttribute("siteId", siteId);
		//model.addAttribute("path", path);
		model.addAttribute("requestUri", requestUri);
		model.addAttribute("currentUri", currentUri);
		model.addAttribute("mcode1", mcode[1]);
		*/
		
		//https://gymdev.tistory.com/69
		//LoginVO lgBean = (LoginVO) WebUtils.getSessionAttribute(request, "loginVO");
		
		
	}
	
}
