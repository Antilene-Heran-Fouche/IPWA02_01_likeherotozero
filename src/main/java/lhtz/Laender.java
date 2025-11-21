package lhtz;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "laender")
public class Laender {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcountrys;
	
	String countryname;
	
	@OneToMany(mappedBy = "land")
	private List<Emissions> emi;

	public String getCountryname() {
		return countryname;
	}

	public void setCountryname(String countryname) {
		this.countryname = countryname;
	}

	public int getIdcountrys() {
		return idcountrys;
	}

	public void setIdcountrys(int idcountrys) {
		this.idcountrys = idcountrys;
	}

	public List<Emissions> getEmi() {
		return emi;
	}

	public void setEmi(List<Emissions> emi) {
		this.emi = emi;
	}
	
	
	
	

}
