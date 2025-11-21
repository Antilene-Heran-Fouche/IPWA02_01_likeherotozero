package lhtz;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class EmissionsDAO {

	private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("likeherotozero");
	
	private EntityManager em = null;
	
	
	public void addEmissions(Emissions saveNew) {
		em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		t.begin();
			em.persist(saveNew);
		t.commit();
		
		if (em != null && em.isOpen()) {
            em.close();
        }
			
	}
	
	public void editEmissions(Emissions emis) {
        em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        	em.merge(emis);
        t.commit();
        
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
	
	public void removeEmissions(Emissions emis) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        t.begin();
        	em.remove(em.merge(emis));
        t.commit();
        
 
    		
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
	
	
}