import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

	
	public static DataBaseConnection instance = null;
	private static Connection con;
	
	
	private DataBaseConnection() {

	}
	
	static {
		if (instance == null){
			instance = new DataBaseConnection();
			try {
				Class.forName(Constants.DB_CLASS_NAME);
				 con = DriverManager.getConnection(Constants.DB_URL,Constants.DB_USER_NAME,Constants.DB_PASS_WORD);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
		}
	}
	public static Connection getConnection() {
		return con;
	}
	
	
}
