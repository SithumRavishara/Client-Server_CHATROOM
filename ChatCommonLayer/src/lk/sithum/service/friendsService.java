/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sithum.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import lk.sithum.Message.messageController;
import lk.sithum.dto.friendsDTO;
import lk.sithum.observer.Subject;
import reservation.Reservation;

/**
 *
 * @author Sithum Ravishara
 */
public interface friendsService extends Remote,Subject,Reservation,messageController{
    public boolean addfriends(friendsDTO dto) throws Exception;
    public boolean deletefriend(String id) throws Exception;
    public friendsDTO searchfriend(String id) throws Exception;
    public ArrayList<friendsDTO> getAllfriends() throws Exception;
    public friendsService getfriendsService()throws Exception;
    
}
