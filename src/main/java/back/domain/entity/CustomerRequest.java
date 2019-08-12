package back.domain.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class CustomerRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "dt_cadastro")
	private LocalDate registerDate;

	@Column(name = "dt_emissao")
	private LocalDate emissionDate;

	@Column(name = "dt_faturamento")
	private LocalDate billingDate;

	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private User salesMan;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Customer customer;

	@Column(name = "valor_total")
	private BigDecimal amount;

	@OneToMany(mappedBy = "customerRequest", fetch = FetchType.LAZY)
	private List<CustomerRequestProduct> itens;

	public void setItens(List<CustomerRequestProduct> itens) {
		this.itens = itens;
	}
	
	public List<CustomerRequestProduct> getItens() {
		return itens;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setBillingDate(LocalDate billingDate) {
		this.billingDate = billingDate;
	}

	public LocalDate getBillingDate() {
		return billingDate;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setEmissionDate(LocalDate emissionDate) {
		this.emissionDate = emissionDate;
	}

	public LocalDate getEmissionDate() {
		return emissionDate;
	}

	public void setRegisterDate(LocalDate registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public void setSalesMan(User salesMan) {
		this.salesMan = salesMan;
	}

	public User getSalesMan() {
		return salesMan;
	}
}
