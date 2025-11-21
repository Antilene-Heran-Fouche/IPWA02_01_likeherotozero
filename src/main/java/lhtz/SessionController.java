package lhtz;

import java.io.IOException;
import java.io.Serializable;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class SessionController implements Serializable {

	private String name;
	private Gruppe gruppe;
	private boolean loggedin;
	private boolean editor;

	public void checkLogin() {
		try {
		if (this.loggedin) {
			
				FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
			}
		} catch (IOException e) {
				e.printStackTrace();
			}
		}

	public String logout() {

		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "index?faces-redirect=true";
	}

	
	// Brauch ich nur, wenn ich eine Seite begrenzen will mit <f:event type="preRenderView" listener="#{sessionController.checkEditer}" /> 
	public void checkEditer() {
		try {
			if (this.editor) {
			} else {
				FacesContext.getCurrentInstance().getExternalContext().redirect("forbidden.xhtml");
			}
		} catch (java.lang.NullPointerException | IOException e) {
			e.printStackTrace();
		}

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gruppe getGruppe() {
		return gruppe;
	}

	public void setGruppe(Gruppe gruppe) {
		this.gruppe = gruppe;
	}

	public boolean isLoggedin() {
		return loggedin;
	}

	public void setLoggedin(boolean loggedin) {
		this.loggedin = loggedin;
	}

	public boolean isEditor() {
		return editor;
	}

	public void setEditor(boolean editor) {
		this.editor = editor;
	}

}
