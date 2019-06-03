package com.action.controllers;

import java.io.Writer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.utils.MainUtils;

@WebServlet("/actions")
public class ActionController extends HttpServlet{

	
	/*
	 * Handle Get requests 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HttpSession session = request.getSession();
			
			String userEmail = (String)session.getAttribute("email");
			String userPassword = (String)session.getAttribute("password");
			
			String bourse = request.getParameter("bourse");
			String actionName = request.getParameter("name");
			
			if( bourse != null ) {
				String renderedHtml = MainUtils.getRenderedBourseActions(Long.parseLong(bourse), userEmail);
				Writer writer = response.getWriter();
				
				// Write html to user
				// Set content type to html as a return results 
				response.setContentType("text/html");
				writer.write(renderedHtml);
				writer.close();
			} else if( actionName != null ) {
				String renderedHtml = MainUtils.getRenderedActionHistory(actionName.trim(), userEmail);
				Writer writer = response.getWriter();
				
				// Write html to user
				// Set content type to html as a return results 
				response.setContentType("text/html");
				writer.write(renderedHtml);
				writer.close();
				
			} else {
				
				String renderedHtml = MainUtils.getRenderedActions(userEmail);
				Writer writer = response.getWriter();
				
				// Write html to user
				// Set content type to html as a return results 
				response.setContentType("text/html");
				writer.write(renderedHtml);
				writer.close();
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
