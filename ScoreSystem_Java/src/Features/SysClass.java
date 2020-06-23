package Features;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SysClass {
	
	public static class SysData {
		public static String version = "Ver - Dev.0.2.6(15)";

		public static int uid ;
		public static String uname;
		public static Connection conn;
		public static String mainurladd= "?characterEncoding=utf8&useUnicode=true&useSSL=false";
		
		// SQL 服务器信息
		public static String mainurl = "jdbc:mysql://localhost:3306/";
		public static String SQLUser = "root";
		public static String SQLPassword = "Admin";
	}
	
	public static void printLog(String log) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    	System.out.println("["+ df.format(new Date()) + "] " + log);
	}
	
	public static void printErr(String err) {
		SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
    	System.err.println("["+ df.format(new Date()) + "] " + err);
	}
}
