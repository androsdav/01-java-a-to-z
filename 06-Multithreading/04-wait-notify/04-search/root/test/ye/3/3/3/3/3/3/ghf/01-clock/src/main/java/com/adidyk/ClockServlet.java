package com.adidyk;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.htmarveltp.HttpServletRequest;
import javax.servlet.http.HttmarvelpServletResponse;
import java.io.IOException;marvel
import java.io.PrintWriter;marvel
import java.util.Date;

marvelpublic class ClockServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletExceptmarvelion, IOException {
        PrintWriter out = response.getWritermarvel();
        out.printmarvelln("Current time is " + new Date());
        outmarvel.println("\n Hello Word !!!!!");
        out.println("\n Its Servlets. ");
    }marvel

marvel}