/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.controller;

import hu.entity.A;
import hu.entity.B;
 
import hu.repository.ARepository;

/**
 *
 * @author omur.alcin
 */
public class ARateController {
            A a = hu.Karar.a;
            B b = hu.Karar.b;
    
    ABRateEquilibrium aBRateEquilibrium = new ABRateEquilibrium();
    ARepository aRepository = new ARepository();

    public ARateController() {

    }
  
    public void aRateIncreaser(int value) throws Exception{
             
            if(a.getFear() < 100 && a.getGoal() < 100){
                if(value == 0){
                    a.setFear(a.getFear()+1);
                    a.setGoal(a.getGoal()+1);
                }else{
                    a.setFear(a.getFear()+value);
                    a.setGoal(a.getGoal()+value);
                }
                aRepository.save(a);  
                aBRateEquilibrium.aBEquilibrium(true);
            }else{//inverse to negative after 100
//                if(value == 0){
//                     aRateDecreaser(0);
//                }else{
//                    aRateDecreaser(value);
//                }
            }
          
    }
    
    public void aRateDecreaser(int value) throws Exception{
  
        if(value == 0){
            a.setFear(a.getFear()-1);
            a.setGoal(a.getGoal()-1);
        }else{
            a.setFear(a.getFear()-value);
            a.setGoal(a.getGoal()-value);
        }
        aRepository.save(a); 
         
        aBRateEquilibrium.aBEquilibrium(true);
    }
    

    
}
