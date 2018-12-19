package com.adidyk.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Class PostFormServlet uses form and method POST to enter name and surname and returns entered name and surname.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 19.12.2018.
 * @version 1.0.
 */
public class PostFormServlet extends HttpServlet {

    /**
     * doGet - uses form and method POST to enter name and surname and returns entered name and surname.
     * @param request - request.
     * @param response - response.
     * @throws IOException - io exception.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append("<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                    "<head>" +
                        "<link rel=\"stylesheet\" href=\"style.css\">" +
                        "<meta charset=\"UTF-8\">" +
                        "<title>01-servlet</title>" +
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
                                "<td>3</td>" +
                                "<td>GetFormServlet</td>" +
                                "<td class=\"td_form_style\">Uses form and method POST to enter name and surname and returns entered name and surname</td>" +
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

    /**
     * doPost - returns entered name and surname.
     * @param request - request.
     * @param response - response.
     * @throws IOException - io exception.
     */
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }

}