/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sithum.dto;

import java.io.Serializable;

/**
 *
 * @author Sithum Ravishara
 */
public class friendsDTO implements Serializable{
    
    private String ID;
    private String NAME;
    private String PASSWORD;
    private String STATUS;
    
    
    public friendsDTO(){
    }
    
    public friendsDTO(String id,String name,String password,String status){
    this.ID=id;
    this.NAME=name;
    this.PASSWORD=password;
    this.STATUS=status;
    }

   public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }
    

    
}
