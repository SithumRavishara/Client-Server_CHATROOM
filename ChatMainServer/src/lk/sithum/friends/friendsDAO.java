/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.sithum.friends;

import Reservation.impl.reservationImpl;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.sithum.dto.friendsDTO;
import lk.sithum.observer.Observer;
import lk.sithum.service.friendsService;

/**
 *
 * @author Sithum Ravishara
 */
public class friendsDAO extends UnicastRemoteObject implements friendsService{
    
    private static friendsDAO Friendsdao;
    
    private static ArrayList<Observer> allObseervers  = new ArrayList<>();
    private static reservationImpl<friendsService> reservationImpl = new reservationImpl();
    
    public friendsDAO()throws Exception{
    }
 
    public static friendsDAO getinstances()throws Exception{
        if (Friendsdao == null) {
            Friendsdao = new friendsDAO();
        }
    return Friendsdao;
    }
    
    @Override
    public boolean addfriends(friendsDTO dto) throws Exception {
       Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatroom","root","sithum");
        PreparedStatement pstm = connection.prepareStatement("Insert into subscriber values(?,?,?,?)");
        pstm.setObject(1, dto.getID());
        pstm.setObject(2, dto.getNAME());
        pstm.setObject(3, dto.getPASSWORD());
        pstm.setObject(4, dto.getSTATUS());
        int executeUpdate = pstm.executeUpdate();
        this.notifyall0bservers(dto.getNAME() +" is aded to the database");
        return executeUpdate>0;
    }

    @Override
    public void register(Observer observer) throws Exception {
       allObseervers.add(observer);
    }

    @Override
    public void unregister(Observer observer) throws Exception {
        allObseervers.remove(observer);
    }

    @Override
    public void notifyall0bservers(String message) throws Exception {
        for (Observer allObseerver : allObseervers) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        allObseerver.update(message);
                    } catch (Exception ex) {
                        Logger.getLogger(friendsDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
            }).start();
            
        }
    }

    @Override
    public boolean reserve(Object key) throws Exception {
        return reservationImpl.reserve(key, this, true);
    }

    @Override
    public boolean release(Object key) throws Exception {
        return reservationImpl.release(key, this);
    }

    @Override
    public boolean deletefriend(String id) throws Exception {
        
         Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatroom","root","sithum");
        PreparedStatement pstm = connection.prepareStatement("Delete from subscriber where Id=?");
        pstm.setObject(1, id);
        int executeUpdate = pstm.executeUpdate();
        this.notifyall0bservers(id +" is Deleted from the database");
        return executeUpdate>0;
        
    }

    @Override
    public friendsDTO searchfriend(String id) throws Exception {
         Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/chatroom","root","sithum");
        PreparedStatement pstm = connection.prepareStatement("select*from subscriber where ID=?");
        pstm.setObject(1, id);
        ResultSet rst = pstm.executeQuery();
        friendsDTO dto = null;
        while(rst.next()){
           dto =new friendsDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
        }
        
        return dto;
    }

    @Override
    public ArrayList<friendsDTO> getAllfriends() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/subscriber","root","sithum");
        PreparedStatement pstm = connection.prepareStatement("select*from subscriber");
        
        ResultSet rst = pstm.executeQuery();
        ArrayList<friendsDTO> allfriends = new ArrayList<>();
        while(rst.next()){
           friendsDTO dto =new friendsDTO(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4));
           allfriends.add(dto);
        }
      
        return allfriends;
    }

    @Override
    public friendsService getfriendsService() throws Exception {
        return Friendsdao = new friendsDAO();
    }
    
    public friendsDAO getfriendsdao(){
      return Friendsdao;
    }

    @Override
    public void sendMessage(String user, String msg) throws RemoteException {
       for (Observer allObseerver : allObseervers) {
            new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        allObseerver.showMessage(user, msg);
                    } catch (Exception ex) {
                        Logger.getLogger(friendsDAO.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
            }).start();
            
        } 
    }
    
    
}
