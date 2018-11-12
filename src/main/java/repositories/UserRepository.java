package repositories;

import entities.exampleEntities.User;
import repositories.generic.BaseCRUDOperations;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserRepository extends BaseCRUDOperations<User, Integer>
{
	public UserRepository(EntityManagerFactory emf)
	{
		super(User.class, emf);
	}


	//untested
	public User getByEmail(String email)
	{
		EntityManager em = emf.createEntityManager();
		return em.createQuery("SELECT u FROM User u WHERE u.email=:email", User.class)
				 .setParameter("email", email)
				 .getSingleResult();
	}
}
