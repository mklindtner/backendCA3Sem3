package rest.connections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EMF
{
	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("REST_excersices");
}
