package DBconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection{  

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn=null;
		try {
			 Class.forName("com.mysql.jdbc.Driver");
			 String dbURL = "jdbc:mysql://127.0.0.1:3306/mysql?useSSL=false"; 
			 //String url = "jdbc:mysql://localhost/information";
			 conn = DriverManager.getConnection(dbURL, "root", "solmin1129");
	            System.out.println("연결 성공");
	         
	         
	         
		}catch(ClassNotFoundException e){
            System.out.println("드라이버 로딩 실패");
		}
		catch(SQLException e){
            System.out.println("에러: " + e);
		}
		 finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
		 }
	}

}