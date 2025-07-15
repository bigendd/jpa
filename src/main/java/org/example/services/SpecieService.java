package org.example.services;


import org.example.dao.RegionDAO;
import org.example.dao.SpecieDAO;
import org.example.entity.Region;
import org.example.entity.Specie;

import java.util.List;

public class SpecieService {

    private SpecieDAO specieDAO;

    public SpecieService() {
        this.specieDAO = new SpecieDAO();
    }

    public Specie save (Specie specie){
        return specieDAO.save(specie);
    }



    public Specie get (long id){
        return specieDAO.get(id);
    }

    public List<Specie> get (){
        return specieDAO.get();
    }

    public Specie update (Specie specie , long id){
        return specieDAO.update(specie,id);
    }

    public boolean delete (long id){
        return specieDAO.delete(id);
    }



}

