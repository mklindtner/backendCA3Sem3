package repositories.generic;

import java.util.Set;

public interface CRUDOperations<E, PK>
{

	Set<E> get();
	E getEntity(PK primaryKey);
	E put(E entity);
	E delete(PK primaryKey);
	E post(E entity);

}
