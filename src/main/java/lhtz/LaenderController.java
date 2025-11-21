package lhtz;

import java.io.Serializable;
import java.util.List;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class LaenderController implements Serializable {

	private LaenderDAO ladao;
	private List<Laender>  laenderList;
	private int ausgewaehlt;
	private Laender la;
	

	@PostConstruct
	public void init() {
		
		ladao = new LaenderDAO();
		laenderList = ladao.getLaender();

		if(laenderList.isEmpty()) {
		
		throw new ValidatorException(new FacesMessage("Keine Daten gefunden"));
		
		}
		
		countryAusgabe();
	}
	
	
	public void countryAusgabe() {
		
		for(Laender temp : this.laenderList) {
			if(temp.getIdcountrys() == this.ausgewaehlt) {
				this.la = temp;
				return;
				
			}
			
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

	
	
}
