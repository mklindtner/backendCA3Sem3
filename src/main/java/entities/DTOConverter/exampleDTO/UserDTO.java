package entities.DTOConverter.exampleDTO;

import entities.DTOConverter.BaseDTOMapper;
import entities.exampleEntities.User;

public class UserDTO implements BaseDTOMapper<User, UserDTO>
{
	private String email;
	private int id;
	//private Role role
	public UserDTO(User user) {
		this.email = user.getEmail();
		this.id = user.getId();
	}

	public UserDTO()
	{
	}

	@Override public UserDTO apply(User user)
	{
		return new UserDTO(user);
	}
}
