package TicketSystem;
import java.util.ArrayList;

public class BackCatalog {
	
		//List of plays
		private ArrayList<BackPlay> playList = new ArrayList<BackPlay>();
		//Total Sales
		private int totalPosSales;
		private int totalSales;
		private int totalNumPlays = 0;
		//ID's
		
		public BackCatalog() {
			
		}
		
		//Add play to catalog
		public void addPlay(BackPlay newPlay)
		{
			playList.add(newPlay);
			totalNumPlays ++;
			
		}
		
		//Update the sales
		public void updateSales() {
			
			totalSales = 0;
			totalPosSales = 0;
			
			for(int i=0;i<totalNumPlays; i++) 
			{
				BackPlay currPlay = playList.get(i);
				totalSales += currPlay.getTotalPSales();
				totalPosSales += currPlay.getTotalPosPSales();
				
			}
		}
		
		//Theater Total Possiable Sales
		public int getTotalPosSales() {
			return totalPosSales;
		}
		
		//Theater Total Completed Sales
		public int getTotalSales() {
			return totalSales;
		}
		
		public BackPlay getPlays(int i) {
			return(playList.get(i));
		}
		
		//Provide Catalog info
		public void showCatalog()
		{
			int numOPlays = playList.size();
			for(int i=0; i<numOPlays; i++) 
			{
				BackPlay currPlay = playList.get(i);
				
				//get play info
				String name = currPlay.getName();
				String date = currPlay.getDate();
				String time = currPlay.getTime();
				
				//temp
				System.out.println(name);
				System.out.println(date);
				System.out.println(time);
				System.out.println("");
				
				
			}
		}
		

	}

