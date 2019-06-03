package com.action.controllers;

import java.io.Writer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.utils.MainUtils;

@WebServlet("/bourses")
public class BourseController extends HttpServlet{

	
	/*
	 * Handle Get requests 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			HttpSession session = request.getSession();
			
			String userEmail = (String)session.getAttribute("email");
			String userPassword = (String)session.getAttribute("password");
			
			String id = request.getParameter("id");
			String type = request.getParameter("search-type");
			
			// Render bourses list if no id imposed
			if( id == null ) {
				String renderedHtml = MainUtils.getRenderedBourses(userEmail);
				Writer writer = response.getWriter();
				
				// Write html to user
				// Set content type to html as a return results 
				response.setContentType("text/html");
				writer.write(renderedHtml);
				writer.close();
			} else {
				if( type != null && type.equalsIgnoreCase("list") ) {
					String renderedHtml = MainUtils.getRenderedBourses(Long.parseLong(id), userEmail);
					Writer writer = response.getWriter();
					
					// Write html to user
					// Set content type to html as a return results 
					response.setContentType("text/html");
					writer.write(renderedHtml);
					writer.close();
				} else {
					String renderedHtml = MainUtils.getRenderedBourse(Long.parseLong(id), userEmail);
					Writer writer = response.getWriter();
					
					// Write html to user
					// Set content type to html as a return results 
					response.setContentType("text/html");
					writer.write(renderedHtml);
					writer.close();
				}
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
