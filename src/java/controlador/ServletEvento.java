/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelos.Administrador;
import modelos.Evento;
import modelos.Usuario;

/**
 *
 * @author valentina
 */
@WebServlet(name = "ServletEvento", urlPatterns = {"/ServletEvento"})
public class ServletEvento extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();

        //Obtener los datos en session
        List<Usuario> usuarios = new ArrayList<>();
        List<Administrador> administradores = new ArrayList<>();
        List<Evento> eventos = new ArrayList<>();

        if (null != session.getAttribute("ListaUsuarios")) {
            usuarios = (ArrayList<Usuario>) session.getAttribute("ListaUsuario");
        }

        if (null != session.getAttribute("ListaAdministrador")) {
            administradores = (ArrayList<Administrador>) session.getAttribute("ListaAdministrador");
        }
        if (null != session.getAttribute("ListaEvento")) {
            eventos = (ArrayList<Evento>) session.getAttribute("ListaEvento");
        }

        if ("Crear".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("/CrearEvento.jsp");
            view.forward(request, response);
        }else if("VerEventos".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("/VerEventos.jsp");
            view.forward(request, response);
        }
        else if("ConsultaEventoCod".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("/ConsultaEventoCod.jsp");
            view.forward(request, response);
        }
        else if("ConsultaEventoNombre".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("/ConsultaEventoNombre.jsp");
            view.forward(request, response);
        }else if ("EventoMasBoletas".equals(request.getParameter("accion"))){
            
        }else if ("EventoMenosBoletas".equals(request.getParameter("accion"))){
            
        }else if ("EventoBoletaCara".equals(request.getParameter("accion"))){
            
        }else if ("EventoBoletaBarata".equals(request.getParameter("accion"))){
            
        }else if ("VerCategoria".equals(request.getParameter("accion"))){
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        session.setAttribute("usuarioLogueado", null);

        //Obtener los datos en session
        List<Usuario> usuarios = new ArrayList<>();
        List<Administrador> administradores = new ArrayList<>();
        List<Evento> eventos = new ArrayList<>();

        if (null != session.getAttribute("ListaUsuarios")) {
            usuarios = (ArrayList<Usuario>) session.getAttribute("ListaUsuario");
        }

        if (null != session.getAttribute("ListaAdministrador")) {
            administradores = (ArrayList<Administrador>) session.getAttribute("ListaAdministrador");
        }
        if (null != session.getAttribute("ListaEvento")) {
            eventos = (ArrayList<Evento>) session.getAttribute("ListaEvento");
        }

      

}

}