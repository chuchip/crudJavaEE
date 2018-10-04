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
   
   public LocaleController()
   {
       
   }
   public Collection<Locales> findAll() {       
        System.out.println("** Buscando todos los locale: ");
        TypedQuery<Locales> findAll =  em.createNamedQuery(Locales.FIND_ALL, Locales.class);
        
        return Collections.unmodifiableCollection(findAll.getResultList());
   }
   public Locales findByLocale(String locale)
   {
       return em.getReference(Locales.class, Objects.requireNonNull(locale));      
   }
}
