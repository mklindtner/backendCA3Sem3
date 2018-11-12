package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entities.DTOConverter.exampleDTO.BoardPostDTO;
import entities.exampleEntities.BoardPost;
import repositories.BoardPostRepository;
import repositories.generic.BaseCRUDOperations;
import repositories.generic.CRUDOperations;
import rest.connections.EMF;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.awt.*;
import java.util.Set;


@Path("boardPost")
public class BoardPostResource
{
	private Gson                gson                = new GsonBuilder().setPrettyPrinting().create();
	private BoardPostRepository boardPostRepository = new BoardPostRepository(EMF.emf);
	private BoardPostDTO        boardPostDTO        = new BoardPostDTO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get()
	{
		Set<BoardPostDTO> boardPosts = boardPostDTO.convertToSet(boardPostRepository.get());
		return Response
				.ok(gson.toJson(boardPosts))
				.build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response post(String content)
	{
		BoardPost bp = boardPostRepository.post(gson.fromJson(content, BoardPost.class));

		return Response
				.ok( boardPostDTO.apply(bp) )
				.build();
	}
}
