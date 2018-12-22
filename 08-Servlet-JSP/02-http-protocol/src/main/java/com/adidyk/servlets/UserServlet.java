package com.adidyk.servlets;

import com.adidyk.models.User;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class PostFormServlet uses form and method POST to enter name and surname and returns entered name and surname.
 * @author Didyk Andrey (androsdav@bigmir.net).
 * @since 19.12.2018.
 * @version 1.0.
 */
public class UserServlet extends HttpServlet {

    /**
     * @param formatter - formatter.
     */
    private Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

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
        User user = new User(1, "vova", "andros", "andros@bigmir.net", new Date());
        String string = "test";
        for (int index = 0; index < 10; index++) {
            writer.append(String.valueOf(user.getId())).append(user.getName()).append(user.getLogin()).append(formatter.format(user.getCreateDate())).append("</br>");
        }
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
