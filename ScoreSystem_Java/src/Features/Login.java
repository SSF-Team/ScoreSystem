package Features;

import java.sql.*;

public class Login {
	public static String getPassport(String name, String password) throws SQLException {
		SysClass.printLog("��ʼ��֤��¼����");
		Connection conn = getDataBase();
		if(conn != null) {
			SysClass.printLog("���ݿ����ӳɹ���");
			SysClass.SysData.conn = conn;
			Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT uid,uname,upassword,authority FROM User;");
            SysClass.printLog("���ϵ�¼���û����ݣ�");
            boolean hasUser = false;
            while(rs.next()) {
            	int uid = rs.getInt("uid");
            	String uname = rs.getString("uname");
            	String upassword = rs.getString("upassword");
            	String authority = rs.getString("authority");
            	
            	// ��֤��¼
            	if(rs.getString("uname").equals(name)) {
            		System.out.println(">> " + uid + " - " + uname + " - " + upassword);
            		hasUser = true;
            		if(rs.getString("upassword").equals(password)) {
            			SysClass.printLog("��֤��ɣ�");
            			SysClass.SysData.uid = uid;
            			SysClass.SysData.uname = uname;
            			return "OK - 200 - " + authority;
            		}
            		else {
            			SysClass.printErr("�������");
            			SysClass.printLog("��֤��ɣ�");
                    	return "Err - �������";
            		}
            	}
            }
            if(!hasUser) {
            	SysClass.printErr("�û������ڣ�");
            	SysClass.printLog("��֤��ɣ�");
            	return "Err - �û�������";
            }
		}
		SysClass.printLog("��֤��ɣ�");
		return "Err - None";
	}
	
	// �������ݿ�
	private static Connection getDataBase()
	{
		return DBUtil.createConnection("jdbc:mysql://SQL Info（SQL 地址）"+
                "characterEncoding=utf8&useUnicode=true&useSSL=false");
	}
}
