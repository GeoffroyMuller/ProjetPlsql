package bdd.dao;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

import bdd.DataBase;

public class DaoVol {

	private static DaoVol instance;

	public static DaoVol getInstance() {
		if (instance == null) {
			instance = new DaoVol();
		}
		return instance;
	}

	public void programmer(String numVol, String dateHeureDep, String dureeVol) throws SQLException {

		CallableStatement cstmt = DataBase.connection.prepareCall (
				"{call Programmer (?, ?, ?)}");

		cstmt.setString(1, numVol);
		cstmt.setTimestamp(2, convertirDate(dateHeureDep));
		cstmt.setInt(3, Integer.valueOf(dureeVol));
		cstmt.execute ();
	}
	
	public void affecterPersonnel(String numVol, String dateHeureDep, String matricule) throws SQLException {
		
		CallableStatement cstmt = DataBase.connection.prepareCall (
				"{call AffecterPersonnel (?, ?, ?)}");

		cstmt.setString(1, numVol);
		cstmt.setTimestamp(2, convertirDate(dateHeureDep));
		cstmt.setInt(3, Integer.valueOf(matricule));
		cstmt.execute ();
	}

	public Timestamp convertirDate(String _date) {
		String dateHeur[] = _date.split(" ");
		String jjmmyyyy[] = dateHeur[0].split("/");
		String hhmm[] = dateHeur[1].split(":");

		@SuppressWarnings("deprecation")
		Timestamp tsp = new Timestamp(
				Integer.valueOf(jjmmyyyy[2]),
				Integer.valueOf(jjmmyyyy[1]),
				Integer.valueOf(jjmmyyyy[0]),
				Integer.valueOf(hhmm[1]),
				Integer.valueOf(hhmm[0]),
				00,
				00);
		
		return tsp;
	}
	
	



}
