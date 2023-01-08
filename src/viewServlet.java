import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/viewservlet")
public class viewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		List<Emp> li=EmpDao.getAllEmployee();
		pw.println("<table border='1' width='100%'");
		pw.println("<tr><th>Name</th><th>Email</th><th>Password</th><th>Gender</th><th>Country</th><th>id</th><th>edit</th><th>Delete</th></tr>");
		for(Emp e:li){
			pw.println("<tr><td>"+e.getName()+"</td><td>"+e.getEmail()+"</td><td>"+e.getPassword()+"</td>"
					+ "<td>"+e.getGender()+"</td><td>"+e.getCountry()+"</td><td>"+e.getId()+
					"</td><td><a href='editservlet?id="+e.getId()+"'>Edit</a></td><td><a href='deleteservlet?id="+e.getId()+"'>Delete</a></td></tr>");
		}
		pw.println("</table>");
		
		
		
	}

}