package entities.exampleEntities;

import javax.persistence.*;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String email, hashPassword;

	//private Role role;

	public User()
	{
	}

	public User(String email, String hashPassword)
	{
		this.email = email;
		this.hashPassword = hashPassword;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getHashPassword()
	{
		return this.hashPassword;
	}
}
