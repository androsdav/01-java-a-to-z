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
     * @param req - is req.
     * @param res - is res.
     * @throws IOException - io exception.
     */
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter writer = new PrintWriter(res.getOutputStream());
        writer.append("<b>hello world</b>").append("</br>").append("<b>").append(String.valueOf(new Date())).append("</b>");
        writer.flush();
    }
}
