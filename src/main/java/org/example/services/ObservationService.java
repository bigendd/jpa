package org.example.services;

import org.example.dao.DeplacementDAO;
import org.example.dao.ObservationDAO;
import org.example.entity.Deplacement;
import org.example.entity.Observation;

import java.util.List;

public class ObservationService {

    private ObservationDAO observationDAO;

    public ObservationService() {
        this.observationDAO = new ObservationDAO();
    }

    public Observation save (Observation observation){
        return observationDAO.save(observation);
    }



    public Observation get (long id){
        return observationDAO.get(id);
    }

    public List<Observation> get (){
        return observationDAO.get();
    }

    public Observation update (Observation deplacement , long id){
        return observationDAO.update(deplacement,id);
    }

    public boolean delete (long id){
        return observationDAO.delete(id);
    }
}
