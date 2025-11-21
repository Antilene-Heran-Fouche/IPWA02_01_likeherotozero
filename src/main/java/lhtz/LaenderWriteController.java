package lhtz;

import java.io.Serializable;
import java.util.List;

import org.primefaces.event.RowEditEvent;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LaenderWriteController implements Serializable {

	private LaenderDAO ladao;
	private EmissionsDAO emdao;
	private List<Laender>  laenderList;
	private int ausgewaehlt;
	private Laender la;
	
	private Integer year;
	private Long population;
	private Double gdp;
	private Double co2;
	private Double co2_including_luc;
	private Double co2_per_capita;
	

	@PostConstruct
	public void init() {
		
		ladao = new LaenderDAO();
		emdao = new EmissionsDAO();
		laenderList = ladao.getLaender();
		countryAusgabe();
	}
	
	
	public void countryAusgabe() {
		
		for(Laender la : this.laenderList) {
			if(la.getIdcountrys() == this.ausgewaehlt) {
				this.la = la;
				return;
				
			}
			
		}

		
	}
	
	
	
public void editEmissions(RowEditEvent<Emissions> event) {
		
		Emissions editedEmissions = (Emissions) event.getObject();
		
		System.out.println(event.getObject().getClass() + "Das hier ohooo");
		
		FacesMessage msg = new FacesMessage("Emission bearbeitet");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	
		
		emdao.editEmissions(editedEmissions);
		
		// Sowohl die ApplcationScope Tabelle für Alle User als auch die für Editors Updaten
		init();
		
		
	}
	
public void removeEmissions(Emissions emi) {
	
	
	FacesMessage msg = new FacesMessage("Emission gelöscht");
	FacesContext.getCurrentInstance().addMessage(null, msg);
	
	emdao.removeEmissions(emi);
	init();
}

	
public void addEmissions() {
	
	if(this.ausgewaehlt != 0){
	
	Emissions temp = new Emissions(this.year.intValue(), this.population.longValue(), this.gdp.doubleValue(), this.co2.doubleValue(), this.co2_including_luc.doubleValue(), this.co2_per_capita.doubleValue(), this.la);
	
	emdao.addEmissions(temp);

	  this.year = null;
	  this.population = null;
	  this.gdp = null;
	  this.co2 = null;
	  this.co2_including_luc = null;
	  this.co2_per_capita = null;
	
	  init();

	} else {
		  FacesMessage msg = new FacesMessage("Nicht möglich, wähle ein Land aus!");
		  FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	  
	  
}




	
	
	public List<Laender> getLaenderList(){
		return laenderList;
	}

	public int getAusgewaehlt() {
		return ausgewaehlt;
	}

	public void setAusgewaehlt(int ausgewaehlt) {
		this.ausgewaehlt = ausgewaehlt;
	}

	public void setLaenderList(List<Laender> laenderList) {
		this.laenderList = laenderList;
	}


	public Laender getLa() {
		return la;
	}


	public void setLa(Laender la) {
		this.la = la;
	}


	public LaenderDAO getLadao() {
		return ladao;
	}


	public void setLadao(LaenderDAO ladao) {
		this.ladao = ladao;
	}


	public Integer getYear() {
		return year;
	}


	public void setYear(Integer year) {
		this.year = year;
	}


	public Long getPopulation() {
		return population;
	}


	public void setPopulation(Long population) {
		this.population = population;
	}


	public Double getGdp() {
		return gdp;
	}


	public void setGdp(Double gdp) {
		this.gdp = gdp;
	}


	public Double getCo2() {
		return co2;
	}


	public void setCo2(Double co2) {
		this.co2 = co2;
	}


	public Double getCo2_including_luc() {
		return co2_including_luc;
	}


	public void setCo2_including_luc(Double co2_including_luc) {
		this.co2_including_luc = co2_including_luc;
	}


	public Double getCo2_per_capita() {
		return co2_per_capita;
	}


	public void setCo2_per_capita(Double co2_per_capita) {
		this.co2_per_capita = co2_per_capita;
	}
	
	
	
	
	
}
