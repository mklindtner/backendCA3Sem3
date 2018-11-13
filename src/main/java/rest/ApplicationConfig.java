package rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;


//Defines the base URI for all resource URIs.
@ApplicationPath("api")
//The java class declares root resource and provider classes
public class ApplicationConfig extends Application
{
	//The method returns a non-empty collection with classes, that must be included in the published JAX-RS application
	@Override
	public Set<Class<?>> getClasses()
	{
		Set<Class<?>> resources = new java.util.HashSet<>();
		addRestResourceClasses(resources);
		return resources;
	}

	private void addRestResourceClasses(Set<Class<?>> resources)
	{
	}
}