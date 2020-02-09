/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reservation.impl;

import Reservation.impl.reservationImpl.Resmap;
import java.util.HashMap;

/**
 *
 * @author Sithum Ravishara
 */
public class reservationImpl<T> {
    
    static class Resmap<T>{
    boolean isSelected;
    T Service;
    
    public Resmap(boolean isSelected,T Service){
       this.Service = Service;
       this.isSelected = isSelected;
    }
    
    }
    
    public HashMap<Object,Resmap<T>> reservationmap = new HashMap<>();
    
    public boolean reserve(Object key,T Service,boolean isSelected){
        if (reservationmap.containsKey(key)) { //key akak thiyenwda blnwa
            if (reservationmap.get(key).Service == Service) {  //a key aka aragena .get wlin akata adala service aka samana krnwa service akata
                return true; //ehma service aka samana nm reserve wela kiala return krnwa
            }
        } else {
            reservationmap.put(key, new Resmap<T>(isSelected,Service)); //ehma ntnm ethnta key akakui remap akkui dnwa
            return true;
        }
    return false;
    }
   
    
    public boolean release(Object key,T Service){
        if (reservationmap.containsKey(key)&&reservationmap.get(key).Service == Service) {  //release kirimedi Object akak lesa dena key aka hri key akata adala service aka hri deken akak ath nm key aka remove krnwa.
            reservationmap.remove(key);
            return true;
        } else {                                //ehma dekek akakwth ntnm release krnna deyak nti hnda false krnwa return aka.
            return false;
        }
     
    }
    
     public boolean Checkreservedstate(Object key,T Service){
        if (reservationmap.containsKey(key)&&reservationmap.get(key).Service == Service) {  
            return reservationmap.get(key).isSelected;
        } else {                                
            return false;
        }
     
    }
    
    
    
    
}
