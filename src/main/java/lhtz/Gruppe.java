package lhtz;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "gruppen")
public class Gruppe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int groupID;
	
	private String groupName;
	
	@OneToMany(mappedBy = "gruppe")
	private List<Benutzer> nutzer;

	public int getGroupID() {
		return groupID;
	}

	public void setGroupID(int groupID) {
		this.groupID = groupID;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Benutzer> getNutzer() {
		return nutzer;
	}

	public void setNutzer(List<Benutzer> nutzer) {
		this.nutzer = nutzer;
	}
	
	
	
	
	
	
	

}
