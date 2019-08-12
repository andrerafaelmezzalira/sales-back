package back.service;

import back.domain.entity.TypeUser;

public interface TypeUserService {

	TypeUser findByDescription(String description);
}