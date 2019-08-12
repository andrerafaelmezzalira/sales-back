package back.domain.entity;

import java.io.Serializable;

public class CustomerRequestProductId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Product product;

	private CustomerRequest customerRequest;

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
