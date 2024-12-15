//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package egovframework.com.bible.service.member.sec;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.egovframe.rte.fdl.string.EgovObjectUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

public class BibleUserDetailsHelper {
    protected static Log log = LogFactory.getLog(BibleUserDetailsHelper.class);

    public BibleUserDetailsHelper() {
    }

    public static Object getAuthenticatedUser() throws BibleBizException {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (EgovObjectUtil.isNull(authentication)) {
            return null;
        } else {
            BibleUserDetails details = null;
            Object principal = authentication.getPrincipal();
            if (principal instanceof BibleUserDetails) {
                details = (BibleUserDetails)authentication.getPrincipal();
                return details.getUsersVO();
            } else {
                return null;
            }
        }
    }

    public static List<String> getAuthorities() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        List<String> authorities = new ArrayList();
        
        if(!EgovObjectUtil.isNull(authentication)) {
            Iterator<GrantedAuthority> it = (Iterator<GrantedAuthority>) authentication.getAuthorities().iterator();
            while(it.hasNext()) {
                authorities.add(((GrantedAuthority)it.next()).getAuthority());
            }
        }

        return authorities;
    }

    public static Boolean isAuthenticated() {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        if (EgovObjectUtil.isNull(authentication)) {
            return Boolean.FALSE;
        } else {
            String username = authentication.getName();
            if (username.equals("roleAnonymous")) {
                return Boolean.FALSE;
            } else {
                Object principal = authentication.getPrincipal();
                return !EgovObjectUtil.isNull(principal);
            }
        }
    }

    public static boolean isAuthenticated(String auth) {
        boolean result = true;

        try {
            if (getAuthorities().contains(auth)) {
                result = true;
            } else {
                result = false;
            }
        } catch (RuntimeException var3) {
            log.error(">>>error:: BibleUserDetailsHelper.isAuthenticated() RuntimeException Error ");
        } catch (Exception var4) {
            log.error(">>>error:: BibleUserDetailsHelper.isAuthenticated() Exception Error ");
            result = false;
        }

        return result;
    }
}
