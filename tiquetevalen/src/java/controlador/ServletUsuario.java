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
import modelos.*;

/**
 *
 * @author valentina
 */
@WebServlet(name = "ServletUsuario", urlPatterns = {"/ServletUsuario"})
public class ServletUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String accion = request.getParameter("accion");
        HttpSession session = request.getSession();
        session.setAttribute("usuarioLogueado", null);

        //Obtener los datos en session
        List<Usuario> usuarios = new ArrayList<>();
        List<Administrador> administradores = new ArrayList<>();

        if (null != session.getAttribute("listaUsuarios")) {
            usuarios = (ArrayList<Usuario>) session.getAttribute("listaUsuarios");
        }

        if (null != session.getAttribute("SEstudiante")) {
            administradores = (ArrayList<Administrador>) session.getAttribute("listaAdministradores");
        }

        if ("solicitarLogueo".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("/login.jsp");
            view.forward(request, response);

        } else if ("DatosFicticios".equals(accion)) {
            datosFicticios datosF = new datosFicticios();
            datosF.agregarDatosFicticios();
            session.setAttribute("ListaUsuario", Usuario.usuarios);
            session.setAttribute("ListaAdministrador", Administrador.administradores);
            session.setAttribute("ListaEventos", Evento.listaEventos);
            request.setAttribute("ListaUsuario", Usuario.usuarios);
            request.setAttribute("ListaAdministrador", Administrador.administradores);
            request.setAttribute("ListaEventos", Evento.listaEventos);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);

        } else if ("solicitarRegistro".equals(request.getParameter("accion"))) {
            RequestDispatcher view = request.getRequestDispatcher("/signin.jsp");
            view.forward(request, response);
        } else if ("Ver todos los usuarios".equals(request.getParameter("accion"))) {
            request.setAttribute("listaUsuario", usuarios);
            RequestDispatcher view = request.getRequestDispatcher("verUsuarios.jsp");
            view.forward(request, response);

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

        if (null != session.getAttribute("listaUsuarios")) {
            usuarios = (ArrayList<Usuario>) session.getAttribute("listaUsuarios");
        }

        if (null != session.getAttribute("SEstudiante")) {
            administradores = (ArrayList<Administrador>) session.getAttribute("listaAdministradores");
        }

        if ("Ingresar".equals(request.getParameter("accion"))) {
            String email = request.getParameter("email");
            String clave = request.getParameter("clave");
            for (Usuario usuario : usuarios) {
                if (email.equals(usuario.getEmail()) && clave.equals(usuario.getClave())) {
                    session.setAttribute("usuarioLogueado", usuario);
                    request.setAttribute("usuarioLogueado", usuario);
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.forward(request, response);
                }
            }

            for (Administrador admin : administradores) {
                if (email.equals(admin.getEmail()) && clave.equals(admin.getClave())) {
                    session.setAttribute("usuarioLogueado", admin);
                    request.setAttribute("usuarioLogueado", admin);
                    RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
                    view.forward(request, response);
                }
            }
            if (session.getAttribute("usuarioLogueado") == null) {
                RequestDispatcher view = request.getRequestDispatcher("/Error.jsp");
                view.forward(request, response);
            }

        } else if ("registrarse".equals(request.getParameter("accion"))) {
            String nombreR = request.getParameter("nombreR");
            String emailR = request.getParameter("emailR");
            String documentoR = request.getParameter("documentoR");
            String celularR = request.getParameter("celularR");
            String claveR = request.getParameter("claveR");
            Usuario registrado = new Usuario(emailR, claveR, documentoR, nombreR, celularR);
            Usuario.usuarios.add(registrado);
            session.setAttribute("usuarioLogueado", registrado);
            request.setAttribute("usuarioLogueado", registrado);
            RequestDispatcher view = request.getRequestDispatcher("/index.jsp");
            view.forward(request, response);
        }

    }

}
