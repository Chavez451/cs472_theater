package TicketSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Play
 */
@WebServlet("/Play")
public class Play extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Play() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = null;
		out = response.getWriter();
		
		BackPlay currPlay = Catalog.getPlay(0);
		//System.out.print(currPlay.getName());
		//out.println("<h1><center>Seats</center></h1>");
		//out.println(currPlay.getSeats(1).getPrice());
		out.println("<h1><center>");
		out.println(currPlay.getName());
		out.println("</center></h1>");
		out.println("<b><center>");
		out.println("Date: "+ Catalog.getPlay(0).getDate() +"----Time: "+ Catalog.getPlay(0).getTime()+"");
		out.println("</center></b>");
		out.println("<div style=\"text-align: right;\"><form method=get action=ShoppingCart><input type = submit value = \"Shopping Cart\"></form></div>");
		out.println("<b>Seats:</b>");
		
		currPlay.getSeats(3).setAvail(false);
		int e=0;
		while(e<12) {
			String c1="";
			String c2="";
			String c3="";
			String c4="";
			
			for(int i = 0; i<4;i++) {
				if(currPlay.getSeats(e+i).getAvail()) {
					if(i==0) {
						c1="green";
					}else if(i==1) {
						c2="green";
					}else if(i==2) {
						c3="green";
					}else {
						c4="green";
					}
				}else {
						if(i==0) {
							c1="red";
						}else if(i==1) {
							c2="red";
						}else if(i==2) {
							c3="red";
						}else {
							c4="red";
						}
					
				}
			}
			
			
			/*String temp = "<p><span><form style = \"float: left; dispaly:inline-block;\" method=get action=ShoppingCart><input type = submit name = e+1  value = " + newPlay.getSeats(e).getPrice() + "></form></span>"
					+ "<span><form style = \"float: left; dispaly:inline-block;\" method=get action=ShoppingCart><input type = submit name = e+1 value = " + newPlay.getSeats(e+1).getPrice() + "></form></span>"
					+ "<span><form style = \"float: left; dispaly:inline-block;\" method=get action=ShoppingCart><input type = submit name = e+2  value = " + newPlay.getSeats(e+2).getPrice() + "></form></span>"
					+ "<span><form style = \"dispaly:inline-block;\" method=get action=ShoppingCart><input type = submit name = e+3  value = " + newPlay.getSeats(e+3).getPrice() + "></form></span></p>";*/
			
			String temp = "<p><span><form style = \"float: left; dispaly:inline-block;\"action=\"ShoppingCart\" method=\"post\"><input style=\"background-color:"+c1+";\" type = \"submit\" value= \"$20\" /><input type = hidden name= id value=" + (e)+ "></form></span>"
					+ "<span><form style = \"float: left; dispaly:inline-block;\" action=\"ShoppingCart\" method=\"post\"><input style=\"background-color:"+c2+";\" type = \"submit\" value= \"$20\" /><input type = hidden name= id value=" + (e+1)+ "></form></span>"
					+ "<span><form style = \"float: left; dispaly:inline-block;\"action=\"ShoppingCart\" method=\"post\"><input style=\"background-color:"+c3+";\" type = \"submit\" value= \"$20\" /><input type = hidden name= id value=" + (e+2)+ "></form></span>"
					+ "<span><form style = \"dispaly:inline-block;\" action=\"ShoppingCart\" method=\"post\"><input style=\"background-color:"+c4+";\" type = \"submit\" id="+(e+3)+" value= \"$20\" /><input type = hidden name= id value=" + (e+3)+ "></form></span></p>";
			out.print(temp);
			
			
			
			e += 4;
			
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
