package egovframework.com.bible.service.member.sec;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.access.AccessDeniedHandler;

import egovframework.com.bible.domain.MemberVO;

public class BibleAccessDeniedHandler implements AccessDeniedHandler {

	private String defaultErrorPage;
	private String siteId;

	@Override
	public void handle(HttpServletRequest request,	HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {

		// Ajax를 통해 들어온것인지 파악한다
		String ajaxHeader = request.getHeader("X-Ajax-call");
		String result = "";

		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setCharacterEncoding("UTF-8");

		if (ajaxHeader == null || "".equals(ajaxHeader)) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			Object principal = auth.getPrincipal();
			
			
			
			
			
			
			
			
			
			
			
			
			request.setAttribute("errormsg", accessDeniedException);
			request.getRequestDispatcher(defaultErrorPage).forward(request, response);
		}
		else {
			if ("true".equals(ajaxHeader)) {
				result = "{\"result\" : \"fail\", \"msg\" : \"accessDeniedException\"}";
			}
			else {
				result = "{\"result\" : \"fail\", \"msg\" : \"Access Denied\"}";
			}
			response.getWriter().print(result);
			response.getWriter().flush();
		}
	}

	public void setDefaultErrorPage(String defaultErrorPage) {
        if ((defaultErrorPage != null) && !defaultErrorPage.startsWith("/")) {
            throw new IllegalArgumentException("errorPage must begin with '/'");
        }

        this.defaultErrorPage = defaultErrorPage;
    }

	public void setSiteId(String siteId) {
		this.siteId = siteId;
	}

}