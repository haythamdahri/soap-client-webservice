package com.action.controllers;

import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.action.service.PriceActionServiceImplStub.Action;
import com.action.service.PriceActionServiceImplStub.Bourse;
import com.action.utils.MainUtils;

@WebServlet("/dashboard")
public class DashboardController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) {

		try {
			// Catch error paramameters
			String error = request.getParameter("error");

			// Check if user is connected
			HttpSession session = request.getSession();

			// Requested page on dashboard
			// Add action | update action | delete action | list actions | Add bourse |
			// update bourse | delete bourse | list bourses
			String addAction = request.getParameter("addAction");
			String updateAction = request.getParameter("updateAction");
			String deleteAction = request.getParameter("deleteAction");
			String actionPage = request.getParameter("actionPage");

			String addBourse = request.getParameter("addBourse");
			String updateBourse = request.getParameter("updateBourse");
			String deleteBourse = request.getParameter("deleteBourse");
			String boursePage = request.getParameter("boursePage");

			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");

			// Rendered html
			String renderedHtml = "";

			// Redirect use to the login page if not connected
			if (email == null || password == null) {
				response.sendRedirect(request.getServletContext().getContextPath() + "/login");
			} else {
				// One parameter at least is required

				if (addAction != null) {
					renderedHtml = MainUtils.getRenderedActionForm(null, email, null);
				} else if (updateAction != null) {
					Long id = Long.parseLong(updateAction);
					renderedHtml = MainUtils.getRenderedActionForm(id, email, null);

				} else if (deleteAction != null) {

				} else if (actionPage != null) {
					// Display success message if operation done successflly
					String success = request.getParameter("success") != null ? "Opération éffectuée avec succé!" : null;
					renderedHtml = MainUtils.getAdminRenderedActions(email, success, null);
				} else if (addBourse != null) {
					renderedHtml = MainUtils.getRenderedBourseForm(null, email, null);
				} else if (updateBourse != null) {
					Long id = Long.parseLong(updateBourse);
					renderedHtml = MainUtils.getRenderedBourseForm(id, email, null);

				} else if (deleteBourse != null) {

				} else if (boursePage != null) {
					// Display success message if operation done successflly
					String success = request.getParameter("success") != null ? "Opération éffectuée avec succé!" : null;
					renderedHtml = MainUtils.getAdminRenderedBourses(email, success, null);
				} else {
					response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?boursePage");
				}

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
			// Catch error paramameters
			String error = request.getParameter("error");

			// Check if user is connected
			HttpSession session = request.getSession();

			// Requested page on dashboard
			// Add action | update action | delete action | list actions | Add bourse |
			// update bourse | delete bourse | list bourses
			String addAction = request.getParameter("addAction");
			String updateAction = request.getParameter("updateAction");
			String deleteAction = request.getParameter("deleteAction");
			String actionPage = request.getParameter("actionPage");

			String addBourse = request.getParameter("addBourse");
			String updateBourse = request.getParameter("updateBourse");
			String deleteBourse = request.getParameter("deleteBourse");
			String boursePage = request.getParameter("boursePage");

			String email = (String) session.getAttribute("email");
			String password = (String) session.getAttribute("password");

			// Rendered html
			String renderedHtml = "";

			// Redirect use to the login page if not connected
			if (email == null || password == null) {
				response.sendRedirect(request.getServletContext().getContextPath() + "/login");
			} else {
				// One parameter at least is required

				if (addAction != null) {

					
					Action persistedAction = new Action();
					String name=  request.getParameter("name").trim();
					String openingAmount=  request.getParameter("openingAmount").trim();
					String closingAmount=  request.getParameter("closingAmount").trim();
					String bourse = request.getParameter("bourse").trim();
					String dateStr = request.getParameter("date");
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);  
					persistedAction.setName(name);
					persistedAction.setOpeningAmount(Double.parseDouble(openingAmount));
					persistedAction.setClosingAmount(Double.parseDouble(closingAmount));
					persistedAction.setDate(date);
					persistedAction.setBourseId(Long.parseLong(bourse));
					
					boolean persisted = MainUtils.persistAction(persistedAction);
					if( persisted ) {
						response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?actionPage&success");
					} else {
						Long actionId = Long.parseLong(addBourse);
						renderedHtml = MainUtils.getRenderedActionForm(null, email, "Données invalides!");
					}
					return;
					
				} else if (updateAction != null) {
					
					String id = request.getParameter("id").trim();
					String name=  request.getParameter("name").trim();
					String openingAmount=  request.getParameter("openingAmount").trim();
					String closingAmount=  request.getParameter("closingAmount").trim();
					String bourse = request.getParameter("bourse").trim();
					String dateStr = request.getParameter("date");
					Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);  
					Action updatedAction = new Action();
					updatedAction.setId(id);
					updatedAction.setName(name);
					updatedAction.setOpeningAmount(Double.parseDouble(openingAmount));
					updatedAction.setClosingAmount(Double.parseDouble(closingAmount));
					updatedAction.setDate(date);
					updatedAction.setBourseId(Long.parseLong(bourse));
					
					boolean updated = MainUtils.updateAction(updatedAction);
					if( updated ) {
						response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?actionPage&success");
						return;
					} else {
						Long actionId = Long.parseLong(id);
						renderedHtml = MainUtils.getRenderedActionForm(actionId, email, "Données invalides!");
					}

				} else if (deleteAction != null) {

					String actionId = request.getParameter("id");
					boolean deleted = MainUtils.deleteAction(Long.parseLong(actionId));
					if( deleted ) {
						response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?actionPage&success");
						return;
					} else {
						renderedHtml = MainUtils.getAdminRenderedBourses(email, null, "Une erreur est survenue, veuillez ressayer!");
					}
					
					
				} else if (actionPage != null) {

				} else if (addBourse != null) {

					String name=  request.getParameter("name").trim();
					Bourse persistedBourse = new Bourse();
					persistedBourse.setName(name);;
					
					boolean persisted = MainUtils.persistBourse(persistedBourse);
					if( persisted ) {
						response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?boursePage&success");
					} else {
						Long bourseId = Long.parseLong(addBourse);
						renderedHtml = MainUtils.getRenderedBourseForm(null, email, "Données invalides!");
					}
					return;
					
				} else if (updateBourse != null) {
					String id = request.getParameter("id").trim();
					String name=  request.getParameter("name").trim();
					Bourse updatedBourse = new Bourse();
					updatedBourse.setId(id);
					updatedBourse.setName(name);;
					
					boolean updated = MainUtils.updateBourse(updatedBourse);
					if( updated ) {
						response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?boursePage&success");
						return;
					} else {
						Long bourseId = Long.parseLong(id);
						renderedHtml = MainUtils.getRenderedBourseForm(bourseId, email, "Données invalides!");
					}

				} else if (deleteBourse != null) {
					
					String bourseId = request.getParameter("id");
					boolean deleted = MainUtils.deleteBourse(Long.parseLong(bourseId));
					if( deleted ) {
						response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?boursePage&success");
						return;
					} else {
						renderedHtml = MainUtils.getAdminRenderedBourses(email, null, "Une erreur est survenue, veuillez ressayer!");
					}
					

				} else if (boursePage != null) {
					renderedHtml = MainUtils.getAdminRenderedBourses(email, null, null);
				} else {
					response.sendRedirect(request.getServletContext().getContextPath() + "/dashboard?boursePage");
				}

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
