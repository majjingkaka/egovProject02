package egovframework.com.bible.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.ModelMap;
import org.springframework.util.StopWatch;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

public class BibleMenuAopAspect {
	Logger log = LoggerFactory.getLogger(this.getClass());
	
	//https://ittrue.tistory.com/233
	//https://pamyferret.tistory.com/51
	
	public Object linkSeting(ProceedingJoinPoint joinPoint) throws Throwable {
		log.debug("BibleMenuAopAspect linkSeting call...");
		ModelAndView model = new ModelAndView();
		
		/*
		String requestUri = request.getRequestURI();
		//String  = requestUri.substring(siteId.length() + 1);
		String[] mcode = requestUri.split("/");
		
		
		model.addAttribute("mcode0", mcode[0]);
		model.addAttribute("mcode1", mcode[1]);
		model.addAttribute("mcode2", mcode[2]);
		//model.addAttribute("path", path);
		model.addAttribute("requestUri", requestUri);
		//model.addAttribute("currentUri", currentUri);
		*/
		
		
		
		
		
		StopWatch stopWatch = new StopWatch();
		
		//long start = System.currentTimeMillis();
		
		
		try {
			stopWatch.start();

			Object retValue = joinPoint.proceed();
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			String requestUri = request.getRequestURI();
			log.debug("BibleMenuAopAspect linkSeting call..."+requestUri);
			//String[] mcode = requestUri.split("/");
			//model.addObject("mcode0", mcode[0]);
			//model.addObject("mcode1", mcode[1]);
			//model.addObject("mcode2", mcode[2]);
			
			/*
			HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
			String requestUri = request.getRequestURI();
			String[] mcode = requestUri.split("/");
			model.addObject("mcode0", mcode[0]);
			model.addObject("mcode1", mcode[1]);
			model.addObject("mcode2", mcode[2]);
			model.addObject("requestUri", requestUri);
			*/
			
			
			
			
			return retValue;
		} catch (Throwable e) {
			throw e;
		} finally {
			stopWatch.stop();
			
			
			//작성
			
			//long end = System.currentTimeMillis();
			
			
			
			
			
			
			
			
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
}
