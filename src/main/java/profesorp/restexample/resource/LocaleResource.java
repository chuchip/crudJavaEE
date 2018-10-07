package profesorp.restexample.resource;

import java.net.URI;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import profesorp.restexample.controller.LocaleController;
import profesorp.restexample.entity.Locales;

@Path("locale")
@Stateless
public class LocaleResource {
    
    @Inject   
    private  LocaleController localeController;
        
    private  Logger logger=  Logger.getLogger(LocaleResource.class.getName());
    
    @GET    
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllLocales() {        
        logger.log(Level.INFO, "Buscando todas las locales");
        return Response.ok(localeController.findAll()).build();
    }
  
    @GET
    @Path("/{locale}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findLocale(@PathParam("locale") String locCodi) {   
        Locales l= localeController.findById(locCodi);

        try {
            l.getNombre();
        } catch (javax.persistence.EntityNotFoundException k)
        {            
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(l).build();
      
    }
    /**
     * Añadir Locale     
     * @param locale
     * @return 
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Locales locale) {

        if ( localeController.exists(locale.getCodigo())) {
            return Response.status(Response.Status.CONFLICT).build();
        }
        localeController.create(locale);
        URI location = UriBuilder.fromResource(LocaleResource.class)
                .path("/{locale}")
                .resolveTemplate("locale", locale.getCodigo())
                .build();
        return Response.created(location).build();
    }
    @PUT
    @Path("/{locale}")
    public Response update(@PathParam("locale") String locale, Locales locales) {
        if (!Objects.equals(locale, locales.getCodigo())) {
            throw new BadRequestException("Propiedad locCodi de Objeto Locale debe coincidir con el parametro mandado.");
        }
        localeController.update(locales);
        return Response.ok().build();
    }
    
    @DELETE
    @Path("/{locale}")
    public Response delete(@PathParam("locale") String locale) {
        logger.log(Level.INFO, "Borrando Locale: "+locale);
        if ( ! localeController.exists(locale)) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        localeController.delete(locale);
        return Response.ok().build();
    }


}
