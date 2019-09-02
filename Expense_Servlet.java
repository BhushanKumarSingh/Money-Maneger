

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Expense_Servlet
 */
public class Expense_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Expense_Servlet() {
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
		
		String expense=request.getParameter("expense");
		String mode=request.getParameter("mode");
		String category=request.getParameter("category");
		String description=request.getParameter("description");
		String date=request.getParameter("date");
		String time=request.getParameter("time");
		
		ExpensePoso ip=new ExpensePoso();
		ip.setExpense(expense);
		ip.setMode(mode);
		ip.setDescription(description);
		ip.setCategory(category);
		ip.setDate(date);
		ip.setTime(time);
		
		LoginDAO ld=new LoginDAO();
		int n=ld.addExpense(ip);
		System.out.println(n);
		if(n>0)
			request.getRequestDispatcher("include.jsp").forward(request,response);
		else
			request.getRequestDispatcher("SomeThing.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
