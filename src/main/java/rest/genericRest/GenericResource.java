package rest.genericRest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.DTOConverter.BaseDTOMapper;
import repositories.generic.BaseCRUDOperations;
import repositories.generic.CRUDOperations;
import rest.connections.EMF;
import seedData.GenerateDataSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.lang.reflect.Field;


//GenericResource<E, PK, EDTO> --> how do i find the field type of PK and make
//Instead of Integer i should have used generic type PK
public class GenericResource<E, EDTO>
{
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private CRUDOperations<E, Integer>  crudOperations;
	private BaseDTOMapper<E, EDTO> baseDTOMapper;
	private Class<E>               entityClass;

	//https://stackoverflow.com/questions/18255117/how-do-i-get-the-class-attribute-from-a-generic-type-parameter
	public GenericResource(Class<E> entityClass, BaseDTOMapper<E, EDTO> dtoMapper) throws NoSuchFieldException
	{
		this.entityClass = entityClass;
		crudOperations = new BaseCRUDOperations<E, Integer>(entityClass, EMF.emf);
		baseDTOMapper = dtoMapper;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get() {
		return Response
				.ok( gson.toJson( baseDTOMapper.convertToSet(crudOperations.get()) ) )
				.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(String content) {
		E entity = gson.fromJson(content, entityClass);
		return Response
				.ok( gson.toJson( baseDTOMapper.apply( crudOperations.post( entity ) )))
				.build();
	}


	@Path("{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getByPK(@PathParam("id") int id) {
		return Response
				.ok( gson.toJson( baseDTOMapper.apply( crudOperations.getEntity( id ) )))
				.build();
	}

	//right now you will need to overwrite PUT, DELETE and GET(ID) if your entity does not support an integer as PK
	//if you find a way to ask for a generic Primary Key instead of this shit, write to me at discord: fluffy snail#4373
	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") int id ) {
		E entity = crudOperations.delete( id );
		return Response
				.ok( gson.toJson( baseDTOMapper.apply( entity ) ))
				.build();
	}


	@Path("{id}")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response put(@PathParam("id") int id, String content) throws NoSuchFieldException, IllegalAccessException
	{
		E     entity = gson.fromJson(content, entityClass);
		Field f      = entity.getClass().getDeclaredField("id");
		f.setAccessible(true);
		f.setInt(entity, id);
		E     result = crudOperations.put(entity);
		return Response
				.ok( gson.toJson( baseDTOMapper.apply( result )))
				.build();
	}


	/* rewrite generateSeed() if i need in the future
	@Path("seed")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response generateSeed() {
		GenerateDataSet.seed();
		return Response
				.ok( gson.toJson( crudOperations.get() ))
				.build();
	} */
}
