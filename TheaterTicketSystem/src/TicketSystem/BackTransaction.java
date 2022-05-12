package TicketSystem;

import java.util.ArrayList;

public class BackTransaction {
	
	private int tranID;
	private int totalPrice=0;
	
	
	
	public BackTransaction(int id) {	
		tranID = id;
		
	}

	
	
	public boolean checkCard(String cNum) {
		
		boolean validCard = true;
		if(cNum.length() < 13) {
			validCard = false;
		}
		/*
		 * Chech to see if number is valid with card company
		 * validCard = False if not
		 */
		
		return validCard;
	}
	
	public boolean chargeCard(int amount) {
		
		
		/*
		 * Charge card with the amount
		 * return true if completed
		 */
		boolean cardCharged = true;
		
		return cardCharged; //temp
	}
	
	public void setUnavail() {
		
		BackShoppingCart currCart = Catalog.getCart();
		
		for(int i = 0; i<currCart.numOPlays();i++) {
			
			currCart.getSeat(i).setAvail(false);;
			
		}
	}



	
	
	
	
	
	


}
