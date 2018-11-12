package entities.DTOConverter.exampleDTO;

import entities.DTOConverter.BaseDTOMapper;
import entities.exampleEntities.BoardPost;

public class BoardPostDTO implements BaseDTOMapper<BoardPost, BoardPostDTO>
{
	private int id;
	private String content;

	public BoardPostDTO(BoardPost bp)
	{
		this.content = bp.getContent();
		this.id = bp.getId();
	}

	public BoardPostDTO()
	{
	}

	@Override public BoardPostDTO apply(BoardPost boardPost)
	{
		return new BoardPostDTO(boardPost);
	}
}
