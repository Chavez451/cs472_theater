package TicketSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShoppingCart
 */
@WebServlet("/ShoppingCart")
public class ShoppingCart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ShoppingCart() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		response.setContentType("text/html");
		PrintWriter out = null;
		out = response.getWriter();
		
		BackShoppingCart currCart = Catalog.getCart();
		
		
		out.println("<center><h1>Shopping Cart<h1></center>");
		out.println("<b>Your Items<b>");
		
		int totalPrice = 0;
		
		
		
		try {
			out.println("<center><p>Plays-------Seats<p></center>");
			for(int i=0; i<= currCart.numOPlays(); i ++) {
				BackPlay currPlay = currCart.getPlay(i);
				BackSeat currSeat = currCart.getSeat(i);
				totalPrice += currSeat.getPrice();
				out.println("<center style= float><p>" + currPlay.getName()+"-------" + currSeat.getID() +  "<span><form style = \"dispaly:inline-block\" action=\"ShoppingCart\" method=\"post\"><input type = \"submit\" value= \"Remove\" /><input type = hidden name= dI value="+i+"></form></span></p><p></center>");
			}
			
		}
		catch(Exception e){
			
		}
		out.println("<center><div style=\"text-align: right;\">Total: $"+ totalPrice +"</div></center>");
		out.println("<div style=\"text-align: right;\"><form method=get action=LogIn><input type = submit value = \"Purchase Cart\"></form></div></div>");
		
			
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = null;
		out = response.getWriter();
		System.out.println("Is Here");
		boolean cont = true;
		
		try {
			 int button = Integer.parseInt(request.getParameter("id"));
			 System.out.println(button);
			 if(Catalog.getPlay(0).getSeats(button).getAvail()) {
				 for(int i=0;i<Catalog.getCart().numOPlays();i++) {
					 if((button+1)==Catalog.getCart().getSeat(i).getID()) {
						 cont=false;
					 }
				 }
				 if(cont) {
					 Catalog.getCart().addToCart(Catalog.getPlay(0), Catalog.getPlay(0).getSeats(button));
				 }
				 
			 }
			 
			 out.print("<form name=\"myForm\" id=myForm action=\"Play\" method=\"get\"><center><input type=\"submit\"  value=\"Go Back\"</input></center></form>");
			 out.print("<script>document.getElementbyId(\"myForm\").submit();</script>");
			 
		}
		catch(Exception e) {
			
		}
		try {
			int button = Integer.parseInt(request.getParameter("dI"));
			Catalog.getCart().remFrCart(button);
			out.print("<form name=\"myForm\" id=myForm action=\"ShoppingCart\" method=\"get\"><center><input type=\"submit\"  value=\"Go Back\"</input></center></form>");
			out.print("<script>document.getElementbyId(\"myForm\").submit();</script>");
			
		}
		catch(Exception e) {
			
		}
		
		
		
		
	}
}

