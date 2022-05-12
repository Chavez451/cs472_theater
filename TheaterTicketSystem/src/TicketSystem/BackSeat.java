package TicketSystem;

public class BackSeat {
	//seat info
		private int sID;
		private int sPrice;
		private boolean sAvail = false;
		
		public BackSeat(int number,int price,boolean avail) 
		{
			sID = number;
			sPrice = price;
			sAvail = avail;
		}
		
		//Get Seat ID
		public int getID() {
			return sID;
		}
		
		//Get Seat Price
		public int getPrice() {
			return sPrice;
		}
		
		//Get Seat Availability
		public boolean getAvail() {
			return sAvail;
		}
		
		//Set Price
		public void setPrice(int price) {
			sPrice = price;
		}
		
		//Set Availability
		public void setAvail(boolean avail) {
			sAvail = avail;
		}

	}
