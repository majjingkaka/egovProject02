package egovframework.com.bible.main.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.psl.dataaccess.util.EgovMap;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import egovframework.com.bible.main.service.BibleVo;
import egovframework.com.bible.main.service.EditUploadVo;
import egovframework.com.bible.main.service.Editor;
import egovframework.com.bible.main.service.SayRecordVo;
import egovframework.com.cmm.EgovWebUtil;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.dao.CommonSqlDao;
import egovframework.com.cmm.service.EgovProperties;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import egovframework.com.utl.fcc.service.EgovStringUtil;

@Controller
public class BibleSayRecordController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	

	
	@RequestMapping("/bible/bibleSayRecord/list.do")
	public String list(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @ModelAttribute("sayRecordVo") SayRecordVo sayRecordVo
			) throws Exception{
		log.debug("BibleSayRecordController list call...");
		
		
		LoginVO user = (LoginVO)EgovUserDetailsHelper.getAuthenticatedUser();
		
		
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(sayRecordVo.getPageIndex());
        paginationInfo.setRecordCountPerPage(sayRecordVo.getPageUnit());
        paginationInfo.setPageSize(sayRecordVo.getPageSize());
	
        sayRecordVo.setFirstIndex(paginationInfo.getFirstRecordIndex());
        sayRecordVo.setLastIndex(paginationInfo.getLastRecordIndex());
        sayRecordVo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
        //sayRecordVo.setWrterId(user == null ? "" : EgovStringUtil.isNullToString(user.getId()));
        //sayRecordVo.setTrgetOrgnztId(user == null ? "" : EgovStringUtil.isNullToString(user.getOrgnztId()));
        //int total = 0;
        
		try {
			Map<String, Object> param = new HashMap<>();
			List<EgovMap> bibleSayRecordList = commonSqlDao.selectList("bibleSayRecord.bibleSayRecordList",sayRecordVo);
			int bibleSayRecordListCnt = (Integer)commonSqlDao.selectOne("bibleSayRecord.bibleSayRecordListCnt",sayRecordVo);
			
			//Map<String, Object> map = commonSqlDao.selectList("bibleSayRecord.bibleSayRecordList",sayRecordVo);
			//total = bibleSayRecordList.size();
			
			//model.addAttribute("resultList", bibleSayRecordList);
			paginationInfo.setTotalRecordCount(bibleSayRecordListCnt);
			
			model.addAttribute("bibleSayRecordList", bibleSayRecordList);
			model.addAttribute("bibleSayRecordListCnt", bibleSayRecordListCnt);
			model.addAttribute("paginationInfo", paginationInfo);
			
			//param.put("bookAf", "A");
			//List<EgovMap> selectBibleBookOrdrList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookOrdrList",param);
			//model.addAttribute("selectBibleBookOrdrList", selectBibleBookOrdrList);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "bible/bibleSayRecord/list";
	}
	
	
	@RequestMapping("/bible/bibleSayRecord/view.do")
	public String view(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @ModelAttribute("sayRecordVo") SayRecordVo sayRecordVo
			) throws Exception{
		log.debug("BibleSayRecordController bibleSayRecord view call...");
		
		try {
			EgovMap bibleSayRecordOne = commonSqlDao.selectOne("bibleSayRecord.bibleSayRecordOne",sayRecordVo);
			model.addAttribute("result", bibleSayRecordOne);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "bible/bibleSayRecord/view";
	}
	
	
	
	
	
	
	
	
	@RequestMapping("/bible/bibleSayRecord/forInsert.do")
	public String forInsert(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model 
			) throws Exception{
		log.debug("BibleSayRecordController forInsert call...");
		Map<String, Object> param = new HashMap<>();
		
		List<EgovMap> selectBibleBookAfList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookAfList",param);
		model.addAttribute("selectBibleBookAfList", selectBibleBookAfList);
		
		
		
		param.put("bookAf", "A");
		List<EgovMap> selectBibleBookOrdrList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookOrdrList",param);
		model.addAttribute("selectBibleBookOrdrList", selectBibleBookOrdrList);
		
		
		return "bible/bibleSayRecord/reg";
	}
	
	
	@RequestMapping("/bible/bibleSayRecord/insert.do")
	public String insert(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @ModelAttribute("sayRecordVo") SayRecordVo sayRecordVo
			) throws Exception{
		log.debug("BibleSayRecordController insert call...");
		
		//sayRecordVo.setBbCn(EgovWebUtil.clearXSSMaximum(sayRecordVo.getBbCn()));
		
		sayRecordVo.setBbCn(EgovStringUtil.getHtmlStrCnvr(sayRecordVo.getBbCn()));
		//sayRecordVo.setBbCn(sayRecordVo.getBbCn().replaceAll("&gt;", ">"));
		
		Map<String, Object> param = new HashMap<>();
		//bibleSayRecord.insertBibleSayRecord
		
		sayRecordVo.setChurch("꿈이가득한교회");
		sayRecordVo.setChurchGp("나눔목장");
		sayRecordVo.setNtcrId("doochuli2");
		sayRecordVo.setNtcrNm("박두철");
		sayRecordVo.setRegistId("doochuli2");
		sayRecordVo.setUseAt("Y");
		
		
		try {
			commonSqlDao.insert("bibleSayRecord.insertBibleSayRecord", sayRecordVo);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/bible/bibleSayRecord/list.do";
	}

	
	
	
	@RequestMapping("/bible/bibleSayRecord/forUpdate.do")
	public String forUpdate(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model 
			, @ModelAttribute("sayRecordVo") SayRecordVo sayRecordVo
			) throws Exception{
		log.debug("BibleSayRecordController forUpdate call...");
		
		Map<String, Object> param = new HashMap<>();
		
		List<EgovMap> selectBibleBookAfList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookAfList",param);
		model.addAttribute("selectBibleBookAfList", selectBibleBookAfList);
		
		
		
		param.put("bookAf", "A");
		List<EgovMap> selectBibleBookOrdrList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookOrdrList",param);
		model.addAttribute("selectBibleBookOrdrList", selectBibleBookOrdrList);
		
		
		try {
			EgovMap bibleSayRecordOne = commonSqlDao.selectOne("bibleSayRecord.bibleSayRecordOne",sayRecordVo);
			model.addAttribute("result", bibleSayRecordOne);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "bible/bibleSayRecord/reg";
	}
	
	
	
	@RequestMapping("/bible/bibleSayRecord/update.do")
	public String update(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @ModelAttribute("sayRecordVo") SayRecordVo sayRecordVo
			) throws Exception{
		log.debug("BibleSayRecordController update call...");
		
		//sayRecordVo.setBbCn(EgovWebUtil.clearXSSMaximum(sayRecordVo.getBbCn()));
		
		sayRecordVo.setBbCn(EgovStringUtil.getHtmlStrCnvr(sayRecordVo.getBbCn()));
		//sayRecordVo.setBbCn(sayRecordVo.getBbCn().replaceAll("&gt;", ">"));
		
		Map<String, Object> param = new HashMap<>();
		//bibleSayRecord.insertBibleSayRecord
		
		//sayRecordVo.setChurch("꿈이가득한교회");
		//sayRecordVo.setChurchGp("나눔목장");
		//sayRecordVo.setNtcrId("doochuli2");
		//sayRecordVo.setNtcrNm("박두철");
		//sayRecordVo.setRegistId("doochuli2");
		sayRecordVo.setUpdtId("doochuli2");
		//sayRecordVo.setUseAt("Y");
		//ip추가필요
		
		try {
			commonSqlDao.update("bibleSayRecord.updateBibleSayRecord", sayRecordVo);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "redirect:/bible/bibleSayRecord/view.do?bbSeq="+sayRecordVo.getBbSeq();
	}
	
	
	@RequestMapping("/bible/bibleSayRecord/delete.do")
	public String delete(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @ModelAttribute("sayRecordVo") SayRecordVo sayRecordVo
			) throws Exception{
		log.debug("BibleSayRecordController delete call...");
		
		
		Map<String, Object> param = new HashMap<>();
		try {
			commonSqlDao.update("bibleSayRecord.deleteBibleSayRecord", sayRecordVo);	
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		//return "redirect:/bible/bibleSayRecord/view.do?bbSeq="+sayRecordVo.getBbSeq();
		return "redirect:/bible/bibleSayRecord/list.do";
	}
	
	
	
	
}
