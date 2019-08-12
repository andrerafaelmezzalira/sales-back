package back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import back.domain.entity.User;

@Service
public class LoginService implements AuthenticationProvider {

	@Autowired
	private UserService service;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String email = authentication.getName();
		String password = authentication.getCredentials().toString();

		User user = service.findByEmailAndPassword(email, password);
		if (user != null) {
			return new UsernamePasswordAuthenticationToken(email, password);
		}
		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}