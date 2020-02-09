/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Sithum Ravishara
 */
public interface ChatService extends Remote{
    public void sendMessage(String user,String msg) throws RemoteException;
}
