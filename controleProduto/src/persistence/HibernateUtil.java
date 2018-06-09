package persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	private static EntityManagerFactory emf;

	public static EntityManagerFactory getEmf() {
		if (emf == null) {
			emf = Persistence.createEntityManagerFactory("controleProduto");

		}
		return emf;
	}

	public static void close() {
		if (emf != null) {
			emf.close();
		}
	}

}
