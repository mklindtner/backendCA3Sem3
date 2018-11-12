package entities.exampleEntities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "discussionBoard")
public class DiscussionBoard
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String subject;

	@ManyToMany(mappedBy = "discussionBoards")
	private Set<User> users;

	public DiscussionBoard() {}

	public String getSubject()
	{
		return this.subject;
	}

	public void setSubject(String subject)
	{
		this.subject = subject;
	}
}
