/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import profesorp.restexample.entity.Locales;


/**
 *
 * @author chuchip
 */
@ApplicationScoped
@Transactional(Transactional.TxType.REQUIRED)
public class LocaleController implements Serializable {
   @Inject
   EntityManager em;
   
   private  Logger logger=  Logger.getLogger(LocaleController.class.getName());
   
   public Collection<Locales> findAll() {       
        logger.log(Level.INFO,"** Buscando todos los locale: ");
        TypedQuery<Locales> findAll =  em.createNamedQuery(Locales.FIND_ALL, Locales.class);
        
        return Collections.unmodifiableCollection(findAll.getResultList());
   }
   public Locales findById(String locCodi)
   {
       return em.getReference(Locales.class, Objects.requireNonNull(locCodi));      
   }
   
    public void create(Locales locale) {
        Objects.requireNonNull(locale);        
        em.persist(locale);
    }
     
    public boolean exists(String locCodi) {       
        return em.find(Locales.class, locCodi) != null;
    }
    
     public void update(Locales locale) {
        Objects.requireNonNull(locale);
        em.merge(locale);
    }

    
    public void delete(String locCodi) {
        Objects.requireNonNull(locCodi);
        Locales reference = em.getReference(Locales.class, locCodi);
        em.remove(reference);
    }
}
