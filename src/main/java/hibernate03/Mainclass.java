package hibernate03;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Mainclass {
public static void main(String[] args) {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Flipkart f1 = new Flipkart();
	f1.setId(1);
	f1.setName("poco x6 pro");
	f1.setCost(25999);
	
	Flipkart f2 = new Flipkart();
	f2.setId(2);
	f2.setName("nothing 3a");
	f2.setCost(30999);
	
	et.begin();
	em.persist(f1);
	em.persist(f2);
	et.commit();
	
	Flipkart f3 = em.find(Flipkart.class, 1);
	System.out.println(f3.getId()+" "+f3.getName()+" "+f3.getCost());
	
	et.begin();
	em.persist(f3);
	et.commit();
	
	Flipkart f4 = em.find(Flipkart.class, 2);
	f4.setName("nothing 4a");
	f4.setCost(45999);
	
	et.begin();
	et.commit();
	
	Flipkart f5 = em.find(Flipkart.class, 2);
	et.begin();
	em.remove(f5);
	et.commit();
	
	System.out.println("doneee");
	
	
	
	
	
	
}
}