package Final_javaproject;

import java.sql.ResultSet;

//정보를 쫙 보여주는 클래스
public class DBstudyinfo {
	java.sql.Connection conn;
	java.sql.Statement stmt;
	java.sql.ResultSet rs;
	
	public DBstudyinfo(){  //생성자
		connect();
	}
	//해당 드라이버의 클래스를 이용하여 DB접속(_conn)
	//DB에 명령어를 전달할 수 있는 객체 생성(_stmt)
	void connect() {
		String dbinfor="jdbc:mysql://localhost:3306/customer_study_info?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbID="root";
		String dbPW="solmin1129";
		String sql="SELECT * FROM studyinfotb";
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conn=java.sql.DriverManager.getConnection(dbinfor,dbID,dbPW);
			this.stmt=this.conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
		}catch(Exception e){
			System.out.println("connection error:" + e);
		}
	}
}
