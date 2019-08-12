package back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.domain.entity.TypeUser;
import back.domain.entity.User;
import back.domain.repository.UserRepository;

@Service
public class UserServiceProvider implements UserService {

	private static final TypeUser TYPE_USER_SALESMAN = new TypeUser(1);

	@Autowired
	private UserRepository repository;

	@Override
	public User findByEmailAndPassword(String email, String password) {
		return repository.findByEmailAndPasswordAndTypeUser(email, password, TYPE_USER_SALESMAN);
	}

	@Override
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
}