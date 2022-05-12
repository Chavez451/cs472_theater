package TicketSystem;
import java.util.ArrayList;

import java.util.ArrayList;

public class BackShoppingCart {

		
		private ArrayList<BackPlay> playList = new ArrayList<BackPlay>();
		private ArrayList<BackSeat> seatList = new ArrayList<BackSeat>();
		//private ArrayList<BackSeat> tempList = new ArrayList<BackSeat>();
		private int totalPrice=0;
		
		//Add to Cart
		public void addToCart(BackPlay newPlay,BackSeat newSeat) {
			
			playList.add(newPlay);
			seatList.add(newSeat);
			totalPrice+=newSeat.getPrice();
			
		}
		
		//Remove from cart
		public void remFrCart(int iD) {
			playList.remove(iD);
			seatList.remove(iD);
				
		}
		
		//Get total cart Price
		public int getTotalPrice() {
			totalPrice=0;
			for(int i=0;i<numOPlays();i++) {
				totalPrice += seatList.get(i).getPrice();
				
			}
			return totalPrice;
		}
		
		public int numOPlays() {
			return playList.size();
		}
		
		public BackPlay getPlay(int i) {
			return playList.get(i);
		}
		
		public BackSeat getSeat(int i) {
			return seatList.get(i);
		}
		
		public void emptyCart() {
			playList.clear();
			seatList.clear();
		}
		//Buy Cart
		//Not in Use
		/*public void chechout() {
			tempList.clear();
			boolean notAvail = false;
			for(int i=0; i<seatList.size();i++) {
				BackSeat currSeat = seatList.get(i);
				if(currSeat.getAvail()) {
					tempList.add(currSeat);
					//Make seats unavailable
					currSeat.setAvail(false);
					 
				}else{
					//Notify that seat is taken
					notAvail = true;
				}
			
			}
			if(notAvail) {
				
				for(int i=0; i<tempList.size();i++) {
					//Make seats available again.
					tempList.get(i).setAvail(true);
				}
				
			}else {
			
				
			}
		}*/

	}
