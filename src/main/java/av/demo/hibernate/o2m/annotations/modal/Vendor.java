package av.demo.hibernate.o2m.annotations.modal;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {
	
	@Id
	@Column(name = "vid")
	private int vendorId;
	
	@Column(name = "vname", length=10)
	private String vendorName;
	
	@OneToMany(fetch=FetchType.LAZY, targetEntity=Customer.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "venid", referencedColumnName="vid")
	private Set<Customer> customers;

	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", vendorName=" + vendorName + "]";
	}
}
