package profesorp.restexample.resource;

import java.util.Arrays;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import profesorp.restexample.controller.LocaleController;
import profesorp.restexample.entity.Locales;



/**
 * The REST resource implementation class.
 */
@Path("locale")
@Stateless
public class LocaleResource {
    
    @Inject   
    private  LocaleController localeController;
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllLocales() {        
      
        return Response.ok(localeController.findAll()).build();
//        LocalesJpaController lc=new LocalesJpaController();
//           List<Locales> hm=Arrays.asList(new  Locales("ES","España"),new  Locales("FR","Francia"));
//           return hm;
    }
  
    @GET
    @Path("/{locale}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findLocale(@PathParam("locale") String locCodi) {   
        Locales l= localeController.findByLocale(locCodi);

        try {
            l.getLocNomb();
        } catch (javax.persistence.EntityNotFoundException k)
        {
            System.out.println("No encontrado Locale");            
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(l).build();
      
    }
    
   
}
