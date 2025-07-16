package org.example.dao;

import org.example.Generic.GenericDAO;
import org.example.entity.Observation;

public class ObservationDAO extends GenericDAO<Observation> {

    public ObservationDAO() {
        super(Observation.class);
    }

    public Observation update(Observation updated, long id) {
        try {
            Observation existing = get(id);
            if (existing != null) {
                entityManager.getTransaction().begin();
                existing.setComment(updated.getComment());
                existing.setLocation(updated.getLocation());
                existing.setLatitude(updated.getLatitude());
                existing.setLongitude(updated.getLongitude());
                existing.setObserverName(updated.getObserverName());
                existing.setSpecie(updated.getSpecie());
                existing.setObservationDate(updated.getObservationDate());
                entityManager.getTransaction().commit();
                return existing;
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return null;
    }
}
