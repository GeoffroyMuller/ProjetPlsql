package controleurs;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	
}
