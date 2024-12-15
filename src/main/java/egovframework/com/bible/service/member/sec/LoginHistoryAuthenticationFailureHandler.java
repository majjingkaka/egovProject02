package egovframework.com.bible.service.member.sec;

import java.io.IOException;
import java.io.Serializable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;



public class LoginHistoryAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler implements Serializable {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	private static final long serialVersionUID = 6022675258353128287L;

	public static final String LOGIN_TRY_INFO_KEY = "LOGIN_TRY_INFO";

	@Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException exception) throws IOException, ServletException {

        //saveFailureHistory(request, null, "N");

		super.onAuthenticationFailure(request, response, exception);
	}



}
