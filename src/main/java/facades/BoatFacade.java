package facades;

import dtos.BoatDTO;
import dtos.HabourDTO;
import dtos.OwnerDTO;
import entities.Boat;
import entities.Owner;

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

    public void g (){
        EntityManager em = emf.createEntityManager();
        OwnerDTO dto = new OwnerDTO(1,1);
        Owner owner;
        Boat boat;
        owner = em.find(Owner.class, dto.getOwnerid());
        boat = em.find(Boat.class, dto.getBoatid());

        List<Boat> boatlist = owner.getBoats();
        boatlist.add(boat);
        owner.setBoats(boatlist);

        em.persist(owner);


    }

//    public List<BoatDTO> returnAllBoats(){
//        EntityManager em = emf.createEntityManager();
//        List<BoatDTO> list;
//        TypedQuery<BoatDTO> query = em.createQuery("select b from Boat b", BoatDTO.class);
//        list = query.getResultList();
//        return list;
//    }

    public List<HabourDTO> returnAllHabours(){
        EntityManager em = emf.createEntityManager();
        List<HabourDTO> list;
        TypedQuery<HabourDTO> query = em.createQuery("select h.id, h.name, h.address, h.capacity from Habour h", HabourDTO.class);
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
