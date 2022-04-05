package entity;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "emp_tbl")
public class Employee {
	
	@Id
	private int employeeId;
	
	private String employeeName;
	
	private String Designation;
	
	@OneToOne
	PanCard pancard;
	
	@OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
	Set<Address> address = new HashSet<Address>();
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name ="emp_proj_link",
			joinColumns = {@JoinColumn(name = "emp_id") },
			inverseJoinColumns = {@JoinColumn(name = "pro_id")}
			)
	Set<Project> project = new HashSet<Project>();
	

	public Set<Address> getAddress() {
		return address;
	}

	public Set<Project> getProject() {
		return project;
	}

	public void setAddress(Set<Address> address) {
		this.address = address;
	}

	public void setProject(Set<Project> project) {
		this.project = project;
	}

	public PanCard getPancard() {
		return pancard;
	}

	public void setPancard(PanCard pancard) {
		this.pancard = pancard;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getDesignation() {
		return Designation;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setDesignation(String designation) {
		Designation = designation;
	}
	
	

	
}
