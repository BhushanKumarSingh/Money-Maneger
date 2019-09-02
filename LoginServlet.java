

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
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
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pr=response.getWriter();
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginPoso lp=new LoginPoso();
		lp.setUsername(username);
		lp.setPassword(password);
		
		HttpSession session=request.getSession();
		session.setAttribute("email", username);
		session.setAttribute("password", password);

		LoginDAO ld=new LoginDAO();
		int n=ld.login(username,password);
		if(n>0)
		{
			request.getRequestDispatcher("include.jsp").forward(request, response);
		}
		else
		{
			pr.println("<script> alert('Please Enter Correct Username And Password..')</script");
			request.getRequestDispatcher("Login_Form.html").include(request, response);
			
			//pr.println("Please Enter Correct Username And Password");
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
