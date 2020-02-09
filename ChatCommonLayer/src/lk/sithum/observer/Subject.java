/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sithum.observer;

import java.rmi.Remote;

/**
 *
 * @author Sithum Ravishara
 */
public interface Subject extends  Remote{
    public void register(Observer observer) throws Exception;
    public void unregister(Observer observer) throws Exception;
    public void notifyall0bservers(String message) throws Exception;
}
