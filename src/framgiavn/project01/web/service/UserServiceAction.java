/**
 * Jun 24, 2016, UserService.java, vuvandat
 */
package framgiavn.project01.web.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import framgiavn.project01.web.*;
import framgiavn.project01.web.business.UserBusiness;
import framgiavn.project01.web.dao.impl.UserDAOImpl;
import framgiavn.project01.web.model.User;

/**
 * @author vuvandat
 *
 */
public class UserServiceAction implements UserDetailsService {

	private UserBusiness userBusiness;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = null;
		try {
			user = userBusiness.findUserByUserName(username);
			if (user == null) {
				throw new UsernameNotFoundException("user not found");
			}
		} catch (Exception e) {
			throw new EntityNotFoundException(e.getCause().getMessage());
		}
		String uname = user.getUsername();
		String password = user.getPassword();
		boolean enabled = Boolean.TRUE;
		boolean accountNonExpired = Boolean.TRUE;
		boolean credentialsNonExpired = Boolean.TRUE;
		boolean accountNonLocked = Boolean.TRUE;
		Collection<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(user.getRole()!= null && !user.getRole().isEmpty() ){
			authorities.add(new SimpleGrantedAuthority(user.getRole()));
		}
		return new org.springframework.security.core.userdetails.User(uname, password, enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, authorities);
	}

	public UserBusiness getUserBusiness() {
		return userBusiness;
	}

	public void setUserBusiness(UserBusiness userBusiness) {
		this.userBusiness = userBusiness;
	}

}