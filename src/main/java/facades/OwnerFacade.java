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
}
