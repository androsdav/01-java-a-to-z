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
     * doGet - uses form and method POST to enter name and surname and returns entered name and surname.
     * @param request - request.
     * @param response - response.
     * @throws IOException - io exception.
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter writer = new PrintWriter(response.getOutputStream());
        writer.append(
                <!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="style.css">
        <meta charset="UTF-8">
        <title>02-http-protocol</title>
        <script type="text/javascript">
                function enableSelect(currentRadio){
            if(currentRadio.value === "add") {
                document.getElementById("add_user").disabled = false;
                document.getElementById("update_user").disabled = true;
                document.getElementById("delete_user").disabled = true;
            } else if (currentRadio.value === "update") {
                document.getElementById("add_user").disabled = true;
                document.getElementById("update_user").disabled = false;
                document.getElementById("delete_user").disabled = true;
            } else {
                document.getElementById("add_user").disabled = true;
                document.getElementById("update_user").disabled = true;
                document.getElementById("delete_user").disabled = false;
            }
        }
        </script>
    </head>
    <body>
    <div id="div_main">
        <div id="div_list">
            <table class="table_user">
                <tr>
                    <th>id</th>
                    <th>name</th>
                    <th>login</th>
                    <th>email</th>
                    <th>createDate</th>
                </tr>
                <tr>
                    <td>1</td>
                    <td>Bill</td>
                    <td>billy</td>
                    <td>billy@gmail.com</td>
                    <td>10.10.2018</td>
                </tr>
                <tr>
                    <td>2</td>
                    <td>Ben</td>
                    <td>benito dasd as da as as asas dam masm kamsk klaskl maskm aksldm</td>
                    <td>brnito@gmail.com</td>
                    <td>10.11.2018</td>
                </tr>
            </table>
        </div>
        <div id="div_action">
            <form action="action_user_servlet" method="POST">
                <fieldset>
                    <legend style="text-align: left"><b>CHOOSE ACTION</b></legend>
                    <!-- add user -->
                    <b>ADD USER</b><br/><hr>
                action: <label><input onclick="enableSelect(this)" type="radio" name="action" value="add" checked></label> add user<br/>
                    <fieldset class="fieldset_style" id="add_user">
                name: <label><input type="text" name="name" style="width: 137px" required></label><br/>
                login: <label><input type="text" name="login" style="width: 137px" required/></label><br/>
                email: <label><input type="text" name="email" style="width: 137px" required/></label><br/>
                    </fieldset>
                    <!-- update user -->
                    <b>UPDATE USER</b><br/><hr>
                action: <label><input onclick="enableSelect(this)" type="radio" name="action" value="update"></label> update user<br/>
                    <fieldset class="fieldset_style" id="update_user" disabled>
                id: <label><input type="text" name="id" style="width: 137px" required/></label><br/>
                name: <label><input type="text" name="name" style="width: 137px" required></label><br/>
                login: <label><input type="text" name="login" style="width: 137px" required/></label><br/>
                email: <label><input type="text" name="email" style="width: 137px" required/></label><br/>
                    </fieldset>
                    <!-- delete user -->
                    <b>DELETE USER</b><br/><hr>
                action: <label><input onclick="enableSelect(this)" type="radio" name="action" value="delete"></label> delete user<br/>
                    <fieldset class="fieldset_style" id="delete_user" disabled>
                id: <label><input type="text" name="id" style="width: 137px" required/></label><br/>
                    </fieldset>
                    <!-- submit -->
                    <hr>
                    <fieldset style="border:0 none">
                        <input type="submit" value="Submit"/><br/>
                    </fieldset>
                </fieldset>
            </form>
        </div>
    </div>
    </body>
</html>
        );
        /*
        User user = new User("vova", "andros", "andros@bigmir.net", new Date());
        String string = "test";
        for (int index = 0; index < 10; index++) {
            writer.append(String.valueOf(user.getId())).append(user.getName()).append(user.getLogin()).append(formatter.format(user.getCreateDate())).append("</br>");
        }

        User bob = new User("bob", "bobby", "bob@bigmir.net", new Date());
        //User bill = new User("bill", "bill", "bill@bigmir.net", new Date());
        //User adam = new User("adam", "ad", "ad@bigmir.net", new Date());
        //User albert = new User("albert", "albert007", "albert@bigmir.net", new Date());
        this.logic.add(bob);
        //this.logic.add(bill);
        //this.logic.add(adam);
        //this.logic.add(albert);
        System.out.println(" all user start");
        for (User item : this.logic.findAll()) {
            System.out.println(item);
        }
        System.out.println(" all user finish");
        writer.flush();
        */
    }

    /*
    /**
     * doPost - returns entered name and surname.
     * @param request - request.
     * @param response - response.
     * @throws IOException - io exception.
     */
    //@Override
    /*
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //this.doGet(request, response);
    }
    */

}
