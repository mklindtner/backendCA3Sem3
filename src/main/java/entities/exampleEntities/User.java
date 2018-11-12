package entities.exampleEntities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;


	@Column
	private String name, email, hashPassword;

	//inverse side
	//bidirectional relationship,
	//do not use unidirectional relationships in One-To-Many nn. for intermediary tables
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
	private Set<BoardPost> boardPosts;


	//here the owning side shares PK with the inverse side (user). This is default for 1-1
	//very rarely, if ever, should the owning side has it's own PK
	@OneToOne(mappedBy = "user")
	private UserDetails userDetails;

	//bidirectional many-many
	//if uni wanted: remove attribute "users" from DiscussionBoard
	@ManyToMany
	@JoinTable(name = "user_discussboard",
			   joinColumns = { @JoinColumn(name="user_id")},
			   inverseJoinColumns = { @JoinColumn(name="discuss_id") })
	private Set<DiscussionBoard> discussionBoards;

	public User() {}

	public User(int id, String name, String email, String hashPassword)
	{
		this(name, email, hashPassword);
		this.id = id;
	}

	public User(String name, String email, String hashPassword)
	{
		this.name = name;
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

	public String getHashPassword()
	{
		return this.hashPassword;
	}

	public void setHashPassword(String hashPassword)
	{
		this.hashPassword = hashPassword;
	}

	public Set<BoardPost> getBoardPosts()
	{
		return this.boardPosts;
	}

	public void setBoardPosts(Set<BoardPost> boardPosts)
	{
		this.boardPosts = boardPosts;
	}

	public void addPostToBoardPost(BoardPost bp) {
		boardPosts.add(bp);
	}

	public UserDetails getUserDetails()
	{
		return this.userDetails;
	}

	public void setUserDetails(UserDetails userDetails)
	{
		this.userDetails = userDetails;
	}

	public Set<DiscussionBoard> getDiscussionBoards()
	{
		return this.discussionBoards;
	}

	public void setDiscussionBoards(Set<DiscussionBoard> discussionBoards)
	{
		this.discussionBoards = discussionBoards;
	}

	@Override public String toString()
	{
		return "User{" +
			   "id=" + id +
			   ", name='" + name + '\'' +
			   ", email='" + email + '\'' +
			   ", hashPassword='" + hashPassword + '\'' +
			   '}';
	}
}
