package entities.exampleEntities;

import javax.persistence.*;

@Entity
@Table(name = "boardpost")
public class BoardPost
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String content;

	//owning side
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	public BoardPost() {}


	public BoardPost(String content, User user)
	{
		this.content = content;
		this.user = user;
	}

	public int getId()
	{
		return this.id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getContent()
	{
		return this.content;
	}

	public void setContent(String content)
	{
		this.content = content;
	}

	public User getUser()
	{
		return this.user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
}
