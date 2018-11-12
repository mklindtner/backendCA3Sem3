package rest.genericRest;

import entities.DTOConverter.BaseDTOMapper;
import entities.DTOConverter.exampleDTO.UserDTO;
import entities.exampleEntities.User;
import rest.genericRest.GenericResource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("test")
public class TestREST extends GenericResource<User, UserDTO>
{
	public TestREST() throws NoSuchFieldException
	{
		super(User.class, new UserDTO());
	}

}
