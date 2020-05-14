package bdd;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DataBase {

	public static Connection connection = null;

	private final static String PL_SQL_SCRIPT = "script/plsqlscript.txt";

	private static ArrayList<String> listProcedures = new ArrayList<String>();

	public static void connexion(String user, String mdp) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE",user,mdp);
			System.out.println("Connecté à la base de données");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void chargerProcedure() {
		try {
			String sligne;
			String procedure = "";
			BufferedReader bfr = new BufferedReader(new FileReader(PL_SQL_SCRIPT));
			while((sligne = bfr.readLine())!=null) {
				procedure = procedure + sligne + "\n";
				if(sligne.contains("end;")||sligne.contains("END;")) {
					listProcedures.add(procedure);
					procedure = "";
				}
			}
			System.out.println("liste"+ listProcedures);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void compilerProcedure() {
		try {
			for (int i = 0; i < listProcedures.size(); i++) {
				System.out.println("COMPILE::"+listProcedures.get(i));
				executerQuery(listProcedures.get(i));
				System.out.println("compilé");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ResultSet executerQuery(String query) throws SQLException {
		PreparedStatement pstmt = connection.prepareStatement(query);
		return pstmt.executeQuery();
	}

}


