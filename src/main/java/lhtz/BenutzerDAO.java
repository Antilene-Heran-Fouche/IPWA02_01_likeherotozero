package lhtz;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class BenutzerDAO {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeherotozero");

	private EntityManager em;

	public BenutzerDAO() {
	};

	public Benutzer getSingleBenutzer(String username) {
		em = emf.createEntityManager();
		try {
			TypedQuery<Benutzer> query = em.createQuery("SELECT b FROM Benutzer b WHERE b.name = :name",
					Benutzer.class);
			query.setParameter("name", username);

			return query.getSingleResult(); // NoResultException muss abgefangen werden
		} catch (NoResultException e) {
			return null;
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	public boolean isUsernameAvailable( String username) {
		em = emf.createEntityManager();

		try {
			TypedQuery<Benutzer> query = em.createQuery("SELECT b FROM Benutzer b WHERE b.name = :name",
					Benutzer.class);
			query.setParameter("name", username);
			List<Benutzer> result = query.getResultList(); // Kein Exception handling benötigt, wenn Result leer ist,
															// wird eine leere Liste zurückgegeben

			return result.isEmpty();
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	public String register(String username, String password) {

		em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();

		try {
			Benutzer temp = new Benutzer(username, password);
			TypedQuery<Gruppe> query = em.createQuery("SELECT g FROM Gruppe g WHERE g.groupName = :name", Gruppe.class);
			query.setParameter("name", "Editor"); // Basically get Gruppe Editor

			temp.setGruppe(query.getSingleResult()); // Temp Nutzer bekommt gruppe Benutzer, exception kann auftreten

			t.begin();
			em.persist(temp); // Schreiben in die DB
			t.commit();
			return "success";
		} catch (NoResultException e) {
			return null;
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}

	}

}
