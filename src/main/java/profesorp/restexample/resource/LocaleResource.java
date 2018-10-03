package profesorp.restexample.resource;

import java.util.Arrays;
import java.util.Collection;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.PathParam;
import javax.ws.rs.ext.Provider;
import profesorp.restexample.controller.LocaleController;
import profesorp.restexample.entity.Locales;



/**
 * The REST resource implementation class.
 */
@Path("locale")
public class LocaleResource {
    
    @Inject   
    private  LocaleController localeController;
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Locales> author() {        
        return localeController.findAll();
//        LocalesJpaController lc=new LocalesJpaController();
//           List<Locales> hm=Arrays.asList(new  Locales("ES","España"),new  Locales("FR","Francia"));
//           return hm;
    }
    
    @GET
    @Path("/{locale}")
    @Produces(MediaType.APPLICATION_JSON)
    public Locales author(@PathParam("locale") String locCodi) {       
         return new Locales("ES","España");
    }
    
   
}
