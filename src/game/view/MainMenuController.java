package game.view;

import java.io.IOException;

import game.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainMenuController {
	private Main main;
	@FXML
	public static Button grads;

	@FXML
	private void showNewGame() throws IOException{
		main.newGame();

	}
	@FXML
	private void continueGame() throws IOException{
		main.startStory();
	}
	@FXML
	private void exitGame() throws IOException{
		System.exit(-1);
	}
	private void onMouseDrag(){

	}

}
