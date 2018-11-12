package entities.DTOConverter.exampleDTO;

import entities.DTOConverter.BaseDTOMapper;
import entities.exampleEntities.User;

import java.util.Set;
import java.util.stream.Collectors;

public class UserDTO implements BaseDTOMapper<User, UserDTO>
{
	private int    id;
	private String name, email;
	//unsure
	private Set<BoardPostDTO> boardPostDTO;

	public UserDTO()
	{
	}

	private UserDTO(User user, boolean hasBoardPost)
	{
		this.id = user.getId();
		this.name = user.getName();
		this.email = user.getEmail();
		if(hasBoardPost)
			this.boardPostDTO = user.getBoardPosts()
									.stream()
									.map( (boardPost) -> new BoardPostDTO(boardPost) )
									.collect(Collectors.toSet());
	}

	private UserDTO(String name, String email)
	{
		this.name = name;
		this.email = email;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	//for different DTO Convertion create a static factory method
	@Override public UserDTO apply(User user)
	{
		//return new UserDTO(user, true);
		return new UserDTO(user, false);
	}

	//static factory method, use these if you wish to deviate the DTO from a standard
	public static UserDTO createUserDTOSimple(User user) {
		return new UserDTO(user, false);
	}

}
