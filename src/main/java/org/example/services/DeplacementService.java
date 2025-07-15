package org.example.services;

import org.example.dao.DeplacementDAO;
import org.example.dao.RegionDAO;
import org.example.entity.Deplacement;
import org.example.entity.Region;

import java.util.List;

public class DeplacementService {

    private DeplacementDAO deplacementDAO;

    public DeplacementService() {
        this.deplacementDAO = new DeplacementDAO();
    }

    public Deplacement save (Deplacement deplacement){
        return deplacementDAO.save(deplacement);
    }



    public Deplacement get (long id){
        return deplacementDAO.get(id);
    }

    public List<Deplacement> getAll (){
        return deplacementDAO.get();
    }

    public Deplacement update (Deplacement deplacement , long id){
        return deplacementDAO.update(deplacement,id);
    }

    public boolean delete (long id){
        return deplacementDAO.delete(id);
    }



}
