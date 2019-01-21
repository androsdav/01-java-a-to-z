package com.adidyk.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DoPostServlet extends HttpServlet {

    /**
     * time X
     * @param request - is req.
     * @param response - is res.
     * @throws IOException - io exception.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String title = "Passing parameters using POST method";
        String docType = "<!DOCTYPE html>";

        writer.println("<html>" +
                "<head><title>" + title + "</title></head>\n" +
                "<body><h2>Specialty: </h2>" + request.getParameter("specialty") +
                "<h2>Experience: </h2>" + request.getParameter("experience")
                + "</body>" +
                "</html>");
    }

    /**
     *
     * @param request - is req.
     * @param response - is res.
     * @throws IOException - io exception.
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

}
