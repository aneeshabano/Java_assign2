package mypack;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class UserInformation {

	public static void main(String[] args) {
		System.out.println("user details...");
		getUserDetail();
		System.out.println("user contact details...");
		getUserContactDetail();
	}

	@SuppressWarnings("unchecked")
	public static void getUserDetail()
	{
		Connection con=null;
		try
		{
		con=Constant.getConnection();
		Statement st=con.createStatement();
		String sql="select * from user_details";
		ResultSet rs=st.executeQuery(sql);
		
		JSONArray jArray=new JSONArray();
		LinkedHashMap<String, String> obj=new LinkedHashMap<String, String>();
		JSONObject jobj=new JSONObject();
		while(rs.next())
		{
			int user_id=rs.getInt("user_id");
			String user_firstname=rs.getString("user_firstname"); 
			String user_lastname=rs.getString("user_lastname"); 
			int user_age=rs.getInt("user_age");
			String user_email=rs.getString("user_email");
			String user_country=rs.getString("user_country");
			
			obj.put("user_id", user_id+"");
			obj.put("user_firstname", user_firstname);
			obj.put("user_lastname", user_lastname);
			obj.put("user_age", user_age+"");
			obj.put("user_email", user_email);
			obj.put("user_country", user_country);
			
		}
		jobj.put("Success", obj);
		
		 System.out.println(jobj);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	public static void getUserContactDetail()
	{
		Connection con=null;
		try
		{
		con=Constant.getConnection();
		Statement st=con.createStatement();
		String sql="select u.user_id, u.user_firstname, u.user_lastname, u.user_age, u.user_email, u.user_country, ucd.contact_id, ucd.phone_number, ucd.comments from user_details u, user_contact_details ucd where u.user_id=ucd.user_id ";
		ResultSet rs=st.executeQuery(sql);
		
		LinkedHashMap<String, String> obj1=new LinkedHashMap<String, String>();
		//ArrayList<String> obj1=new ArrayList<String>();
		LinkedHashMap<String, String> obj2=new LinkedHashMap<String, String>();
		JSONArray jArray1=new JSONArray();
		JSONArray jArray2=new JSONArray();
		//JSONArray jArray=null;
		JSONObject jobj1=new JSONObject();
		//JSONObject jobj1=null;
		JSONObject jobj2=new JSONObject();
		
		while(rs.next())
		{
			//user_details table's details
			int user_id=rs.getInt("user_id");
			String user_firstname=rs.getString("user_firstname"); 
			String user_lastname=rs.getString("user_lastname"); 
			int user_age=rs.getInt("user_age");
			String user_email=rs.getString("user_email");
			String user_country=rs.getString("user_country");
			
			// user_contact_details table's details
			String contact_id=rs.getString("contact_id");
			String phone_number=rs.getString("phone_number");
			String comments=rs.getString("comments");
			
			
			obj1.put("user_id", user_id+"");
			obj1.put("user_firstname", user_firstname);
			obj1.put("user_lastname", user_lastname);
			obj1.put("user_age", user_age+"");
			obj1.put("user_email", user_email);
			obj1.put("user_country", user_country);
			jobj1=new JSONObject(obj1);
			
			
			/*jobj1.put("user_id", user_id+"");
			jobj1.put("user_firstname", user_firstname);
			jobj1.put("user_lastname", user_lastname);
			jobj1.put("user_age", user_age+"");
			jobj1.put("user_email", user_email);
			jobj1.put("user_country", user_country);*/
			
			
			
			obj2.put("contact_id", contact_id);
			obj2.put("phone_number", phone_number);
			obj2.put("comments", comments);
			
			
			//jArray1.put(obj1);
			
			
			
		}
		jArray2.put(obj2);
		jobj1.put("User_contact_details", jArray2);
		jobj2.put("Success", jobj1);
		
		
		System.out.println(jobj2);
		//jobj.put("user_contact_details", jArray);
		
		
		
		//jobj.put("user_contact_details", jArray);
		
		 
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
