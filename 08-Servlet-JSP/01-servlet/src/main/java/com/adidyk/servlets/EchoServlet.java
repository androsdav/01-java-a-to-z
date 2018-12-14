package com.adidyk.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 */
public class EchoServlet extends HttpServlet {

    /**
     *
     * @param request - is req.
     * @param response - is res.
     * @throws IOException - io exception.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append("<b>andros andros andros</b>").append("</br>").append("<b>").append(String.valueOf(new Date())).append("</b></b>");

        writer.flush();
        // https://proselyte.net/tutorials/servlets/filters/
        //https://www.tutorialspoint.com/servlets/index.htm
    }

}
