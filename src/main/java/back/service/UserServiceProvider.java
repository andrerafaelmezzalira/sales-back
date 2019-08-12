package back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.domain.entity.TypeUser;
import back.domain.entity.User;
import back.domain.repository.UserRepository;

@Service
public class UserServiceProvider implements UserService {

	@Autowired
	private UserRepository repository;

	@Autowired
	private TypeUserService typeUserService;

	@Override
	public User findByEmailAndPassword(String email, String password) {
		TypeUser typeUser = typeUserService.findByDescription("Vendedor");
		if (typeUser == null) {
			return null;
		}
		return repository.findByEmailAndPasswordAndTypeUser(email, password, typeUser);
	}

	@Override
	public User findByEmail(String email) {
		return repository.findByEmail(email);
	}
}