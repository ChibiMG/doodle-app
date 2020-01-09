package jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	
	private EntityManager manager;

	public JpaTest(EntityManager manager) {
		this.manager = manager;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-test");
		EntityManager manager = factory.createEntityManager();
		JpaTest test = new JpaTest(manager);

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		try {
			test.createSondage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		tx.commit();

		test.listSondages();
			
   	    manager.close();
		System.out.println(".. done");
	}

	private void createSondage() {
		int numOfSondages = manager.createQuery("Select s From Sondage s", Sondage.class).getResultList().size();
		if (numOfSondages == 0) {
			Participant saly = new Participant("Knab", "Saly", "sk@ad.fr");
			Participant maud = new Participant("Garcon", "Maud", "mg@ad.fr");
			Reunion reunion = new Reunion("miage", "reu entre maud et saly");
			Sondage sondage = new Sondage(reunion);
			Date date = new Date("09/01",true);
			Date date1 = new Date("10/01",false);
			
			reunion.setSondage(sondage);
			sondage.addParticipants(saly);
			saly.addSondagesParticipes(sondage);
			sondage.addParticipants(maud);
			maud.addSondagesParticipes(sondage);
			sondage.addDates(date);
			sondage.addDates(date1);
			
			manager.persist(sondage);
		}
	}

	private void listSondages() {
		List<Sondage> resultList = manager.createQuery("Select a From Sondage a", Sondage.class).getResultList();
		System.out.println("num of Sondage:" + resultList.size());
		for (Sondage next : resultList) {
			System.out.println("next Sondage: " + next);
		}
	}


}
