package game.view;

import java.io.IOException;

import game.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainViewController {
	private Main main;
	@FXML
	private Button gra;

	@FXML
	private void goMenu() throws IOException{
		main.showGuidMenu();
		gra.setDisable(false);

	}
	@FXML
	private void goGame() throws IOException{
		main.startStory();
	}


}
