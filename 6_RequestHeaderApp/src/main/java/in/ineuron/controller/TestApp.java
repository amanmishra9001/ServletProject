package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns ="/Test")
public class TestApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static {
		System.out.println("initialization");
	}
	
	public TestApp(){
		System.out.println("Aman");
	}
	

	//refer : 6_RequestHeaderApp application for the code
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<body>");
		out.println("<h1 style = 'color:red; text-align:center;'>Request Header</h1>");
		out.println("<table border='1'>");
		
		out.println("<tr><th>header name</th><th>header value</th></tr>");
		
		
		Enumeration<String> headerNames = request.getHeaderNames();
		while (headerNames.hasMoreElements()) {
			String headerName = (String) headerNames.nextElement();
			String value = request.getHeader(headerName);
			
			out.println("<tr>");
			out.println("<td>"+ headerName +"</td>");
			out.println("<td>"+ value +"</td>");
			out.println("<tr>");	
		}
		out.println("</table>");
		out.println("</body>");
		out.close();
	}


}
