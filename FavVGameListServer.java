/*
  Name: Deepak Kumar Reddy Nallakalva
  Course: CS 512 - Advanced Operating Systems
*/


import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class FavVGameListServer // FavVGameListServer class initializing the port number and connect to client 
	{
	public static void main(String args[])
		{
   		// NOTE: RMISecurityManager() was depricated in Java 1.8.
       		// We should use SecurityManager() instead of RMISecurityManager().
           	// System.setSecurityManager(new RMISecurityManager()); //deleted
                System.setSecurityManager(new SecurityManager());  // A server method in which we hard code the port number 
                try{
                          String hostName="toolman.wiu.edu";//add this line and change constructors
                          int port=1431;//add this line and change constructors
                          FavVGameList aFavVGameList = new FavVGameListServant(hostName,port);
                          //use this constructor
                          //ShapeList aShapeList = new ShapeListServant(); //old constructor
                          //ShapeList stub = (ShapeList) UnicastRemoteObject.exportObject(aShapeList,0);
                          //delete; no longer needed
                          Naming.rebind("//"+hostName+":"+port+"/aFavVGameListQ", aFavVGameList); 
                          //modified to use port 1100
                          //Naming.rebind("ShapeList", aShapelist);  //deleted
                          System.out.println("FavVGameList server is ready");
                          }catch(Exception e) {
                          System.out.println("FavVGameList server main " + e.getMessage());
                   }
                  }
         }



