package back.domain.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Product {

	@Id
	private Integer id;

	@Column(name = "descricao")
	private String description;

	@Column(name = "valor")
	private BigDecimal value;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public BigDecimal getValue() {
		return value;
	}
}
