package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pan_card")
public class PanCard {
	
	@Id
	private int panId;
	
	private String panCard;
	
	Employee employee;

	public int getPanId() {
		return panId;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanId(int panId) {
		this.panId = panId;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	
	

}
