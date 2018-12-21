package com.adidyk.servlets;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Class GetServlet used method doGet for outputs some information about date.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 19.12.2018.
 * @version 1.0.
 */
public class GetServlet extends HttpServlet {

    /**
     * doGet - outputs some information about date.
     * @param request - request.
     * @param response - response.
     * @throws IOException - io exception.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        String date = String.valueOf(new Date());
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
                                "<td>1</td>" +
                                "<td>GetServlet</td>" +
                                "<td class=\"td_form_style\">Outputs some information about date</td>" +
                                "<td><a href=\"index.html\">back</a></td>" +
                                "<td>" + "date now:" + date + "</td>" +
                            "</tr>" +
                        "</table>" +
                    "</body>" +
                "</html>"
        );
        writer.flush();
    }

}