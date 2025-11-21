package lhtz;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "benutzer")
public class Benutzer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idusers;
	
	
	private String name;
	private String password;
	
	@ManyToOne
	@JoinColumn(name= "fk_group_id")
	private Gruppe gruppe;
	
	
	public Benutzer(String name, String passwort) {
		super();
		this.name = name;
		this.password = passwort;
	}
	public Benutzer() {
	}
	
	
	public int getIdusers() {
		return idusers;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}
	public void setPassword(String passwort) {
		this.password = passwort;
	}
	
	public Gruppe getGruppe() {
		return gruppe;
	}
	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}
	
	

	

	
	
}
