package facades;

import javax.persistence.EntityManagerFactory;

public class HabourFacade {

    private static EntityManagerFactory emf;
    private static HabourFacade instance;


    private HabourFacade() {
    }

    public static HabourFacade getHabourFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HabourFacade();
        }
        return instance;
    }
}
