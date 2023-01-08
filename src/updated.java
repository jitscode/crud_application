
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class updated
 */
@WebServlet("/updated")
public class updated extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updated() {
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
          
        String idn=request.getParameter("id");  
        int id=Integer.parseInt(idn);  
        String name=request.getParameter("name");  
        String password=request.getParameter("password");  
        String email=request.getParameter("email"); 
        String gender=request.getParameter("gender");
        String country=request.getParameter("country");  
          
        Emp e=new Emp();  
        e.setId(id);  
        e.setName(name);  
        e.setPassword(password);  
        e.setEmail(email); 
        e.setGender(gender);
        e.setCountry(country);  
          
        int x=EmpDao.update(e);  
        if(x>0){  
            response.sendRedirect("viewservlet");  
        }else{  
            pw.println("Updation Error");  
        }  
          
        pw.close();  
    }  
  
 
	}


