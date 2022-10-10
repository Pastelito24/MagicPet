package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.UsuarioController;

/**
 * Servlet implementation class ServletUsuarioPedir
 */
@WebServlet("/ServletUsuarioEliminar")
public class ServletUsuarioEliminar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioEliminar() {
        super();
        // TODO Auto-generated constructor stub
    }

                /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            UsuarioController user = new UsuarioController();

            int user_id = Integer.parseInt(request.getParameter("id"));

            String userInt = user.eliminar(user_id);
            PrintWriter out = response.getWriter();
            out.println(userInt);
            out.flush();
            out.close();
        }
}