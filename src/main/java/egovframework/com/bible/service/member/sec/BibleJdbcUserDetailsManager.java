package egovframework.com.bible.service.member.sec;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.util.StringUtils;

import egovframework.com.bible.domain.MemberVO;

public class BibleJdbcUserDetailsManager extends JdbcUserDetailsManager {
	private String hierarchicalRolesQuery;

    private RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();

    private RowMapper<UserDetails> mapper;
    private AuthorityMapping authorityMapping = new AuthorityMapping();
    private String roleHierarchyStringRepresentation = null;
    private List<Map<String, Object>> roleHierarchyList = null;
    
    @Resource(name="passwordEncoder")
	private PasswordEncoder passwordEncoder;
    
    @Override
    protected void initDao() {
    	super.initDao();
    	roleHierarchyList = getJdbcTemplate().queryForList(hierarchicalRolesQuery);


    }

    public void setMapper(RowMapper<UserDetails> mapper){
    	this.mapper = mapper;
    }

	public void setHierarchicalRolesQuery(String hierarchicalRolesQuery) {
		this.hierarchicalRolesQuery = hierarchicalRolesQuery;
	}

	@Override
    protected List<UserDetails> loadUsersByUsername(String username) {
		
        return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[] {username}, mapper);
    }

	@Override
    protected List<GrantedAuthority> loadUserAuthorities(String username) {
		List<GrantedAuthority> authorities = getJdbcTemplate().query(getAuthoritiesByUsernameQuery(), new String[] {username}, authorityMapping);
		if (mapper instanceof MngUserMapping) {
			authorities.add(new SimpleGrantedAuthority("ROLE_ADMINKEY"));
		}
/*		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("============= " +grantedAuthority.toString() + " ===============");
		}*/

		return authorities;
    }

	@Override
    protected UserDetails createUserDetails(String username, UserDetails userFromUserQuery,
            List<GrantedAuthority> combinedAuthorities) {
        String returnUsername = userFromUserQuery.getUsername();
        BibleUserDetails userDetails = (BibleUserDetails)userFromUserQuery;
        MemberVO usersVO = (MemberVO)userDetails.getUsersVO();
        return new BibleUserDetails(returnUsername, userFromUserQuery.getPassword(), userFromUserQuery.isEnabled(),
                true, true, true, combinedAuthorities, usersVO);
    }

	@Override
	public void addCustomAuthorities(String username, List<GrantedAuthority> authorities) {
		this.initDao();
		if (roleHierarchyList!=null) {
	        Iterator<Map<String, Object>> itr = roleHierarchyList.iterator();
	        StringBuffer concatedRoles = new StringBuffer();
	        Map<String, Object> tempMap;
	        while (itr.hasNext()) {
	            tempMap = itr.next();
	            concatedRoles.append(tempMap.get("child"));
	            concatedRoles.append(" > ");
	            concatedRoles.append(tempMap.get("parent"));
	            concatedRoles.append("\n");
	        }
	        roleHierarchyStringRepresentation = concatedRoles.toString();
		}

		roleHierarchy.setHierarchy(roleHierarchyStringRepresentation);
		List<GrantedAuthority> reachableRoleList = (List<GrantedAuthority>)roleHierarchy.getReachableGrantedAuthorities(authorities);

		authorities.clear();
		authorities.addAll(reachableRoleList);
	}
}
