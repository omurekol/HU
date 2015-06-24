/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.repository;

import hu.entity.B;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author omur.alcin
 */
public class BRepository {

   private EntityManager entityManager ;
    
    public BRepository() {
        entityManager = Persistence.createEntityManagerFactory("HU_PU").createEntityManager();
    }
    
    public void merge(B b){
        entityManager.getTransaction().begin();
        entityManager.merge(b);
        
        entityManager.getTransaction().commit();
    }
    public void save(B b){
        entityManager.getTransaction().begin();
        entityManager.persist(b);
        
        entityManager.getTransaction().commit();
    }
    public B find(int Id){
        return entityManager.find(B.class, Id);
    }
    public void close(){
        entityManager.close();
    }
}
