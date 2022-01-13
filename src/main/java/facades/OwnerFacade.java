package facades;

import dtos.OwnerDTO;
import dtos.OwnersDTO;
import entities.Owner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class OwnerFacade {

    private static EntityManagerFactory emf;
    private static OwnerFacade instance;


    private OwnerFacade() {
    }

    public static OwnerFacade getOwnerFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new OwnerFacade();
        }
        return instance;
    }

    public OwnerDTO getOwnerById(int id){
        EntityManager em = emf.createEntityManager();
        return new OwnerDTO(em.find(Owner.class, id));
    }

    public OwnersDTO getAllOwners(){
        EntityManager em = emf.createEntityManager();

        TypedQuery<Owner> query = em.createQuery("select o from Owner o", Owner.class);
        List<Owner> owners = query.getResultList();

        return new OwnersDTO(owners);
    }

    public OwnerDTO createNewOwner(Owner owner){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(owner);
        em.getTransaction().commit();

        return new OwnerDTO(owner);
    }

    public OwnerDTO editOwner (Owner owner){
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(owner);
        em.getTransaction().commit();
        return new OwnerDTO(owner);
    }

    public void deleteOwner(int id) {
        EntityManager em = emf.createEntityManager();
        Owner owner = em.find(Owner.class, id);
        em.getTransaction().begin();
        em.remove(owner);
        em.getTransaction().commit();
    }
}
