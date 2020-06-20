package Features;

import java.sql.*;

public class Login {
	public static String getPassport(String name, String password) throws SQLException {
		SysClass.printLog("开始验证登录……");
		Connection conn = getDataBase();
		if(conn != null) {
			SysClass.printLog("数据库连接成功。");
			SysClass.SysData.conn = conn;
			Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT uid,uname,upassword,authority FROM User;");
            SysClass.printLog("符合登录的用户数据：");
            boolean hasUser = false;
            while(rs.next()) {
            	int uid = rs.getInt("uid");
            	String uname = rs.getString("uname");
            	String upassword = rs.getString("upassword");
            	String authority = rs.getString("authority");
            	
            	// 验证登录
            	if(rs.getString("uname").equals(name)) {
            		System.out.println(">> " + uid + " - " + uname + " - " + upassword);
            		hasUser = true;
            		if(rs.getString("upassword").equals(password)) {
            			SysClass.printLog("验证完成：");
            			SysClass.SysData.uid = uid;
            			SysClass.SysData.uname = uname;
            			return "OK - 200 - " + authority;
            		}
            		else {
            			SysClass.printErr("密码错误！");
            			SysClass.printLog("验证完成：");
                    	return "Err - 密码错误";
            		}
            	}
            }
            if(!hasUser) {
            	SysClass.printErr("用户不存在！");
            	SysClass.printLog("验证完成：");
            	return "Err - 用户不存在";
            }
		}
		SysClass.printLog("验证完成：");
		return "Err - None";
	}
	
	// 连接数据库
	private static Connection getDataBase()
	{
		return DBUtil.createConnection(SysClass.SysData.mainurl + "test" + SysClass.SysData.mainurladd);
	}
}
