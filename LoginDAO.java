import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

public class LoginDAO {

	public int createForm(LoginPoso lp)
	{
		int n=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=con.prepareStatement("insert into SignUp values (?,?,?,signup_seq.nextval)");
			ps.setString(1,lp.getUsername());
			ps.setString(2, lp.getEmail());
			ps.setString(3, lp.getPassword());
			//String s="signup_seq.nextval";
			//ps.setString(4,s);
			n=ps.executeUpdate();
		
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return n;
		
		
	}

	public int login(String element1,String element2) {
		int n=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=con.prepareStatement("select *from SignUp where email=? and Password=?");
			ps.setString(1, element1);
			ps.setString(2, element2);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				n=1;
			}
			
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return n;
		
	}
	public float income(String id1, String id2)
	{
		float a1 = 0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=con.prepareStatement("select sum(income) as sum from income where username=? and password=?  ");
			ps.setString(1, id1);
			ps.setString(2, id2);
			ResultSet rs=ps.executeQuery();
			rs.next();
			a1=Float.parseFloat(rs.getString(1));
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return a1;
	}
	public float expense(String id1,String id2)
	{
		float a2=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			PreparedStatement ps=con.prepareStatement("select sum(expense) as sum from expense where username=? and password=?");
			ps.setString(1, id1);
			ps.setString(2, id2);
			ResultSet rs=ps.executeQuery();
			rs.next();
			a2=Float.parseFloat(rs.getString(1));
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return a2;
	}
	public int addIncome(Income_Poso ip)
	{
		int n=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
			PreparedStatement ps=con.prepareStatement("insert into income_cash values(income_cash_seq.nextval,?,?,'09-nov-2019',?)");
			ps.setString(1, ip.getEmail());
			ps.setString(2,ip.getIncome());
			//ps.setString(3,ip.getDate());
			ps.setString(3, ip.getDescription());
			
			n=ps.executeUpdate();
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return n;
	}
	public int addExpense(ExpensePoso ip)
	{
		int n=0;
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","system");
			
			PreparedStatement ps=con.prepareStatement("insert into expense values(?,?,?,?,?,?,?,?)");
			ps.setString(1, ip.getExpense());
			ps.setString(2, ip.getMode());
			ps.setString(3, ip.getCategory());
			ps.setString(4, ip.getDescription());
			ps.setString(5,"Bhushan");
			ps.setString(6,"12345");
			ps.setString(7, ip.getDate());
			ps.setString(8, ip.getTime());
			n=ps.executeUpdate();
			
		}
		catch(Exception ee)
		{
			System.out.println(ee);
		}
		return n;
	}
}
