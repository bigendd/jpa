package org.example.dao;

import org.example.Generic.GenericDAO;
import org.example.entity.Deplacement;

public class DeplacementDAO extends GenericDAO<Deplacement> {

    public DeplacementDAO() {
        super(Deplacement.class);
    }

    public Deplacement update(Deplacement updated, long id) {
        try {
            Deplacement existing = get(id);
            if (existing != null) {
                entityManager.getTransaction().begin();
                existing.setDistanceKm(updated.getDistanceKm());
                existing.setMode(updated.getMode());
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
