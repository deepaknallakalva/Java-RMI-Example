/*
  Name: Deepak Kumar Reddy Nallakalva
  Course: CS 512 - Advanced Operating Systems
*/

import java.rmi.*;
import java.util.Vector;


public interface FavVGameList extends Remote // FavVGameList class is performing an interface which extends to remote operation 
	{
	  FavVGame newFavVGame(GraphicalObject g) throws RemoteException;  // throws an exception 	    
	  Vector allShapes()throws RemoteException;
	  int getVersion() throws RemoteException;
	}

