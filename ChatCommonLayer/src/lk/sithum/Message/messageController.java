/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sithum.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sithum Ravishara
 */
public interface messageController extends Remote{
    public void sendMessage(String user,String msg) throws RemoteException;
}
