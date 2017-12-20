/*
  Name: Deepak Kumar Reddy Nallakalva
  Course: CS 512 - Advanced Operating Systems
*/


import java.rmi.*;
import java.util.Vector;


public interface FavVGame extends Remote // FavVGame class performing with an interface which extends to remote operation
	{
	   int getVersion() throws RemoteException;     
	   GraphicalObject getAllState() throws RemoteException;
	}



