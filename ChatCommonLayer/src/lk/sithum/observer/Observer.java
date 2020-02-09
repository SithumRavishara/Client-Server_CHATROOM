/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sithum.observer;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sithum Ravishara
 */
public interface Observer extends Remote  {
    public void update(String message)throws Exception;
    public void showMessage(String user,String msg) throws RemoteException;
}
