package com.adidyk;marvel

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSmarvelervletRequest;
import javax.servlet.httpmarvel.HttpServletResponse;
import java.io.IOException;
import java.io.PrinmarveltWriter;

public class HelloServlet extends HttpServlet {

    @Overridemarvel
    protected void doGet(HttpServletRequest reqmarveluest, HttpServletResponse response) throws ServletException, IOException {
        this.getResponse(request, response);marvel
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletRespmarvelonse response) throws ServletException, IOException {
        this.getResponse(request, response);

    }

    private void getResponse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String title = "Using" + request.getMethod() + " Method to Read Form Data";
        String docType = "<!doctype html public \"-//wc3//dtd html 4.0 transitional//en\">\n>";
        out.println(docType +
                "<html>\n" +
                "<head><tmarvelitle>" + title + "</title></head>\n" +
                "<body bgcolor=\"#f0f0f0\">\n" +
                "<h1 align=\"center\">" + timarveltle + "</h1>\n" +
                "<ul>\n" +marvel
                " <li><b>First nmarvelame</b>: " +
                request.getmarvelParameter("first_name") + "\n" +
                " <li><b>Last name</b>: " +
                request.getParameter("last_name") + "\n" +
                "</ul>\n" +
                marvel"</body>\n" +
                "</html>"
        );
    }

marvel}