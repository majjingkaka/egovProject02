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
import egovframework.com.cmm.dao.CommonSqlDao;
import egovframework.com.cmm.service.EgovProperties;

@Controller
public class BibleMainController {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "commonSqlDao")
	CommonSqlDao commonSqlDao;
	
	@Resource(name="propertiesService")
    protected EgovPropertyService propertyService;
	
	@RequestMapping("/bible/main.do")
	public String main(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			) {
		log.debug("BibleMainController main call...");
		
		return "bible/main/bibleMain";
	}
	
	@RequestMapping("/bible/main_backup2.do")
	public String main_backup2(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			) {
		log.debug("BibleMainController main call...");
		
		//String bookAf = (String)request.getAttribute("bookAf");
		//String chapter = (String)request.getAttribute("chapter");
		

		
		// CSRF Token 검증하기
		//https://liltdevs.tistory.com/178
	    /*
		CsrfToken token = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
	    if (token != null) {
	      String csrfToken = token.getToken();
	      String csrfHeader = request.getHeader("X-CSRF-TOKEN");
	      if (!csrfToken.equals(csrfHeader)) {
	        throw new IllegalStateException("Invalid CSRF token.");
	      }
	    }
		*/
		
		
		Map<String, Object> param = new HashMap<>();

		try {
			List<EgovMap> selectBibleBookAfList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookAfList",param);
			model.addAttribute("selectBibleBookAfList", selectBibleBookAfList);
			
			param.put("bookAf", "A");
			List<EgovMap> selectBibleBookOrdrList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookOrdrList",param);
			model.addAttribute("selectBibleBookOrdrList", selectBibleBookOrdrList);
			

			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return "bible/main/bibleMain";
	}
	
	
	@RequestMapping("/bible/main_backup.do")
	public String main_backup(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @RequestParam(value = "bookAf", defaultValue = "A") String bookAf
			, @RequestParam(value = "bookSeq", defaultValue = "1") String bookSeq
			, @RequestParam(value = "btweenYn", defaultValue = "") String btweenYn
			, @RequestParam(value = "chapter", defaultValue = "") String chapter
			, @RequestParam(value = "verse", defaultValue = "") String verse
			, @RequestParam(value = "chapter2", defaultValue = "") String chapter2
			, @RequestParam(value = "verse2", defaultValue = "") String verse2
			, @RequestParam(value = "searchKeyword", defaultValue = "") String searchKeyword
			) {
		log.debug("BibleMainController main call...");
		
		//String bookAf = (String)request.getAttribute("bookAf");
		//String chapter = (String)request.getAttribute("chapter");
		
		/*
		log.debug(">> : "+bookAf
				+":"+bookSeq
				+":"+btweenYn
				+":"+chapter
				+":"+verse
				+":"+chapter2
				+":"+verse2
				+":"+searchKeyword
				);
		*/
		
		Map<String, Object> param = new HashMap<>();
		param.put("bookAf", bookAf);
		param.put("bookSeq", bookSeq);
		param.put("btweenYn", btweenYn);
		param.put("chapter", chapter);
		param.put("verse", verse);
		param.put("chapter2", chapter2);
		param.put("verse2", verse2);
		param.put("searchKeyword", searchKeyword);
		
		try {
			List<EgovMap> selectBibleBookAfList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookAfList",param);
			model.addAttribute("selectBibleBookAfList", selectBibleBookAfList);
			
			List<EgovMap> selectBibleBookOrdrList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookOrdrList",param);
			model.addAttribute("selectBibleBookOrdrList", selectBibleBookOrdrList);
			
			List<EgovMap> selectBibleList = commonSqlDao.selectList("BibleMainDAO.selectBibleList2",param);
			model.addAttribute("selectBibleList", selectBibleList);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		model.put("bookAf", bookAf);
		model.put("bookSeq", bookSeq);
		
		model.put("btweenYn", btweenYn);
		model.put("chapter", chapter);
		model.put("verse", verse);
		model.put("chapter2", chapter2);
		model.put("verse2", verse2);
		model.put("searchKeyword", searchKeyword);
		
		
		return "bible/main/bibleMain";
	}
	
	//https://rlaehdgs12.tistory.com/12
	//https://doing7.tistory.com/10
	
	@ResponseBody
	@RequestMapping(value = "/bible/bookOrdrListChange.do" )
	public ModelAndView bookOrdrListChange(
			//@RequestBody HashMap<String, Object> map
			HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @RequestParam(value = "bookAf", defaultValue = "A") String bookAf
			) {
		log.debug("BibleMainController bookOrdrListChange call...");
		
		Map<String, Object> param = new HashMap<>();
		param.put("bookAf", bookAf);
		
		List<EgovMap> selectBibleBookOrdrList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookOrdrList",param);
		model.put("selectBibleBookOrdrList", selectBibleBookOrdrList);
		
		//log.debug(map.toString());
		log.debug(bookAf);
		
		//model.put("result", "1111");
		ModelAndView mav = new ModelAndView("jsonView");
		mav.addObject("selectBibleBookOrdrList", selectBibleBookOrdrList);
		//mav.addObject("paginationInfo", paginationInfo);
		
		
		return mav;
	}
	
	
	
	
	//https://cornswrold.tistory.com/316
	@ResponseBody
	@RequestMapping(value = "/bible/bibleSearch.do" )
	public ModelAndView bibleSearch(HttpServletRequest request
			, HttpServletResponse response
			, ModelMap model
			, @RequestBody BibleVo bibleVo){
		
		log.debug("BibleMainController bibleSearch call...");
		
		log.debug(bibleVo.toString());
		ModelAndView mav = new ModelAndView("jsonView");
		
		
		try {
			//List<EgovMap> selectBibleBookAfList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookAfList",bibleVo);
			//model.addAttribute("selectBibleBookAfList", selectBibleBookAfList);
			
			//List<EgovMap> selectBibleBookOrdrList = commonSqlDao.selectList("BibleMainDAO.selectBibleBookOrdrList",bibleVo);
			//model.addAttribute("selectBibleBookOrdrList", selectBibleBookOrdrList);
			
			List<EgovMap> selectBibleList = commonSqlDao.selectList("BibleMainDAO.selectBibleList2",bibleVo);
			model.addAttribute("selectBibleList", selectBibleList);
			
			
			mav.addObject("selectBibleList", selectBibleList);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		return mav;
		
	}
	
	
	
	@RequestMapping(value = "/se2upload/editFileUploader2.do", method = RequestMethod.POST)
	public void editFileUploader2(MultipartFile file
			, HttpServletRequest request
			, HttpServletResponse response){
		
		log.debug("BibleMainController editFileUploader call...");
		
		try{
            if(file.isEmpty()) {
                System.out.println("이미지 미등록");
            } else {
            	//String fileUploadMaxSize = EgovProperties.getProperty("Globals.fileUpload.maxSize");
            	
                //String filePath = path;
            	String filePath = EgovProperties.getProperty("Globals.fileStorePath");
            	//String filePath = "D:/egov/eGovFrameDev-4.2.0-64bit/workspace_git/egovProject01/src/main/webapp/upload/se2823";
            	
                File saveDir = new File(filePath);
                if(!saveDir.exists()){
                    saveDir.mkdir();
                }
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String today = formatter.format(new java.util.Date());
                String rfileName = file.getOriginalFilename();
                String fileExt = file.getOriginalFilename().split("\\.")[1];
                //String pFileName = file.getOriginalFilename().split("\\.")[0] + UUID.randomUUID() + "-" + today + "."+ fileExt;
                
                String pFileName = today + "-" + UUID.randomUUID() + "."+ fileExt;
                File saveFile = new File(saveDir, pFileName);
                
                try {
                    file.transferTo(saveFile);
                }catch(Exception e) {
                    e.printStackTrace();
                }
                String sFileInfo = "";
                sFileInfo += "&bNewLine=true";
                // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
                sFileInfo += "&sFileName=" + rfileName;
                sFileInfo += "&sFileURL=" + "/imagePath/" +pFileName;
                //sFileInfo += "&sFileURL=" + "/upload/se2823/" +pFileName;
                PrintWriter print = response.getWriter();
                print.print(sFileInfo);
                print.flush();
                print.close();

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
		
		
		
		
		//return "";
	
	}
	
	
	//https://roqkffhwk.tistory.com/202
	@RequestMapping("/se2upload/editFileUploader.do")
	 public void editFileUploader(HttpServletRequest request, HttpServletResponse response){
		try {
			 //파일정보
			 String sFileInfo = "";
			 //파일명을 받는다 - 일반 원본파일명
			 String filename = request.getHeader("file-name");
			 //파일 확장자
			 String filename_ext = filename.substring(filename.lastIndexOf(".")+1);
			 //확장자를소문자로 변경
			 filename_ext = filename_ext.toLowerCase();
			 	
			 //이미지 검증 배열변수
			 String[] allow_file = {"jpg","png","bmp","gif"};

			 //돌리면서 확장자가 이미지인지 
			 int cnt = 0;
			 for(int i=0; i<allow_file.length; i++) {
			 	if(filename_ext.equals(allow_file[i])){
			 		cnt++;
			 	}
			 }

			 //이미지가 아님
			 if(cnt == 0) {
				 PrintWriter print = response.getWriter();
				 print.print("NOTALLOW_"+filename);
				 print.flush();
				 print.close();
			 } else {
			 //이미지이므로 신규 파일로 디렉토리 설정 및 업로드	
			 //파일 기본경로
			 //String dftFilePath = request.getSession().getServletContext().getRealPath("/");
			 //파일 기본경로 _ 상세경로
			 //String filePath = dftFilePath + "resources" + File.separator + "editor" + File.separator +"multiupload" + File.separator;
			 String filePath = EgovProperties.getProperty("Globals.fileStorePath");
			 
			 File file = new File(filePath);
			 if(!file.exists()) {
			 	file.mkdirs();
			 }
			 String realFileNm = "";
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
			 String today= formatter.format(new java.util.Date());
			 realFileNm = today+"-"+UUID.randomUUID().toString() + filename.substring(filename.lastIndexOf("."));
			 String rlFileNm = filePath + realFileNm;
			 
			 
			 ///////////////// 서버에 파일쓰기 ///////////////// 
			 InputStream is = request.getInputStream();
			 OutputStream os=new FileOutputStream(rlFileNm);
			 int numRead;
			 int a = Integer.parseInt(request.getHeader("file-size"));
			 byte b[] = new byte[a];
			 while((numRead = is.read(b,0,b.length)) != -1){
			 	os.write(b,0,numRead);
			 }
			 if(is != null) {
			 	is.close();
			 }
			 os.flush();
			 os.close();
			 ///////////////// 서버에 파일쓰기 /////////////////
			 
			 
			 
			 // 정보 출력
			 sFileInfo += "&bNewLine=true";
			 // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
			 sFileInfo += "&sFileName="+ filename;;
			 //sFileInfo += "&sFileURL="+"/resources/editor/multiupload/"+realFileNm;
			 sFileInfo += "&sFileURL=" + "/imagePath/" +realFileNm;
			 PrintWriter print = response.getWriter();
			 print.print(sFileInfo);
			 print.flush();
			 print.close();
			 }	
		} catch (Exception e) {
			e.printStackTrace();
		}
}
	
	
	
	
	@RequestMapping("/file_uploader")
	 public String file_uploader(HttpServletRequest request, HttpServletResponse response, Editor editor){
		 String return1=request.getParameter("callback");
		 String return2="?callback_func=" + request.getParameter("callback_func");
		 String return3="";
		 String name = "";
		 try {
			if(editor.getFiledata() != null && editor.getFiledata().getOriginalFilename() != null && !editor.getFiledata().getOriginalFilename().equals("")) {
	             // 기존 상단 코드를 막고 하단코드를 이용
	            name = editor.getFiledata().getOriginalFilename().substring(editor.getFiledata().getOriginalFilename().lastIndexOf(File.separator)+1);
				String filename_ext = name.substring(name.lastIndexOf(".")+1);
				filename_ext = filename_ext.toLowerCase();
			   	String[] allow_file = {"jpg","png","bmp","gif"};
			   	int cnt = 0;
			   	for(int i=0; i<allow_file.length; i++) {
			   		if(filename_ext.equals(allow_file[i])){
			   			cnt++;
			   		}
			   	}
			   	if(cnt == 0) {
			   		return3 = "&errstr="+name;
			   	} else {
			   		//파일 기본경로
		    		String dftFilePath = request.getSession().getServletContext().getRealPath("/");
		    		//파일 기본경로 _ 상세경로
		    		String filePath = dftFilePath + "resources"+ File.separator + "editor" + File.separator +"upload" + File.separator;
		    		File file = new File(filePath);
		    		if(!file.exists()) {
		    			file.mkdirs();
		    		}
		    		String realFileNm = "";
		    		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
					String today= formatter.format(new java.util.Date());
					realFileNm = today+UUID.randomUUID().toString() + name.substring(name.lastIndexOf("."));
					String rlFileNm = filePath + realFileNm;
					///////////////// 서버에 파일쓰기 /////////////////
					editor.getFiledata().transferTo(new File(rlFileNm));
					///////////////// 서버에 파일쓰기 /////////////////
		    		return3 += "&bNewLine=true";
		    		return3 += "&sFileName="+ name;
		    		return3 += "&sFileURL=/resources/editor/upload/"+realFileNm;
			   	}
			}else {
				  return3 += "&errstr=error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		 return "redirect:"+return1+return2+return3;
}
	
	
	
	
	
	
	
	
	
	
}
