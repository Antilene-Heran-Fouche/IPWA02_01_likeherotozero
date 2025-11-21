package lhtz;

import java.io.Serializable;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PassUtil implements Serializable{
	
	// Create instance
	private Argon2 argon2 = Argon2Factory.create();
	
	public String hashedPassword(String pass) {
		// Read password from user
		char[] password = pass.toCharArray();

		try {
		    // Hash password
		    String hash = argon2.hash(10, 65536, 1, password);
		    return hash;
		} finally {
		    // Wipe data
		    argon2.wipeArray(password);
		}
	}
	
	public boolean checkPasswd(String hash, String passwd) {
		
		char[] password = passwd.toCharArray();
		
		if(argon2.verify(hash, password)) {
			System.out.println("Prüfung erfolgreich");
			return true;
		}
		else {
			System.out.println("Prüfung fehlgeschlagen!");
				return false;
				}
		
	}
	

}