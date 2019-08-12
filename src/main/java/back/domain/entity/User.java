package back.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class User {

	@Id
	private Integer id;

	@Column(name = "nome")
	private String name;

	private String email;

	@Column(name = "senha")
	private String password;

	@ManyToOne
	@JoinColumn(name = "tipo_id")
	private TypeUser typeUser;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public void setTypeUser(TypeUser typeUser) {
		this.typeUser = typeUser;
	}

	public TypeUser getTypeUser() {
		return typeUser;
	}
}
