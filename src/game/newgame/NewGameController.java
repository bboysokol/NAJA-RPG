package game.newgame;

import java.io.IOException;

import game.Main;
import game.YourChar;
import game.startStory.startStoryController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class NewGameController{

	ObservableList<String> classCharList = FXCollections
			.observableArrayList("Wojownik", "Zabójca", "Tarczownik");
	private Main main;
	public static YourChar newChar;
	@FXML
	public TextField nameField;
	@FXML
	public ChoiceBox classCharBox;
	@FXML
	public RadioButton maleBtn;
	@FXML
	public RadioButton femaleBtn;
	@FXML
	private Label checker;

	@FXML
	private void initialize(){
		classCharBox.setValue("Wojownik");
		classCharBox.setItems(classCharList);

	}
	@FXML
	private void back() throws IOException{
		main.showGuidMenu();
	}
	@FXML
	private void next() throws IOException{
		if(nameField.getText().equals("") || !maleBtn.isSelected() && !femaleBtn.isSelected())
		{
			checker.setVisible(true);
		}
		else
		{
			String gender;
			if(maleBtn.isSelected()){
				gender = "Mê¿czyzna";}
			else{
				gender = "Kobieta";}
		String classChar = (String) classCharBox.getValue();
		YourChar newChar = new YourChar(nameField.getText(),classChar,gender);
		this.newChar = newChar;
		main.startStory();
		}

	}
	public YourChar getNewChar(){
		return this.newChar;
	}

}
