package com.action.controllers;

import java.io.Writer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.utils.MainUtils;

@WebServlet("/price-action")
public class HomeController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			// Catch error paramameters
			String error = request.getParameter("error");

			// Check if user is connected
			HttpSession session = request.getSession();
			
			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");
			
			// Action name parameter
			String actionName = request.getParameter("action");
			
			String renderedHtml = "";
			
			if( actionName == null ) {
				renderedHtml = MainUtils.getRenderedHomePage(email, null, null, null);	
			} else {
				renderedHtml = MainUtils.getRenderedHomePage(email, null, null, actionName);	
			}
			
			Writer writer = response.getWriter();

			// Write html to user
			// Set content type to html as a return results
			response.setContentType("text/html");
			writer.write(renderedHtml);
			writer.close();
			
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
}
