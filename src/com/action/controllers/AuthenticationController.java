package com.action.controllers;

import java.io.IOException;
import java.io.Writer;
import java.rmi.RemoteException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.utils.MainUtils;

@WebServlet("/login")
public class AuthenticationController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			// Catch error paramameters
			String error = request.getParameter("error");
			
			// Check if user is connected
			HttpSession session = request.getSession();

			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");

			// Redirect use to the home page if already connected
			if (email != null && password != null) {
				response.sendRedirect(request.getServletContext().getContextPath() + "/bourses");
			} else {
				String renderedHtml = MainUtils.getLoginPage(error);
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

	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		try {
			// Check if user is connected
			HttpSession session = request.getSession();

			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");

			// Redirect use to the home page if already connected
			if (email != null && password != null) {
				response.sendRedirect(request.getServletContext().getContextPath() + "/");
			} else {
				String userEmail = request.getParameter("email");
				String userPassword = request.getParameter("password");
				
				boolean isValid = MainUtils.isValidUser(userEmail, userPassword);
				
				if( isValid ) {
					session.setAttribute("email", userEmail);
					session.setAttribute("password", MainUtils.getPasswordHash(userPassword));
					response.sendRedirect(request.getServletContext().getContextPath() + "/bourses");
				} else {
					response.sendRedirect(request.getServletContext().getContextPath() + "/login?error");
				}
				
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
