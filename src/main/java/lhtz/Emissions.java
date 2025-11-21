package lhtz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "co2_data")
public class Emissions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int year;
	private long population;
	private double gdp;
	private double co2;
	private double co2_including_luc;
	private double co2_per_capita;
	
	@ManyToOne
	@JoinColumn(name= "fk_laender")
	private Laender land;

	public Emissions() {
	}
	
	public Emissions(int year, long population, double gdp, double co2, double co2_including_luc, double co2_per_capita, Laender land) {
		this.year = year;
		this.population = population;
		this.gdp = gdp;
		this.co2 = co2;
		this.co2_including_luc = co2_including_luc;
		this.co2_per_capita = co2_per_capita;
		this.land = land;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public long getPopulation() {
		return population;
	}

	public void setPopulation(long population) {
		this.population = population;
	}

	public double getGdp() {
		return gdp;
	}

	public void setGdp(double gdp) {
		this.gdp = gdp;
	}

	public double getCo2() {
		return co2;
	}

	public void setCo2(double co2) {
		this.co2 = co2;
	}

	public double getCo2_including_luc() {
		return co2_including_luc;
	}

	public void setCo2_including_luc(double co2_including_luc) {
		this.co2_including_luc = co2_including_luc;
	}

	public double getCo2_per_capita() {
		return co2_per_capita;
	}

	public void setCo2_per_capita(double co2_per_capita) {
		this.co2_per_capita = co2_per_capita;
	}

	public Laender getLand() {
		return land;
	}

	public void setLand(Laender land) {
		this.land = land;
	}


	
	
}
