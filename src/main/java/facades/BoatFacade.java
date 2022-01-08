package facades;

import dtos.BoatDTO;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class BoatFacade {

    private static EntityManagerFactory emf;
    private static BoatFacade instance;


    private BoatFacade() {
    }

    public static BoatFacade getBoatFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new BoatFacade();
        }
        return instance;
    }

    public List<BoatDTO> returnAllBoats(){
        EntityManager em = emf.createEntityManager();
        List<BoatDTO> list;
        TypedQuery<BoatDTO> query = em.createQuery("select b from Boat b", BoatDTO.class);
        list = query.getResultList();
        return list;
    }

//    public List<CityInfoDTO> returnAllCities(){
//        EntityManager em = emf.createEntityManager();
//        List<CityInfoDTO> list;
//        TypedQuery<CityInfoDTO> query = em.createQuery("select c.id, c.city, c.zipCode from CityInfo c", CityInfoDTO.class);
//        list = query.getResultList();
//        return list;
//    }

}
