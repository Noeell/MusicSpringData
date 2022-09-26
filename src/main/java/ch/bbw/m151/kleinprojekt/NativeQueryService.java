package ch.bbw.m151.kleinprojekt;

import javax.persistence.EntityManager;
import java.util.List;

public class NativeQueryService {
    EntityManager em;

    public NativeQueryService(EntityManager em) {
        this.em = em;
    }

    public List findAllSongsByTitle(String title) {
        return em.createNativeQuery(
                "select * from SONGS s where s.title = '" + title + "'").getResultList();
    }
}
