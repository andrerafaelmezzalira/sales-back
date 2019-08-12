package back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import back.domain.entity.TypeUser;
import back.domain.repository.TypeUserRepository;

@Service
public class TypeUserServiceProvider implements TypeUserService {

	@Autowired
	private TypeUserRepository repository;

	@Override
	public TypeUser findByDescription(String description) {
		return repository.findByDescription(description);
	}
}