package egovframework.com.bible.service.member.sec;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;

public class BibleUserDetails extends User {
  private static final long serialVersionUID = 1L;
  
  private Object usersVO;
  
  public BibleUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities, Object usersVO) throws IllegalArgumentException {
    super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    setUsersVO(usersVO);
  }
  
  public BibleUserDetails(String username, String password, boolean enabled, Object usersVO) throws IllegalArgumentException {
    this(username, password, enabled, true, true, true, AuthorityUtils.NO_AUTHORITIES, usersVO);
  }
  
  public Object getUsersVO() {
    return this.usersVO;
  }
  
  public void setUsersVO(Object usersVO) {
    this.usersVO = usersVO;
  }
}
