/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package profesorp.restexample.controller;

import java.util.Collection;
import java.util.Collections;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.ws.rs.ext.Provider;
import profesorp.restexample.entity.Locales;


/**
 *
 * @author chuchip
 */

@ApplicationScoped
//@Default
//@Transactional(Transactional.TxType.REQUIRED)
public class LocaleController {
   @Inject
   EntityManager em;
   
   public LocaleController()
   {
       
   }
   public Collection<Locales> findAll() {        
        TypedQuery<Locales> findAll =  em.createNamedQuery(Locales.FIND_ALL, Locales.class);
        
        return Collections.unmodifiableCollection(findAll.getResultList());
   }
}
