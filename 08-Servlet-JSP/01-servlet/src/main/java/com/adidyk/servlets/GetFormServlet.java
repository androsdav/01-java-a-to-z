package com.adidyk.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class GetFormServlet extends HttpServlet {

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
        //String date = String.valueOf(new Date());
        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<title>01-servlet</title>" +
                "<style>" +
                ".table_style {" +
                "margin: 50px;" +
                "border: 1px solid #000000;" +
                "border-collapse: collapse;" +
                "background: beige;" +
                "color: black;" +
                "}" +
                "TD, TH {" +
                "padding: 10px;" +
                "border: 2px solid #000000;" +
                "text-align: center;" +
                "}" +
                "TH {" +
                "background: darkorange;" +
                "}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<table class =\"table_style\">" +
                "<tr>" +
                "<th>#</th>" +
                "<th>servlets</th>" +
                "<th>description</th>" +
                "<th>link</th>"+
                "<th>response</th>"+
                "</tr>" +
                "<tr>" +
                "<td>1</td>" +
                "<td>GetFormServlet</td>" +
                    "<td style=\"width: auto\">Uses form and method GET to enter name and surname and returns entered name and surname</td>" +
                    "<td><a href=\"index.html\">back</a></td>" +
                    "<td>" +
                        "name:" + request.getParameter("name") + "</br>" +
                        "surname:" + request.getParameter("surname") +
                    "</td>" +
                "</tr>" +
                "</table>" +
                "</body>" +
                "</html>"
        );
        writer.flush();
    }

}
