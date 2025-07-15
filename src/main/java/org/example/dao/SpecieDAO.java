package org.example.dao;

import org.example.db.Db;
import org.example.entity.Region;
import org.example.entity.Specie;

import javax.persistence.EntityManager;
import java.util.List;

public class SpecieDAO {

    private EntityManager entityManager;

    public SpecieDAO() {
        this.entityManager = Db.getEntityManager();
    }

    public Specie save (Specie specie){
        try{
            entityManager.getTransaction().begin();
            entityManager.persist(specie);
            entityManager.getTransaction().commit();
            return specie;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public Specie get (long id){
        return entityManager.find(Specie.class,id);
    }

    public List<Specie> get (){
        return entityManager.createQuery("select r from Specie r ", Specie.class).getResultList();
    }

    public Specie update (Specie specie , long id){
        try{
            Specie specieFound = get(id);
            if(specieFound != null){
                entityManager.getTransaction().begin();
                specieFound.setCommonName(specie.getCommonName());
                specieFound.setScientificName(specie.getScientificName());
                specieFound.setCategory(specie.getCategory());
                entityManager.getTransaction().commit();
                return specieFound;
            }
            return null;
        }catch (Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    public boolean delete (long id){
        try{
            Specie specieFound = get(id);
            if(specieFound != null){
                entityManager.getTransaction().begin();
                entityManager.remove(specieFound);
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
