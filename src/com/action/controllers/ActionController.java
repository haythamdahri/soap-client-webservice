package com.action.controllers;

import java.io.Writer;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.action.utils.MainUtils;

@WebServlet("/actions")
public class ActionController extends HttpServlet{

	
	/*
	 * Handle Get requests 
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			
			String bourse = request.getParameter("bourse");
			
			if( bourse == null ) {
				String renderedHtml = MainUtils.getRenderedActions();
				Writer writer = response.getWriter();
				
				// Write html to user
				// Set content type to html as a return results 
				response.setContentType("text/html");
				writer.write(renderedHtml);
				writer.close();
			} else {
				String renderedHtml = MainUtils.getRenderedBourseActions(Long.parseLong(bourse));
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
