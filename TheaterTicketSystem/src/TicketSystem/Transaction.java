package TicketSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Transaction
 */
@WebServlet("/Transaction")
public class Transaction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Transaction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = null;
		out = response.getWriter();
		
		BackTransaction currTran = new BackTransaction(1);
		BackShoppingCart currCart = Catalog.getCart();
		
		out.println("<center><h1>Transaction<h1></center>");
		String name;
		String phone;
		String address;
		String card="";
		int totalPrice = 0;
		boolean cont=true;
		try {
			name = request.getParameter("fname");
			phone = request.getParameter("phone");
			address = request.getParameter("address");
			card = request.getParameter("card");
			
			if(!currTran.checkCard(card)) {
				int temp = 1/0;
			}
			
			
		}
		catch(Exception e) {
			out.println("<p><center>There was an error with your information. Please go back and enter it again.</center><p>");
			cont = false;
		}
		
		if(cont) {
			for(int i=0; i< currCart.numOPlays(); i ++) {
				totalPrice += currCart.getSeat(i).getPrice();
			}
			
			if(currTran.checkCard(card)) {
				out.println("<p><div style\"text-align: right;\">Transaction ID: "+ Catalog.getID() +"</div>");
				out.println("<p><center>Your order has been processed. Thank You!");
				out.println("Here is the information for your order:</center></p><p>");
				out.println("<center><p>Plays-------Seats---------Date-------Time<p></center>");
				for(int i=0; i< currCart.numOPlays(); i++) {
					BackPlay currPlay = currCart.getPlay(i);
					BackSeat currSeat = currCart.getSeat(i);
					out.println("<center style= float><p>" + currPlay.getName()+"-------" + currSeat.getID()+"-------"+currPlay.getDate()+"------- "+currPlay.getTime()+"</p><p></center>");
				}
				out.println("<center><div style=\"text-align: right;\">Total: $"+ totalPrice +"</div></center>");
				currTran.setUnavail();
				currCart.emptyCart();
			}
			
			
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
