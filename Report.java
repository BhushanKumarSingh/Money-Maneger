

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Report
 */
public class Report extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report() {
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
		request.getRequestDispatcher("include.jsp").include(request, response);
		PrintWriter pr=response.getWriter();
		HttpSession session=request.getSession();
		
		/*String id1=(String) session.getAttribute("username");
		String id2=(String) session.getAttribute("password");
		
		LoginDAO ld=new LoginDAO();
		ArrayList a1=ld.income(id1,id2);
		
		Iterator itr=a1.iterator();
		itr.hasNext();
		ReportPoso rp=(ReportPoso) itr.next();
		float inc=rp.getSum();
		
		ArrayList a2=ld.expense(id1, id2);
		Iterator it=a2.iterator();
		it.hasNext();
		ReportPoso rpt=(ReportPoso) it.next();
		float exp=rpt.getSum();
		
		float rem=inc-exp;
		
		pr.println("<html><body><table border><th>Remaining</th>");
		pr.println("<tr><td>Income</td><td>"+inc+"</td></tr>");
		pr.println("<tr><td>Remaining</td><td>"+rem+"</td></tr>");
		pr.println("<tr><td>Expense</td><td>"+exp+"</td></tr>");
		pr.println("<tr></tr><tr><td>Balance</td><td>"+rem+"</td></tr>");
		pr.println("</table></body></html>");
		*/
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
