/*
  Name: Deepak Kumar Reddy Nallakalva
  Course: CS 512 - Advanced Operating Systems
 */



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.*;
import java.rmi.server.*;
import java.util.Vector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class FavVGameListClient{   


	public static void main(String args[]){


		//to Read input from the console
		BufferedReader bufferReader = new BufferedReader(new InputStreamReader(System.in));

		String operation="Read"; 
		String gameName =null, gamePlatform=null;
		int gameRating=0;

		if(args.length > 0)
			operation = args[0];  
		if(args.length > 1)  
			gameName = args[1];
		if(args.length > 2)  
		{
			gamePlatform=args[2];
			gameRating= Integer.parseInt(args[3]);
		}


		System.out.println("name = " + gameName + " platform = " + gamePlatform + " rating = " + gameRating);
		if(System.getSecurityManager() == null){
			//NOTE: RMISecurityManager() was depricated in Java 1.8.
			//We should use SecurityManager() instead of RMISecurityManager().
			//System.setSecurityManager(new RMISecurityManager()); //deleted
			System.setSecurityManager(new SecurityManager());
		} 
		else 
			System.out.println("Already has a security manager, so cant set RMI SM");
		FavVGameList aFavVGameList = null;
		try{
			aFavVGameList  = (FavVGameList) Naming.lookup("//toolman.wiu.edu:1431/aFavVGameListQ");
			//modified since we modified our server to use 
			//port 1100 instead of the default port 1099.
			System.out.println("Found Game server");
			Vector sList = aFavVGameList.allShapes();
			System.out.println("Got vector");

			//Using List to keep track of the Gamename, Rating and Platform
			List<String> gameNames = new ArrayList<String>();
			List<Integer> gameCounter = new ArrayList<Integer>();
			List<String> gamesCount = new ArrayList<String>();

//			Map<String,Integer> averageMap = new HashMap<String,Integer>();
//
//			int mapcnt=0;
//			if(averageMap.containsKey(gameName) == false){
//				averageMap.put(gameName, gameRating);
//			}
//			else
//			{
//				mapcnt= averageMap.get(gameName) + 1;
//				averageMap.put(gameName, mapcnt);
//			}
//
//			//Use Set to fetch all the entries into a set from HashMap
//			Set entries = averageMap.entrySet();
			String topGame="Ghi";



			if(operation.equals("Read"))
			{
				boolean status=true;

				for(int i=0; i<sList.size(); i++){
					GraphicalObject g = ((FavVGame)sList.elementAt(i)).getAllState();

					//We are adding data into the List by using the Graphical Object Members
					gameNames.add(g.name());
				}


				boolean flag =true;
				double totalCount = 0.0;
				int b=0;

				for (int a=0; a< gameNames.size();){
					b=a+1;
					int counter = 1;

					while(b < gameNames.size()) 
					{
						if(gameNames.get(a).equals(gameNames.get(b)))
						{
							counter++;
						}//end of if
						b++;
					}//end of while

					if(!gamesCount.contains(gameNames.get(a))){
						gamesCount.add(gameNames.get(a));
						gameCounter.add(counter);
					}//end of if
					a++;
				}//end of for loop


				int maximum=0, k=0;
				while(k<gameCounter.size())
				{
					if(gameCounter.get(maximum) < gameCounter.get(k) ) {
						maximum=k;
					}

					k++;
				}

				while(flag)				
				{
					System.out.println("Enter 1 : To get most video game submissions so far");
					System.out.println("Enter 2 : To get the Name of the video game that has greatest average rating");
					System.out.println("Enter 3 : Total submissions for Def");
					System.out.println("Enter 4 : Total Submissions");
					System.out.println("Enter 5 : Complete List of different video games ");
					System.out.println("Enter 6 : Exit ");

					int input =Integer.parseInt(bufferReader.readLine());

					switch(input)
					{
					case 1:
						System.out.println("The most number of submissions is for VideoGame = "+gamesCount.get(maximum));

						break;

					case 2:

						System.out.println("The game with highest average rating is Rating= "+ topGame);
						break;

					case 3:
						String game="Def";
						int  count =0;
						for(int i=0;i< gamesCount.size();i++){
							if(game.equals(gameNames.get(i))) 
							{
								System.out.println("The Number of submissions for " +game+ " is = " + gameCounter.get(i));
							}
						}
						break;

					case 4:
						System.out.println("The Total Number of Video Game Submissions "+gameNames.size());

						break;
					case 5:
						System.out.println("The List of different video games is: "+gamesCount);
						break;

					case 6:
						System.out.println("Bye!");
						System.exit(0);

						break;
					}

				}//end of while
			}//end of if
			else
			{
				GraphicalObject g = new GraphicalObject(gameName,gamePlatform,gameRating);
				System.out.println("Created Video Game object");
				aFavVGameList.newFavVGame(g);
				System.out.println("Stored Video Game ");
			}//end of else
		}
		catch(RemoteException e) {
			System.out.println("Video Games: " + e.getMessage());
		}catch(Exception e) {
			System.out.println("Lookup: " + e.getMessage());
		}
	}
}




