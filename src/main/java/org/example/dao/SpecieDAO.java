package org.example.dao;

import org.example.Generic.GenericDAO;
import org.example.entity.Specie;


public class SpecieDAO extends GenericDAO<Specie> {


    public SpecieDAO() {
        super(Specie.class);
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


}
