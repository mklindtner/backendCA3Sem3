package rest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.DTOConverter.exampleDTO.UserDTO;
import entities.exampleEntities.User;
import repositories.UserRepository;
import rest.connections.EMF;
import seedData.GenerateDataSet;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("user")
public class UserResource
{
	private Gson           gson             = new GsonBuilder().setPrettyPrinting().create();
	private UserRepository userRepository   = new UserRepository( EMF.emf );

	//YES I KNOW it's bad, the purpose of this class should be clear. Use it for Converting from User to UserDTO
	//you can use userDTOConverter.convertToSet(etc.) whereever apply is used
	//if you find a static solution for this converter add me on discord at: fluffy snail#4373
	private UserDTO        userDTOConverter = new UserDTO();

	public UserResource() {

	}

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get()
    {
		return Response
				.ok( gson.toJson( userDTOConverter.convertToSet( userRepository.get() )))
				.build();
    }

    @Path("{id}")
    @GET
	@Produces(MediaType.APPLICATION_JSON)
	public String postUser(@PathParam("id") int id) {
		return gson.toJson( userDTOConverter.apply( userRepository.getEntity(id) ));
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createUser(String content) {
		User          user         = gson.fromJson(content, User.class);

		return Response
				.ok( gson.toJson( userDTOConverter.apply( userRepository.post(user) )))
				.build();
	}


	@Path("{id}")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateUser(@PathParam("id") int id, String content) {
		User user = gson.fromJson(content, User.class);
		user.setId(id);
		return Response
				.ok( gson.toJson( userDTOConverter.apply( userRepository.put( user ))))
				.build();
	}

	@Path("{id}")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@PathParam("id") int id) {
		User user = userRepository.delete(id);
		return Response
				.ok( gson.toJson( userDTOConverter.apply( user )))
				.build();
	}







}
