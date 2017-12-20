/*
  Name: Deepak Kumar Reddy Nallakalva
  Course: CS 512 - Advanced Operating Systems
*/

import java.io.Serializable;

public class GraphicalObject implements Serializable   // GraphicalObject class implements using Serializable
	{ 
	  public String gamename;
	  public String platform;
	  public int rating;
	    
	  //	constructors
	  public GraphicalObject() { }
	    
	  public GraphicalObject(String name, String plat,int rate) // GraphicalObject constructor with gamename,ratinf and platform as inputs
		{ 
	   		gamename=name;
	   		platform=plat;
	   		rating=rate;
	   		
	  	}
	  
	  public String name()   // returning gamename, platform and rating
	  {
		  return gamename;
	  }
	  public String platform()
	  {
		  return platform;
	  }
	  public int rate()
	  {
		  return rating;
	  }
	  public void print()
	  {
	    	System.out.print(gamename);
	    	System.out.print(platform);
	    	System.out.print(rating);
	  }
	}


