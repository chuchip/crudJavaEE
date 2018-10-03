package profesorp.restexample.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Map;

import static java.util.Collections.singletonMap;
import javax.ws.rs.PathParam;


/**
 * The REST resource implementation class.
 */
@Path("clientes")
public class ClienteResource {
    
    @GET
    @Path("/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> author(@PathParam("cliente") int cliCodi) {
         Map<String, String> response = singletonMap("message", "Building Web Services with Java EE 8.");
         return response;
    }
     @GET
    @Path("/{empresa}/{cliente}")
    @Produces(MediaType.APPLICATION_JSON)
    public Map<String,String> author(@PathParam("empresa") int empCodi,@PathParam("cliente") int cliCodi) {
         Map<String, String> response = singletonMap("message", "Building Web Services with Java EE 8.");
         return response;
    }
}
