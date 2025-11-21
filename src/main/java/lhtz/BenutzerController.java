package lhtz;

import java.io.Serializable;


import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;


@Named
@RequestScoped
public class BenutzerController implements Serializable {
		

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	

	private final BenutzerDAO bdao = new BenutzerDAO();
	
	@Inject
	SessionController sessionController;
	
	@Inject
	PassUtil passwd;
	
	
	
	public String login() {	
		Benutzer b = bdao.getSingleBenutzer(this.username); // Benutzer holen
		if(b != null && passwd.checkPasswd( b.getPassword(), this.password)) {
			sessionController.setGruppe(b.getGruppe());
			sessionController.setLoggedin(true);
			sessionController.setName(b.getName());
			if(b.getGruppe().getGroupName().equals("Admin") || b.getGruppe().getGroupName().equals("Editor")) {
				sessionController.setEditor(true);
			} else {
				sessionController.setEditor(false);
			}
			
			return "index?faces-redirect=true";
					}
		else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Login Falsch!", "")); // wird ausgelöst, wenn PassUtil null zurück gibt
			return null;
		}
	}
	
	
	public String register() {
	
		boolean check = bdao.isUsernameAvailable(this.username);
		
		if(check == false ) {
			 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Benutzername bereits vergeben!", ""));
		}
		else if(bdao.register(this.username, passwd.hashedPassword(this.password)) == null) { //Wenn die z.Bsp. Gruppe nicht gesetzt werden kann
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Da lief etwas schief!", ""));
		} else {
			
			return "index?faces-redirect=true";
				
		}

		return null;
		
		
	}
	
	


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
