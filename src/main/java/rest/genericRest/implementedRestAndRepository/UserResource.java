package rest.genericRest.implementedRestAndRepository;

import entities.DTOConverter.BaseDTOMapper;
import entities.DTOConverter.exampleDTO.UserDTO;
import entities.exampleEntities.User;
import rest.genericRest.GenericResource;

import javax.ws.rs.Path;

@Path("user")
public class UserResource extends GenericResource<User, UserDTO>
{
	public UserResource() throws NoSuchFieldException
	{
		super(User.class, new UserDTO());
	}
}
