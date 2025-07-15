package org.example.dao;

import org.example.db.Db;
import org.example.entity.Region;


import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class RegionDAO {

    private EntityManager entityManager;

    public RegionDAO() {
        this.entityManager = Db.getEntityManager();
    }

    public Region save (Region region){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(region);
            entityManager.getTransaction().commit();
            return region;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Region get (long id){
        return entityManager.find(Region.class,id);
    }

    public List<Region> get (){
        return entityManager.createQuery("select r from Region r ", Region.class).getResultList();
    }

    public Region update (Region region , long id){
        try{
            Region regionFound = get(id);
            if(regionFound != null){
                entityManager.getTransaction().begin();
                regionFound.setName(region.getName());
                regionFound.setSurface(region.getSurface());
                regionFound.setClimat(region.getClimat());
                entityManager.getTransaction().commit();
                return regionFound;
            }
            return null;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public boolean delete (long id){
        try{
            Region regionFound = get(id);
            if(regionFound != null){
                entityManager.getTransaction().begin();
                entityManager.remove(regionFound);
                entityManager.getTransaction().commit();
                return true;
            }
            return false;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return false;

        }
    }
}
