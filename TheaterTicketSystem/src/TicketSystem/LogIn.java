package TicketSystem;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogIn
 */
@WebServlet("/LogIn")
public class LogIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogIn() {
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
		
		out.print("<head><h1>Please Enter Your Information:</h1></head>");
		out.print("<body><p><form action=Transaction method=get>");
		out.print("<lable for=fname> First and Last Name: </lable><br>");
		out.print("<input type=text id=fname name=fname><br>");
		out.print("<lable for=phone> Phone Number: </lable><br>");
		out.print("<input type=text id=phone name=phone><br>");
		out.print("<lable for=address> Address: </lable><br>");
		out.print("<input type=text id=address name=address><br>");
		out.print("<lable for=card> Card Number: </lable><br>");
		out.print("<input type=text id=card name=card><br>");
		out.print("<input type=submit value = \"Pay Total: $"+ Catalog.getCart().getTotalPrice() +"\"></form><body>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
