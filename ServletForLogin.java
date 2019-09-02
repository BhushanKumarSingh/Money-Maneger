

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServletForLogin
 */
public class ServletForLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ServletForLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pr=response.getWriter();
		
		String username =request.getParameter("username");
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String rpassword=request.getParameter("rpassword");
		
		HttpSession session=request.getSession();
		session.setAttribute("email", email);
		
		if(!password.equals(rpassword))
		{
			
			pr.println("<script> alert('Your password is not match....')</script");
			request.getRequestDispatcher("SignUp_Form.html").include(request,response);
		}
		else
		{
			LoginPoso lp=new LoginPoso();
			lp.setUsername(username);
			lp.setEmail(email);
			lp.setPassword(password);
			lp.setRpassword(rpassword);
			
			LoginDAO ld=new LoginDAO();
			int n=ld.createForm(lp);
			if (n>0)
			{
				//pr.println("Your Id Is Created Please Login Your Account....");
				pr.println("<script> alert('Your Id Is Created Please Login Your Account....')</script");
				request.getRequestDispatcher("Login_Form.html").include(request,response);
				
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
