package lhtz;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class LaenderDAO {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeherotozero");
	
	private EntityManager em = null;
	
	
	public List<Laender> getLaender() throws jakarta.persistence.NoResultException {
		
		try {
			em = emf.createEntityManager();
			TypedQuery<Laender> query = em.createQuery("SELECT e FROM Laender e JOIN FETCH e.emi", Laender.class);
			
			return query.getResultList();
			
			} finally {
		        if (em != null && em.isOpen()) {
		            em.close();
		        }
		}
		
	}
	
	
}
