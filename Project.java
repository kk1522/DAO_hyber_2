package entity;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name="proj_tbl")
public class Project {

		@Id
		@Column(name="pro_id")
		@GeneratedValue
		private int projectId;
		
		@Column(name = "pro_name")
		private String pojectName;
		
		@Column(name ="pro_dl")
		private LocalDate projectDeadLine;
		
		@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
		@JoinTable(
				name ="emp_proj_link",
				joinColumns = {@JoinColumn(name = "pro_id") },
				inverseJoinColumns = {@JoinColumn(name = "emp_id")}
				)
		Set<Employee> employee = new HashSet<Employee>();

		public int getProjectId() {
			return projectId;
		}

		public void setProjectId(int projectId) {
			this.projectId = projectId;
		}

		public String getPojectName() {
			return pojectName;
		}

		public void setPojectName(String pojectName) {
			this.pojectName = pojectName;
		}

		public LocalDate getProjectDeadLine() {
			return projectDeadLine;
		}

		public void setProjectDeadLine(LocalDate projectDeadLine) {
			this.projectDeadLine = projectDeadLine;
		}

		@Override
		public String toString() {
			return "Project [projectId=" + projectId + ", pojectName=" + pojectName + ", projectDeadLine="
					+ projectDeadLine + "]";
		}
		
		
}
