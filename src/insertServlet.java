

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class insertServlet
 */
@WebServlet("/insertServlet")
public class insertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html");
PrintWriter pw=response.getWriter();
String name=request.getParameter("name");
String password=request.getParameter("password");
String email=request.getParameter("email");
String country=request.getParameter("country");
String gender=request.getParameter("gender");
Emp e=new Emp();
e.setName(name);
e.setPassword(password);
e.setGender(gender);
e.setEmail(email);
e.setCountry(country);
int status=EmpDao.insert(e);
if(status!=0){
	pw.println("Record insert successfull");
}
else
{
	pw.println("Insertion Error");
}
pw.close();
	}
}
