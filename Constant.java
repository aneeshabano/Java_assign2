package mypack;

import java.sql.Connection;
import java.sql.DriverManager;

public class Constant {

	public static String	CONNECTION_STRING	= "jdbc:mysql://localhost/java_assign?user=root&password=mysqlroot";
	public static String	DRIVER_NAME	= "com.mysql.jdbc.Driver";

	public static Connection con=null;
	
	public static Connection getConnection() throws Exception
	{
		Class.forName(DRIVER_NAME);
		con=DriverManager.getConnection(CONNECTION_STRING);
		return con;
	}
}
