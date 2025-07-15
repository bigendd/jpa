package org.example.dao;

import org.example.db.Db;
import org.example.entity.Deplacement;
import org.example.entity.Observation;


import javax.persistence.EntityManager;
import java.util.List;

public class ObservationDAO {

    private static EntityManager entityManager;

    public ObservationDAO(){
        this.entityManager = Db.getEntityManager();
    }

    public static Observation save(Observation observation){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(observation);
            entityManager.getTransaction().commit();
            return observation;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Observation get(long id){
        return entityManager.find(Observation.class, id);
    }

    public List<Observation> get(){
        return entityManager.createQuery("SELECT o FROM Observation d", Observation.class).getResultList();

    }

    public Observation update(Observation observation, long id){
        try {
            Observation observationFound =  get(id);
            if( observationFound != null){
                entityManager.getTransaction().begin();
                observationFound.setComment(observation.getComment());
                observationFound.setLocation(observation.getLocation());
                observationFound.setLatitude(observation.getLatitude());
                observationFound.setLongitude(observation.getLongitude());
                observationFound.setObserverName(observation.getObserverName());
                observationFound.setSpecie(observation.getSpecie());
                observationFound.setObservationDate(observation.getObservationDate());

                entityManager.getTransaction().commit();
            }
            return observation;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public boolean delete(long id){
        try {
            Observation observationFound =  get(id);
            if( observationFound != null){
                entityManager.getTransaction().begin();
                entityManager.remove(observationFound);
                entityManager.getTransaction().commit();
            }
            return false;


        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return false;

        }

    }
}
