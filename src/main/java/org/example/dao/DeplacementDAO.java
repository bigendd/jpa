package org.example.dao;

import org.example.db.Db;
import org.example.entity.Deplacement;

import javax.persistence.EntityManager;
import java.util.List;


public class DeplacementDAO {

    private EntityManager entityManager;

    public DeplacementDAO(){
        this.entityManager = Db.getEntityManager();
    }

    public Deplacement save(Deplacement deplacement){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(deplacement);
            entityManager.getTransaction().commit();
            return deplacement;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Deplacement get(long id){
        return entityManager.find(Deplacement.class, id);
    }

    public List<Deplacement> get(){
        return entityManager.createQuery("SELECT d FROM Deplacement d", Deplacement.class).getResultList();

    }

    public Deplacement update(Deplacement deplacement, long id){
        try {
            Deplacement deplacementFound =  get(id);
            if( deplacementFound != null){
                entityManager.getTransaction().begin();
                deplacementFound.setDistanceKm(deplacement.getDistanceKm());
                deplacementFound.setMode(deplacement.getMode());
                entityManager.getTransaction().commit();
            }
            return deplacement;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public boolean delete(long id){
        try {
            Deplacement deplacementFound =  get(id);
            if( deplacementFound != null){
                entityManager.getTransaction().begin();
                entityManager.remove(deplacementFound);
                entityManager.getTransaction().commit();
            }
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
        return false;
    }
}
