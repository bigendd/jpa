package org.example.db;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Db {

    private static EntityManager entityManager;


    private void DatabaseManager (){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_jpa");
        entityManager = emf.createEntityManager();


    }

    public static synchronized EntityManager getEntityManager() {
        if(entityManager == null){
            new Db();
        }
        return entityManager;
    }
}
