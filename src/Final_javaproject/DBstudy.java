package Final_javaproject;


//공부한 과목과 걸린 시간을 db에 저장하기 위한 클래스
public class DBstudy {
	java.sql.Connection conn;
	java.sql.Statement stmt;
	java.sql.ResultSet rs;
	
	public DBstudy(){  //생성자
		connect();
	}
	//해당 드라이버의 클래스를 이용하여 DB접속(_conn)
	//DB에 명령어를 전달할 수 있는 객체 생성(_stmt)
	void connect() {
		String dbinfor="jdbc:mysql://localhost:3306/customer_study_info?characterEncoding=UTF-8&serverTimezone=UTC";
		String dbID="root";
		String dbPW="solmin1129";
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		this.conn=java.sql.DriverManager.getConnection(dbinfor,dbID,dbPW);
		this.stmt=this.conn.createStatement();
	}catch(Exception e){
		System.out.println("connection error:" + e);
	}
}//connect()
	void Undate(String dbCommand) {
		try {
			this.stmt.executeUpdate(dbCommand);
		}catch(Exception e) {
			System.out.println("undate error : " + e);
		}
		
	}//undate()
	//실행결과
	void select(String dbSelect) {
		try {
			this.rs=this.stmt.executeQuery(dbSelect);
		}catch(Exception e) {
			System.out.println("select error : " + e);
		}
	}//select()
	void close() {
		try {
			conn.close();
		}catch(Exception e){
			System.out.println("close error :" +e);
		}
	}
	public static void StudyInfo(String date,String name, String time) {
		try {
			DBstudy ot=new DBstudy();
			DBstudy info=new DBstudy();
			
			ot.Undate("INSERT INTO studyinfotb (date,name,time)" + "VALUES('" + date + "','" + name + "','" + time + "')");
			
			ot.select("SELECT * FROM studyinfotb");
			ot.rs.beforeFirst();
			
		}//try
		catch(Exception e) {
			System.out.println("getString error:" + e);
		}
	}
}

