/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.controller;

import hu.entity.A;
import hu.entity.B;
import hu.repository.BRepository;

/**
 *
 * @author omur.alcin
 */
public class BRateController {
    A a = hu.Karar.a;
    B b = hu.Karar.b;
    ABRateEquilibrium aBRateEquilibrium = new ABRateEquilibrium();
    BRepository bRepository = new BRepository();

    public BRateController() {
        
    }
    public B getB(){
        return this.b;
    }
    
    public void bRateIncreaser(int value) throws Exception{
       
        
        
       if(b.getFear()<100 && b.getGoal() < 100){
           if(value==0){
               b.setFear(b.getFear()+1);
               b.setGoal(b.getGoal()+1); 
           }else{
               b.setFear(b.getFear()+value);
               b.setGoal(b.getGoal()+value);
           }
            bRepository.save(b);
            
            aBRateEquilibrium.aBEquilibrium(false);
       }else{
//           if(value == 0){
//               bRateDecreaser(0);
//           }else{
//               bRateIncreaser(value);
//           }
       }
      
        
    }
    
    public void bRateDecreaser(int value) throws Exception{
         
        if(value == 0){
        b.setFear(b.getFear()-1);
        b.setGoal(b.getGoal()-1);
        }else{
            b.setFear(a.getFear()-1);
            b.setGoal(a.getGoal()-1);
        }
        bRepository.save(b);
        
        aBRateEquilibrium.aBEquilibrium(false);
        
    }
    

    
}
