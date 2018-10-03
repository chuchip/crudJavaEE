package profesorp.restexample.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import profesorp.restexample.entity.Paises;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import profesorp.restexample.controller.exceptions.IllegalOrphanException;
import profesorp.restexample.controller.exceptions.NonexistentEntityException;
import profesorp.restexample.controller.exceptions.PreexistingEntityException;
import profesorp.restexample.controller.exceptions.RollbackFailureException;
import profesorp.restexample.entity.Locales;

/**
 *
 * @author chuchip
 */
public class LocalesJpaController implements Serializable {

    public LocalesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Locales locales) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (locales.getPaisesCollection() == null) {
            locales.setPaisesCollection(new ArrayList<Paises>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Collection<Paises> attachedPaisesCollection = new ArrayList<Paises>();
            for (Paises paisesCollectionPaisesToAttach : locales.getPaisesCollection()) {
                paisesCollectionPaisesToAttach = em.getReference(paisesCollectionPaisesToAttach.getClass(), paisesCollectionPaisesToAttach.getPaiInic());
                attachedPaisesCollection.add(paisesCollectionPaisesToAttach);
            }
            locales.setPaisesCollection(attachedPaisesCollection);
            em.persist(locales);
            for (Paises paisesCollectionPaises : locales.getPaisesCollection()) {
                Locales oldLocCodiOfPaisesCollectionPaises = paisesCollectionPaises.getLocCodi();
                paisesCollectionPaises.setLocCodi(locales);
                paisesCollectionPaises = em.merge(paisesCollectionPaises);
                if (oldLocCodiOfPaisesCollectionPaises != null) {
                    oldLocCodiOfPaisesCollectionPaises.getPaisesCollection().remove(paisesCollectionPaises);
                    oldLocCodiOfPaisesCollectionPaises = em.merge(oldLocCodiOfPaisesCollectionPaises);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findLocales(locales.getLocCodi()) != null) {
                throw new PreexistingEntityException("Locales " + locales + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Locales locales) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Locales persistentLocales = em.find(Locales.class, locales.getLocCodi());
            Collection<Paises> paisesCollectionOld = persistentLocales.getPaisesCollection();
            Collection<Paises> paisesCollectionNew = locales.getPaisesCollection();
            List<String> illegalOrphanMessages = null;
            for (Paises paisesCollectionOldPaises : paisesCollectionOld) {
                if (!paisesCollectionNew.contains(paisesCollectionOldPaises)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Paises " + paisesCollectionOldPaises + " since its locCodi field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Paises> attachedPaisesCollectionNew = new ArrayList<Paises>();
            for (Paises paisesCollectionNewPaisesToAttach : paisesCollectionNew) {
                paisesCollectionNewPaisesToAttach = em.getReference(paisesCollectionNewPaisesToAttach.getClass(), paisesCollectionNewPaisesToAttach.getPaiInic());
                attachedPaisesCollectionNew.add(paisesCollectionNewPaisesToAttach);
            }
            paisesCollectionNew = attachedPaisesCollectionNew;
            locales.setPaisesCollection(paisesCollectionNew);
            locales = em.merge(locales);
            for (Paises paisesCollectionNewPaises : paisesCollectionNew) {
                if (!paisesCollectionOld.contains(paisesCollectionNewPaises)) {
                    Locales oldLocCodiOfPaisesCollectionNewPaises = paisesCollectionNewPaises.getLocCodi();
                    paisesCollectionNewPaises.setLocCodi(locales);
                    paisesCollectionNewPaises = em.merge(paisesCollectionNewPaises);
                    if (oldLocCodiOfPaisesCollectionNewPaises != null && !oldLocCodiOfPaisesCollectionNewPaises.equals(locales)) {
                        oldLocCodiOfPaisesCollectionNewPaises.getPaisesCollection().remove(paisesCollectionNewPaises);
                        oldLocCodiOfPaisesCollectionNewPaises = em.merge(oldLocCodiOfPaisesCollectionNewPaises);
                    }
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = locales.getLocCodi();
                if (findLocales(id) == null) {
                    throw new NonexistentEntityException("The locales with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Locales locales;
            try {
                locales = em.getReference(Locales.class, id);
                locales.getLocCodi();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The locales with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Paises> paisesCollectionOrphanCheck = locales.getPaisesCollection();
            for (Paises paisesCollectionOrphanCheckPaises : paisesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Locales (" + locales + ") cannot be destroyed since the Paises " + paisesCollectionOrphanCheckPaises + " in its paisesCollection field has a non-nullable locCodi field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(locales);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Locales> findLocalesEntities() {
        return findLocalesEntities(true, -1, -1);
    }

    public List<Locales> findLocalesEntities(int maxResults, int firstResult) {
        return findLocalesEntities(false, maxResults, firstResult);
    }

    private List<Locales> findLocalesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Locales.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Locales findLocales(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Locales.class, id);
        } finally {
            em.close();
        }
    }

    public int getLocalesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Locales> rt = cq.from(Locales.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
