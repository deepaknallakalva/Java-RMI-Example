/*
  Name: Deepak Kumar Reddy Nallakalva
  Course: CS 512 - Advanced Operating Systems
*/

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;
	
public class FavVGameListServant extends UnicastRemoteObject implements FavVGameList //FavVGameListServant class extends to UnicastRemoteObject which implements FavVGameList
	{ 
	  private Vector<FavVGame>  theList;
	  private int version;
	    
	  public FavVGameListServant(String hostName, int port)throws RemoteException{  
	    theList = new Vector<FavVGame>();
	    version = 0;
	 }

	 public FavVGame newFavVGame(GraphicalObject g) throws RemoteException
	 {
	    version++;
	    FavVGame s = new FavVGameServant( g, version);
	    theList.addElement(s);                
	    return s;
	 }

	 public  Vector allShapes()throws RemoteException
	  {
	    return theList;
	  }

	  public int getVersion() throws RemoteException
	  {
	    return version;
	  } 
	}



