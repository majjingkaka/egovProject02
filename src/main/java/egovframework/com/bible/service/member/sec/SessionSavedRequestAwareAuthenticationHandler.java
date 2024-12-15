package egovframework.com.bible.service.member.sec;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.util.StringUtils;



public class SessionSavedRequestAwareAuthenticationHandler extends SavedRequestAwareAuthenticationSuccessHandler {



	public static final String TARGET_URL = "_targetUrl_";

	Logger log = LoggerFactory.getLogger(this.getClass());

	private RequestCache requestCache = new HttpSessionRequestCache();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws ServletException, IOException {

    	SavedRequest savedRequest = requestCache.getRequest(request, response);

		String protocol = "http";
		//String domain = globalsProperties.getPropertyVal().getString("Globals.ucms.domain");
		//String realMode = globalsProperties.isReal() ? "Y" : "N";

 		//if ("Y".equals(realMode)) {
 		//	protocol = "https://";
 		//}else {
 		//	protocol = "http://";
 		//}
 		
 		//domain = protocol + domain;

		try {
			HttpSession session = request.getSession();
			
			String targetUrl = (String)session.getAttribute(TARGET_URL);
			String targetUrl2 = savedRequest != null ?savedRequest.getRedirectUrl() : null;

			if (targetUrl2 != null) {
				targetUrl = targetUrl2;
			}

			if (StringUtils.hasText(targetUrl)) {
	    		session.removeAttribute(targetUrl);
	    		getRedirectStrategy().sendRedirect(request, response, targetUrl);
	    	}
	    	else {
	    		super.onAuthenticationSuccess(request, response, authentication);
	    	}
			
			
	    	
		}
		catch (IOException e) {
			log.error("IOException Occured");
		}
		catch (Exception e) {
			log.error("Exception Occured");
		}

    }


}
