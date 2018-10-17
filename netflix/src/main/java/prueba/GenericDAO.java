package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GenericDAO {

	private static String driver="com.mysql.cj.jdbc.Driver";
	private static String ip="10.90.37.55";
	private static String puerto="3306";
	private static String bbdd="mordor";
	private static String user="prueba";
	private static String pass="1234";
	
	public GenericDAO() {};
	
	public static List executeSQL(String sql) {
		Connection conn=null;
		try {
			Class.forName(driver);
			String cadena=String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", ip,puerto,bbdd,user,pass);
			conn=DriverManager.getConnection(cadena);
			System.out.println("Conexion establecida");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		List result=new ArrayList();
		ResultSet rs = null;
		try {
			Statement sentencia = conn.createStatement();
			rs = sentencia.executeQuery(sql);
			
			ResultSetMetaData rsMetaData = rs.getMetaData();
		    int numberOfColumns = rsMetaData.getColumnCount();
		    
			while (rs.next()) {
				List<Object> array=new ArrayList();
				for(int i=1;i<=numberOfColumns;i++) {
					Object value = rs.getObject(i);
					array.add(value);
				}
				result.add(array);
			}
			result.forEach(a->System.out.println(a.toString()));
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
public static void main(String[] args) {
		GenericDAO.executeSQL("SELECT pruebaconexion()");
	}
}
