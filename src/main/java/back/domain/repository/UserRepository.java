package back.domain.repository;

import org.springframework.data.repository.Repository;

import back.domain.entity.TypeUser;
import back.domain.entity.User;

public interface UserRepository extends Repository<User, Integer> {

	User findByEmailAndPasswordAndTypeUser(String email, String password, TypeUser typeUser);

	User findByEmail(String email);
}
