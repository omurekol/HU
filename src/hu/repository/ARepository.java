/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.repository;

import hu.entity.A;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author omur.alcin
 */
public class ARepository {

   private EntityManager entityManager ;
    
    public ARepository() {
        entityManager = Persistence.createEntityManagerFactory("HU_PU").createEntityManager();
    }
    
    public void merge(A a){
        entityManager.getTransaction().begin();
        entityManager.merge(a);
        
        entityManager.getTransaction().commit();
    }
        public void save(A a){
        entityManager.getTransaction().begin();
        entityManager.persist(a);
        
        entityManager.getTransaction().commit();
    }
    public void close(){
        entityManager.close();
    }
    public A find(int Id){
        return entityManager.find(A.class, Id);
    }

}

