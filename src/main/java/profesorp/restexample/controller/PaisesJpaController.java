package profesorp.restexample.controller;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import profesorp.restexample.entity.Locales;
import profesorp.restexample.entity.Clientes;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;
import profesorp.restexample.controller.exceptions.IllegalOrphanException;
import profesorp.restexample.controller.exceptions.NonexistentEntityException;
import profesorp.restexample.controller.exceptions.PreexistingEntityException;
import profesorp.restexample.controller.exceptions.RollbackFailureException;
import profesorp.restexample.entity.Paises;

/**
 *
 * @author chuchip
 */

public class PaisesJpaController implements Serializable {

    public PaisesJpaController(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Paises paises) throws PreexistingEntityException, RollbackFailureException, Exception {
        if (paises.getClientesCollection() == null) {
            paises.setClientesCollection(new ArrayList<Clientes>());
        }
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Locales locCodi = paises.getLocCodi();
            if (locCodi != null) {
                locCodi = em.getReference(locCodi.getClass(), locCodi.getLocCodi());
                paises.setLocCodi(locCodi);
            }
            Collection<Clientes> attachedClientesCollection = new ArrayList<Clientes>();
            for (Clientes clientesCollectionClientesToAttach : paises.getClientesCollection()) {
                clientesCollectionClientesToAttach = em.getReference(clientesCollectionClientesToAttach.getClass(), clientesCollectionClientesToAttach.getClientesPK());
                attachedClientesCollection.add(clientesCollectionClientesToAttach);
            }
            paises.setClientesCollection(attachedClientesCollection);
            em.persist(paises);
            if (locCodi != null) {
                locCodi.getPaisesCollection().add(paises);
                locCodi = em.merge(locCodi);
            }
            for (Clientes clientesCollectionClientes : paises.getClientesCollection()) {
                Paises oldPaiInicOfClientesCollectionClientes = clientesCollectionClientes.getPaiInic();
                clientesCollectionClientes.setPaiInic(paises);
                clientesCollectionClientes = em.merge(clientesCollectionClientes);
                if (oldPaiInicOfClientesCollectionClientes != null) {
                    oldPaiInicOfClientesCollectionClientes.getClientesCollection().remove(clientesCollectionClientes);
                    oldPaiInicOfClientesCollectionClientes = em.merge(oldPaiInicOfClientesCollectionClientes);
                }
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            if (findPaises(paises.getPaiInic()) != null) {
                throw new PreexistingEntityException("Paises " + paises + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paises paises) throws IllegalOrphanException, NonexistentEntityException, RollbackFailureException, Exception {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Paises persistentPaises = em.find(Paises.class, paises.getPaiInic());
            Locales locCodiOld = persistentPaises.getLocCodi();
            Locales locCodiNew = paises.getLocCodi();
            Collection<Clientes> clientesCollectionOld = persistentPaises.getClientesCollection();
            Collection<Clientes> clientesCollectionNew = paises.getClientesCollection();
            List<String> illegalOrphanMessages = null;
            for (Clientes clientesCollectionOldClientes : clientesCollectionOld) {
                if (!clientesCollectionNew.contains(clientesCollectionOldClientes)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Clientes " + clientesCollectionOldClientes + " since its paiInic field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (locCodiNew != null) {
                locCodiNew = em.getReference(locCodiNew.getClass(), locCodiNew.getLocCodi());
                paises.setLocCodi(locCodiNew);
            }
            Collection<Clientes> attachedClientesCollectionNew = new ArrayList<Clientes>();
            for (Clientes clientesCollectionNewClientesToAttach : clientesCollectionNew) {
                clientesCollectionNewClientesToAttach = em.getReference(clientesCollectionNewClientesToAttach.getClass(), clientesCollectionNewClientesToAttach.getClientesPK());
                attachedClientesCollectionNew.add(clientesCollectionNewClientesToAttach);
            }
            clientesCollectionNew = attachedClientesCollectionNew;
            paises.setClientesCollection(clientesCollectionNew);
            paises = em.merge(paises);
            if (locCodiOld != null && !locCodiOld.equals(locCodiNew)) {
                locCodiOld.getPaisesCollection().remove(paises);
                locCodiOld = em.merge(locCodiOld);
            }
            if (locCodiNew != null && !locCodiNew.equals(locCodiOld)) {
                locCodiNew.getPaisesCollection().add(paises);
                locCodiNew = em.merge(locCodiNew);
            }
            for (Clientes clientesCollectionNewClientes : clientesCollectionNew) {
                if (!clientesCollectionOld.contains(clientesCollectionNewClientes)) {
                    Paises oldPaiInicOfClientesCollectionNewClientes = clientesCollectionNewClientes.getPaiInic();
                    clientesCollectionNewClientes.setPaiInic(paises);
                    clientesCollectionNewClientes = em.merge(clientesCollectionNewClientes);
                    if (oldPaiInicOfClientesCollectionNewClientes != null && !oldPaiInicOfClientesCollectionNewClientes.equals(paises)) {
                        oldPaiInicOfClientesCollectionNewClientes.getClientesCollection().remove(clientesCollectionNewClientes);
                        oldPaiInicOfClientesCollectionNewClientes = em.merge(oldPaiInicOfClientesCollectionNewClientes);
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
                String id = paises.getPaiInic();
                if (findPaises(id) == null) {
                    throw new NonexistentEntityException("The paises with id " + id + " no longer exists.");
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
            Paises paises;
            try {
                paises = em.getReference(Paises.class, id);
                paises.getPaiInic();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paises with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Clientes> clientesCollectionOrphanCheck = paises.getClientesCollection();
            for (Clientes clientesCollectionOrphanCheckClientes : clientesCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Paises (" + paises + ") cannot be destroyed since the Clientes " + clientesCollectionOrphanCheckClientes + " in its clientesCollection field has a non-nullable paiInic field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Locales locCodi = paises.getLocCodi();
            if (locCodi != null) {
                locCodi.getPaisesCollection().remove(paises);
                locCodi = em.merge(locCodi);
            }
            em.remove(paises);
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

    public List<Paises> findPaisesEntities() {
        return findPaisesEntities(true, -1, -1);
    }

    public List<Paises> findPaisesEntities(int maxResults, int firstResult) {
        return findPaisesEntities(false, maxResults, firstResult);
    }

    private List<Paises> findPaisesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Paises.class));
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

    public Paises findPaises(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paises.class, id);
        } finally {
            em.close();
        }
    }

    public int getPaisesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Paises> rt = cq.from(Paises.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
