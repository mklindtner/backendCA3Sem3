package repositories;

import entities.exampleEntities.BoardPost;
import repositories.generic.BaseCRUDOperations;

import javax.persistence.EntityManagerFactory;

public class BoardPostRepository extends BaseCRUDOperations<BoardPost, Integer>
{
	public BoardPostRepository(EntityManagerFactory emf) {
		super(BoardPost.class, emf);
	}
}
