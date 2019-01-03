package com.adidyk.servlets;

import com.adidyk.logic.Validate;
import com.adidyk.logic.ValidateService;
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

    private final ValidateService logic = new ValidateService();

    /**
     *
     * @param writer - writer.
     */
    private static void test(PrintWriter writer) {
        writer.append(
                "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                    "<head>" +
                        "<link rel=\"stylesheet\" href=\"style.css\">" +
                        "<meta charset=\"UTF-8\">" +
                        "<title>02-http-protocol</title>" +
                        "<script type=\"text/javascript\">" +
                            "function enableSelect(currentRadio){" +
                                "if(currentRadio.value === \"add\") {" +
                                    "document.getElementById(\"add_user\").disabled = false;" +
                                    "document.getElementById(\"update_user\").disabled = true;" +
                                    "document.getElementById(\"delete_user\").disabled = true;" +
                                "} else if (currentRadio.value === \"update\") {" +
                                    "document.getElementById(\"add_user\").disabled = true;" +
                                    "document.getElementById(\"update_user\").disabled = false;" +
                                    "document.getElementById(\"delete_user\").disabled = true;" +
                                "} else {" +
                                    "document.getElementById(\"add_user\").disabled = true;" +
                                    "document.getElementById(\"update_user\").disabled = true;" +
                                    "document.getElementById(\"delete_user\").disabled = false;" +
                                "}" +
                            "}" +
                        "</script>" +
                    "</head>" +
                    "<body>" +
                    "<div id=\"div_main\">" +
                        "<div id=\"div_list\">" +
                            "<table class=\"table_user\">" +
                                "<tr>" +
                                    "<th>id</th>" +
                                    "<th>name</th>" +
                                    "<th>login</th>" +
                                    "<th>email</th>" +
                                    "<th>createDate</th>" +
                                "</tr>");
    }

    /**
     *
     * @param writer - writer.
     */
    private static void test1(PrintWriter writer) {
        writer.append(
                            "</table>" +
                        "</div>" +
                        "<div id=\"div_action\">" +
                            "<form action=\"action_user_servlet\" method=\"POST\">" +
                                "<fieldset>" +
                                    "<legend style=\"text-align: left\"><b>CHOOSE ACTION</b></legend>" +
                                    "<!-- add user -->" +
                                    "<b>ADD USER</b><br/><hr>" +
                                    "action: <label><input onclick=\"enableSelect(this)\" type=\"radio\" name=\"action\" value=\"add\" checked></label> add user<br/>" +
                                    "<fieldset class=\"fieldset_style\" id=\"add_user\">" +
                                        "name: <label><input type=\"text\" name=\"name\" style=\"width: 137px\" required></label><br/>" +
                                        "login: <label><input type=\"text\" name=\"login\" style=\"width: 137px\" required/></label><br/>" +
                                        "email: <label><input type=\"text\" name=\"email\" style=\"width: 137px\" required/></label><br/>" +
                                    "</fieldset>" +
                                    "<!-- update user -->" +
                                    "<b>UPDATE USER</b><br/><hr>" +
                                    "action: <label><input onclick=\"enableSelect(this)\" type=\"radio\" name=\"action\" value=\"update\"></label> update user<br/>" +
                                    "<fieldset class=\"fieldset_style\" id=\"update_user\" disabled>" +
                                        "id: <label><input type=\"text\" name=\"id\" style=\"width: 137px\" required/></label><br/>" +
                                        "name: <label><input type=\"text\" name=\"name\" style=\"width: 137px\" required></label><br/>" +
                                        "login: <label><input type=\"text\" name=\"login\" style=\"width: 137px\" required/></label><br/>" +
                                        "email: <label><input type=\"text\" name=\"email\" style=\"width: 137px\" required/></label><br/>" +
                                    "</fieldset>" +
                                    "<!-- delete user -->" +
                                    "<b>DELETE USER</b><br/><hr>" +
                                    "action: <label><input onclick=\"enableSelect(this)\" type=\"radio\" name=\"action\" value=\"delete\"></label> delete user<br/>" +
                                    "<fieldset class=\"fieldset_style\" id=\"delete_user\" disabled>" +
                                        "id: <label><input type=\"text\" name=\"id\" style=\"width: 137px\" required/></label><br/>" +
                                    "</fieldset>" +
                                    "<!-- submit -->" +
                                    "<hr>" +
                                    "<fieldset style=\"border:0 none\">" +
                                        "<input type=\"submit\" value=\"Submit\"/><br/>" +
                                    "</fieldset>" +
                                "</fieldset>" +
                            "</form>" +
                        "</div>" +
                     "</div>" +
                     "</body>" +
                 "</html>"
        );
    }

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
        test(writer);
        for (User item : this.logic.findAll()) {
            writer.append(
                                "<tr>" +
                                    "<td>" + item.getId() + "</td>" +
                                    "<td>" + item.getName() + "</td>" +
                                    "<td>" + item.getLogin() + "</td>" +
                                    "<td>" + item.getEmail() + "</td>" +
                                    "<td>" + formatter.format(item.getCreateDate()) + "</td>" +
                                "</tr>"
            );
        }
        test1(writer);
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
        User bob = new User("bob", "bobby", "bob@bigmir.net", new Date());
        User bill = new User("bill", "bill", "bill@bigmir.net", new Date());
        User adam = new User("adam", "ad", "ad@bigmir.net", new Date());
        User albert = new User("albert", "albert007", "albert@bigmir.net", new Date());
        this.logic.add(bob);
        this.logic.add(bill);
        this.logic.add(adam);
        this.logic.add(albert);
        this.doGet(request, response);
    }


}
