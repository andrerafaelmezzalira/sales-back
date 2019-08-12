package back.service;

import back.domain.entity.User;

public interface UserService {

	User findByEmailAndPassword(String email, String password);

	User findByEmail(String email);
}