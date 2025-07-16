package org.example.dao;

import org.example.Generic.GenericDAO;
import org.example.db.Db;
import org.example.entity.Region;


import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.List;

public class RegionDAO extends GenericDAO<Region> {

    public RegionDAO() {
        super(Region.class);
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


}
