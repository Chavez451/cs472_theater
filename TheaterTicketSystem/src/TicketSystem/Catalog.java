package TicketSystem;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Catalog
 */
@WebServlet("/Catalog")
public class Catalog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static BackCatalog cat = new BackCatalog(); 
	private static BackShoppingCart cart = new BackShoppingCart();
	private static int tranID=0;
    public Catalog() {
		cat.addPlay(new BackPlay("War Horse", "5/11","10:30 pm",1));
		
		
			
		System.out.println("Completed");
    }

  
	public static BackSeat getSeats(int i, int e) {
		BackPlay currPlay = getPlay(i);
		return(currPlay.getSeats(e));
	}

	public static BackPlay getPlay(int i) {
		return (cat.getPlays(i));
	}
	public static BackShoppingCart getCart() {
		return (cart);
	}
	public static int getID() {
		tranID +=1;
		return tranID;
	}

}
