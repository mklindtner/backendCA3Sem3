package rest.CORS;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import java.io.IOException;

public class CORSFilter implements ContainerRequestFilter
{
	@Override public void filter(ContainerRequestContext res) throws IOException
	{
		res.getHeaders().add("Access-Control-Allow-Origin", "*" );
		res.getHeaders().add("Access-Control-Allow-Credentials", "true" );

		//Each annotation(@POST, @GET, etc.) automatically adds the below requirements are redundant (teachcer hello?)
		//curl -X OPTIONS http://localhost:8081/api/resource -i  on linux will show above statement
		//Note: curl is basically postman before it was cool
		/*
		res.getHeaders().add("Access-Control-Allow-Credentials", "true" );
		res.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT" );
		res.getHeaders().add("Access-Control-Allow-Headers", "Origin, Accept, Content-Type"); */
	}
}
