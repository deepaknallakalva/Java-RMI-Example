/*
  Name: Deepak Kumar Reddy Nallakalva
  Course: CS 512 - Advanced Operating Systems
*/

import java.rmi.*;
	import java.rmi.server.UnicastRemoteObject;

	 public class FavVGameServant extends UnicastRemoteObject implements FavVGame // FavVGameServant class implements FavVGame
		{  
	  	int myVersion;
	  	GraphicalObject theG;
	     
	 public FavVGameServant(GraphicalObject g, int version)throws RemoteException 
		{ 
	    	theG = g;
	    	myVersion = version;
	  	}
	    
	 public int getVersion() throws RemoteException 
		{
	    	return myVersion;
	  	}
		
	  public GraphicalObject  getAllState() throws RemoteException
		{
	    	return theG;
	  	}
	}



