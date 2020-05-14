package controleurs;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

import bdd.DataBase;
import bdd.dao.DaoVol;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controleur {

	@FXML
	private RadioButton rb_progVol;
	@FXML
	private RadioButton rb_affectPerso;
	@FXML
	private RadioButton rb_membEquip;

	@FXML
	private Label label_numvol;
	@FXML
	private Label label_datedepart;
	@FXML
	private Label label_dureevol;
	@FXML
	private Label label_matricule;

	@FXML
	private TextField tf_numvol;
	@FXML
	private TextField tf_datedepart;
	@FXML
	private TextField tf_dureevol;
	@FXML
	private TextField tf_matricule;
	@FXML
	private TextArea ta_resultat;

	/**
	 * active l'etat progVol
	 */
	@FXML
	public void activeRadioButton_progVol() {
		rb_affectPerso.setSelected(false);
		rb_membEquip.setSelected(false);

		tf_dureevol.setDisable(false);
		tf_matricule.setDisable(true);

		label_dureevol.setDisable(false);
		label_matricule.setDisable(true);
	}

	/**
	 * active l'etat affectPerso
	 */
	@FXML
	public void activeRadioButton_affectPerso() {
		rb_progVol.setSelected(false);
		rb_membEquip.setSelected(false);

		tf_dureevol.setDisable(true);
		tf_matricule.setDisable(false);

		label_dureevol.setDisable(true);
		label_matricule.setDisable(false);
	}

	/**
	 * active l'etat membEquip
	 */
	@FXML
	public void activeRadioButton_membEquip() {
		rb_progVol.setSelected(false);
		rb_affectPerso.setSelected(false);

		tf_dureevol.setDisable(true);
		tf_matricule.setDisable(true);

		label_dureevol.setDisable(true);
		label_matricule.setDisable(true);
	}

	@FXML
	public void Executer() {
		Message("","#1d5d8e");
		try {
			if(rb_progVol.isSelected()) {
				DaoVol.getInstance().programmer(
						tf_numvol.getText(),
						tf_datedepart.getText(),
						tf_dureevol.getText()
						);
			}else if(rb_affectPerso.isSelected()) {
				DaoVol.getInstance().affecterPersonnel(
						tf_numvol.getText(),
						tf_datedepart.getText(),
						tf_matricule.getText()
						);
			}else if(rb_membEquip.isSelected()) {

			}
			Message("Procédure PL/SQL terminée.",
					"#21bc5d");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			Message("Erreur : NumberFormatException : le format du nombre correspondant à l'un des paramètre est incorrect",
					"#bf2222");
			//e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			Message("Erreur : IllegalArgumentException : la date entrée devrais être supperieur à la date system",
					"#bf2222");
			//e.printStackTrace();
		} catch (SQLIntegrityConstraintViolationException e) {
			Message("Erreur : SQLIntegrityConstraintViolationException : violation de contrainte unique. Elément identique dans la base.",
					"#bf2222");
			//e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			Message("Erreur : SQLException : verifier les format des données entrées.",
					"#bf2222");
		}
	}

	@FXML
	public void ChargerScript() {
		try {
			DataBase.chargerProcedure();
			DataBase.compilerProcedure();
			Message("Script Chargé.",
					"#21bc5d");
		} catch (Exception e) {
			// TODO: handle exception
			Message("Erreur : le script ne peut pas être chargé.",
					"#bf2222");
		}
	}

	public void Message(String msg, String color) {
		ta_resultat.setText(msg);
		ta_resultat.setStyle("-fx-text-fill: "+color);
	}

}
