package Final_javaproject;


//회원가입을 위한 db연동
public class DBsignup {
	java.sql.Connection conn;
	java.sql.Statement stmt;
	java.sql.ResultSet rs;
	
	private String ID;
	private String password;
	private String name;
	
	DBsignup(){  //생성자
		connect();
	}
	//해당 드라이버의 클래스를 이용하여 DB접속(_conn)
	//DB에 명령어를 전달할 수 있는 객체 생성(_stmt)
	void connect() {
		String dbinfor="jdbc:mysql://localhost:3306/customer_signup?characterEncoding=UTF-8&serverTimezone=UTC";
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
	public static void createCustomer(String ID,String password, String name) {
		try {
			DBsignup ot=new DBsignup();
			DBsignup info=new DBsignup();
			
			ot.Undate("INSERT INTO signup_infotb (ID, password, name)" + "VALUES('" + ID + "','" + password + "','" + name + "')");
			
			ot.select("SELECT * FROM signup_infotb");
			ot.rs.beforeFirst();
			
		}//try
		catch(Exception e) {
			System.out.println("getString error:" + e);
		}
	}
}
