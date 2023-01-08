import java.sql.*;
import java.io.*;
import java.util.*;



public class EmpDao {
	public static Connection getConnection(){
		Connection con=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		}catch(Exception e){System.out.println(e);}
		return con;
}
	public static int insert(Emp e){
		int status=0;
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement
	("insert into userBean(name,password,email,sex,country,id)values(?,?,?,?,?,seq_userBean.nextval)");
			ps.setString(1,e.getName());
			ps.setString(2,e.getPassword());
			ps.setString(3,e.getEmail());
			ps.setString(4,e.getGender());
			ps.setString(5,e.getCountry());
			status=ps.executeUpdate();
			con.close();
		}
		catch(Exception x){x.printStackTrace();}
		return status;
		}
	public static List<Emp>getAllEmployee()
	{
		List<Emp>list=new ArrayList<Emp>();
		try{
			Connection con=getConnection();
			PreparedStatement ps=con.prepareStatement("select * from userBean");
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Emp u=new Emp();
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setGender(rs.getString("sex"));
				u.setCountry(rs.getString("country"));
				u.setId(rs.getInt("id"));
				list.add(u);
			}
			con.close();
		}
			catch(Exception e){e.printStackTrace();}
			return list;	
	}
	 public static int update(Emp e){  
	        int status=0;  
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement(  
	                         "update userBean set name=?,password=?,email=?,sex=?,country=? where id=?");
	            
	            ps.setString(1,e.getName());  
	            ps.setString(2,e.getPassword());  
	            ps.setString(3,e.getEmail()); 
	            ps.setString(4,e.getGender());
	            ps.setString(5,e.getCountry());  
	            ps.setInt(6,e.getId());  
	              
	            status=ps.executeUpdate();  
	              
	            con.close();  
	        }catch(Exception x){x.printStackTrace();}  
	          
	        return status;  
	    }  
	 public static Emp getEmployeeById(int id){  
	        Emp e=new Emp();  
	          
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement("select * from userBean where id=?");  
	            ps.setInt(1,id);  
	            ResultSet rs=ps.executeQuery();  
	            if(rs.next()){  
	            	e.setId(rs.getInt("id")); 
	            	e.setName(rs.getString("name"));
					e.setPassword(rs.getString("password"));
					e.setEmail(rs.getString("email"));
					e.setGender(rs.getString("sex"));
					e.setCountry(rs.getString("country"));
					
	            }  
	            con.close();  
	        }catch(Exception x){x.printStackTrace();}  
	          
	        return e;  
	        
	    }  
	 public static int delete(int id){  
	        int status=0;  
	        try{  
	            Connection con=getConnection();  
	            PreparedStatement ps=con.prepareStatement("delete from userBean where id=?");  
	            ps.setInt(1,id);  
	            status=ps.executeUpdate();  
	            con.close();  
	        }catch(Exception e){e.printStackTrace();}  
	          
	        return status;  
	    } 
}
