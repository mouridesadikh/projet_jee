package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Facade.Login_Facade;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ins =(String) request.getParameter("ins");
		if(ins==null)
		{
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}else if(ins.equals("logout"))
		{
			HttpSession session = request.getSession();
			session.invalidate();
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		HttpSession session = request.getSession();
		if(type.equals("Admin"))
		{
			if(email.equals("mouride@gmail.com") && password.equals("passer"))
			{
				 session.setAttribute("type", type);
				 this.getServletContext().getRequestDispatcher("/WEB-INF/hom/home.jsp").forward(request, response);
			}else {
				request.setAttribute("message", "Login ou Mot de passe incorrect");
				this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			}
		}else {
			try {
				String typeR = Login_Facade.verifLogin(email, password,type);
			    System.out.print(typeR);
				if(typeR!=null)
				{
					
					
				
					
			        session.setAttribute("type", type);
			
					
			        this.getServletContext().getRequestDispatcher("/WEB-INF/hom/home.jsp").forward(request, response);
				}else {
					request.setAttribute("message", "Login ou Mot de passe incorrect");
					this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
