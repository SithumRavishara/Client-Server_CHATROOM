/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sithum.server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.sithum.friends.friendsDAO;

/**
 *
 * @author Sithum Ravishara
 */
public class serverStarter {
    
    public static void main(String[] args) {
       
        try {
            Registry registry = LocateRegistry.createRegistry(7070);
            registry.bind("chat",friendsDAO.getinstances());
            System.out.println("Server Start....");
        } catch (RemoteException ex) {
            Logger.getLogger(serverStarter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(serverStarter.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
