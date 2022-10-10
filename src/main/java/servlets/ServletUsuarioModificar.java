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
@WebServlet("/ServletUsuarioModificar")
public class ServletUsuarioModificar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuarioModificar() {
        super();
        // TODO Auto-generated constructor stub
    }

                /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
        
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
           UsuarioController user = new UsuarioController();
            int user_id = Integer.parseInt(request.getParameter("user_id"));
            String user_password = request.getParameter("user_password");
            String user_name = request.getParameter("user_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            String location_user = request.getParameter("location_user");
            

               
            String userInt = user.modificar(user_id, user_password, user_name, last_name,
                                            email, location_user);
            PrintWriter out = response.getWriter();
            out.println(userInt);
            out.flush();
            out.close();
        }
}