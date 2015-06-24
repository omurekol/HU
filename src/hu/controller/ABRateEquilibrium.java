/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.controller;

import hu.entity.A;
import hu.entity.B;
import hu.repository.ARepository;
import hu.repository.BRepository;

/**
 *
 * @author omur.alcin
 */
public class ABRateEquilibrium {
        A a = new A();
        B b = new B();
    
        public void aBEquilibrium(boolean selection) throws Exception{
        //if changing is true its mean increasing else decreasing..
        //if selection is true its maean A was selected
        //else B was selected
             
             
            if(selection){
                BRepository bRepository = new BRepository();
                ARepository aRepository = new ARepository();
                    this.a = aRepository.find(1);
                    this.b = bRepository.find(1);
                    int afear = a.getFear();
                    int agoal = a.getGoal();
                    if(afear<100 || agoal<100){
                        b.setFear(100 - afear);
                        b.setGoal(100 - agoal);
                    }else{
                        b.setFear(afear-100);
                        b.setGoal(agoal-100);
                    }
                bRepository.save(b);
                 
            }else{
                ARepository aRepository = new ARepository();
                    BRepository bRepository = new BRepository();
                    this.b = bRepository.find(1);
                    this.a = aRepository.find(1);
                    
                    if(b.getFear()<100 || b.getGoal()<100){
                        a.setFear(100 - b.getFear());
                        a.setGoal(100 - b.getGoal());
                    }else{
                        a.setFear(b.getFear()-100);
                        a.setGoal(b.getGoal()-100);
                    }
                aRepository.save(a);
                
            }

        }
    
}
