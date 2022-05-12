package TicketSystem;
import java.util.ArrayList;
public class BackPlay {

		//play info
		private String pName;
		private int pID;
		private String pDate;
		private String pTime;
		private ArrayList<BackSeat> seatList = new ArrayList<BackSeat>();
		//play sales
		private int totalPosPSales;
		private int totalPSales;
		//seats
		private int numberOfSeats = 12;
		
		public BackPlay(String name,String date,String time, int iD) 
		{
			pName = name;
			pID = iD;
			pDate = date;
			pTime = time;
			genSeats();
			updateSales();
			
		}
		
		//update sales
		private void updateSales() {
			
			totalPSales = 0;
			totalPosPSales = 0;
			for(int i=0;i<numberOfSeats; i++) 
			{
				BackSeat currSeat = seatList.get(i) ;
				int price = currSeat.getPrice();
				
				totalPosPSales += price;
				
				if(!currSeat.getAvail()) {
					totalPSales += price;
				}
				
			}
		}
		//generate all seats
		private void genSeats(){
			
			for(int i=0;i<numberOfSeats; i++) 
			{
				BackSeat newSeat = new BackSeat(i+1,20, true);
				seatList.add(newSeat);
			}
		}
		
		//Get Play Name
		public String getName() {
			return pName;
		}
		
		public BackSeat getSeats(int i) {
			return(seatList.get(i));
		}
		

		//Get Play ID
		public int getPID() {
			return pID;
		}
		
		//Get Play Date
		public String getDate() {
			return pDate;
		}
		
		//Get Total Play Sales
		public int getTotalPSales() {
			return totalPSales;
		}
		
		//Get Total Possible Play Sales
		public int getTotalPosPSales() {
			return totalPosPSales;
		}
		
		//Get Play Time
		public String getTime() {
			return pTime;
		}
		
		//Set Name
		public void setName(String name) {
			pName = name;
		}
		
		//Set Date
		public void setDate(String date) {
			pDate = date;
		}
		
		//Set Time
		public void setTime(String time) {
			pTime = time;
		}

		
	}

