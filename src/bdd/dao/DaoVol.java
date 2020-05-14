package bdd.dao;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Timestamp;
import java.sql.Types;

import bdd.DataBase;
import javafx.util.converter.DateTimeStringConverter;
import utils.Utils;

public class DaoVol {

	private static DaoVol instance;

	public static DaoVol getInstance() {
		if (instance == null) {
			instance = new DaoVol();
		}
		return instance;
	}

	public void programmer(String numVol, String dateHeureDep, String dureeVol) 
			throws SQLIntegrityConstraintViolationException, SQLException {

		CallableStatement cstmt = DataBase.connection.prepareCall (
				"{call Programmer (?, ?, ?)}");

		cstmt.setString(1, numVol);
		cstmt.setTimestamp(2, Utils.convertirDate(dateHeureDep));
		cstmt.setInt(3, Integer.valueOf(dureeVol));
		cstmt.execute ();
	}

	public void affecterPersonnel(String numVol, String dateHeureDep, String matricule)
			throws SQLIntegrityConstraintViolationException, SQLException {

		CallableStatement cstmt = DataBase.connection.prepareCall (
				"{call AffecterPersonnel (?, ?, ?)}");
		cstmt.setString(1, numVol);
		cstmt.setTimestamp(2, Utils.convertirDate(dateHeureDep));
		cstmt.setInt(3, Integer.valueOf(matricule));
		cstmt.execute();
	}

	public void membresEquipage(String numVol, String dateHeureDep) {

	}



}
