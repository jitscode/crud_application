

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class editServlet
 */
@WebServlet("/editServlet")
public class editServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editServlet() {
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
        String idn=request.getParameter("id");  
        int id=Integer.parseInt(idn);    
        Emp e=EmpDao.getEmployeeById(id); 
        pw.println("<h1>Update Employee</h1>");
		pw.println("<form action='updated' method='post'>");
		pw.println("<table style='colour:red; margin-left:auto; margin-right:auto; margin-bottom:auto; margin-top:auto'>");
        pw.println("<tr><td>ID:</td><td><input type='text' name='id' value='"+e.getId()+"'/></td></tr>");  
        pw.println("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");  
        pw.println("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");  
        pw.println("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");  
        pw.println("<tr><td>Gender:</td><td><input type='radio' name='gender' value='male'>Male<input type='radio' name='gender'value='female'>Female</td></tr>");
        pw.println("<tr><td>Country:</td><td>");  
        pw.println("<select name='country' style='width:150px' value='"+e.getCountry()+"'>");  
        pw.println("<option>India</option>");  
        pw.println("<option>USA</option>");  
        pw.println("<option>Russia</option>");  
        pw.println("<option>Japan</option>");  
        pw.println("</select></td></tr>");  
        pw.println("<tr><td><input type='submit' value='Edit Data'/></td></tr>");  
        pw.println("</table></form>");  
        pw.close();
          
	}

}
