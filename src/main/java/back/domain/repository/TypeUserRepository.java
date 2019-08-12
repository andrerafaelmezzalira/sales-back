package back.domain.repository;

import org.springframework.data.repository.Repository;

import back.domain.entity.TypeUser;

public interface TypeUserRepository extends Repository<TypeUser, Integer> {

	TypeUser findByDescription(String description);
}
