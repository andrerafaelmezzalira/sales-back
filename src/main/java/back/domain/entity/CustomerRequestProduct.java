package back.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido_produto")
@IdClass(CustomerRequestProductId.class)
public class CustomerRequestProduct {

	@ManyToOne
	@Id
	@JoinColumn(name = "pedido_id")
	private CustomerRequest customerRequest;

	@ManyToOne
	@Id
	@JoinColumn(name = "produto_id")
	private Product product;

	@Column(name = "quantidade")
	private Integer amount;

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setCustomerRequest(CustomerRequest customerRequest) {
		this.customerRequest = customerRequest;
	}

	public CustomerRequest getCustomerRequest() {
		return customerRequest;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}
}
