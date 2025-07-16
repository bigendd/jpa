package org.example.Generic;

import org.example.db.Db;

import javax.persistence.EntityManager;
import java.util.List;

public abstract class GenericDAO<T> {

    protected EntityManager entityManager;
    private final Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityManager = Db.getEntityManager();
        this.entityClass = entityClass;
    }

    public T save(T entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
    }

    public T get(long id) {
        return entityManager.find(entityClass, id);
    }

    public List<T> get() {
        String jpql = "SELECT e FROM " + entityClass.getSimpleName() + " e";
        return entityManager.createQuery(jpql, entityClass).getResultList();
    }

    public boolean delete(long id) {
        try {
            T entity = get(id);
            if (entity != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(entity);
                entityManager.getTransaction().commit();
                return true;
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
        return false;
    }
}
