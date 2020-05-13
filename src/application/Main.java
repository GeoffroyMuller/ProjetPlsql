package application;
	
import java.sql.SQLException;

import bdd.DataBase;
import bdd.dao.DaoVol;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/vues/principale.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root,929,550);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {

//		DataBase.connexion("root", "root");
//		DataBase.chargerProcedure();
//		DataBase.compilerProcedure();
//		try {
//			DaoVol.getInstance().programmer("V2", "30/12/2021 08:00", "355");
//			System.out.println("sss");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		launch(args);
	}
}
