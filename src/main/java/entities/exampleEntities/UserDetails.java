package entities.exampleEntities;

import javax.persistence.*;

@Entity
@Table(name = "user_details")
public class UserDetails
{
	@Id
	private int id;

	@Column
	private String background, hobbies, dislikes;

	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	private User user;

}
