package com.practica.servlet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author maria
 */
@WebServlet(name = "ProcesarServlet", urlPatterns = {"/ProcesarServlet"})
public class ProcesarServlet extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String metodo)
        throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nombre = request.getParameter("txtNombre");
        String correo = request.getParameter("txtCorreo");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<html><body>");
            out.println("<h1>Datos Recibidos en el BackEnd</h1>");
            out.println("<p><b>Método:</b> " + metodo + "</p>");
            out.println("<p><b>Nombre:</b> " + nombre + "</p>");
            out.println("<p><b>Correo:</b> " + correo + "</p>");
            out.println("</body></html>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
    IOException {
        processRequest(req, resp, "GET");
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException,
    IOException {
        processRequest(req, resp, "POST");
    }
}