package entities.exampleEntities;

import javax.persistence.*;

@Entity
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String email, password;

	//private Role role;

	public User()
	{
	}

	public User(String email, String password)
	{
		this.email = email;
		this.password = password;
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

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}
}
