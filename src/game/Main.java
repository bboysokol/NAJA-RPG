package game;

import java.io.IOException;

import game.Main;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	private static Stage primaryStage;
	private static BorderPane mainLayout;
	public static Stage levelUpStag;

	@Override
	public void start(Stage primaryStage) throws IOException {
		this.primaryStage=primaryStage;
		this.primaryStage.setTitle("Naja RPG version 0.1");
		showGuid();
		showGuidMenu();
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void showGuid() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainView.fxml"));
		mainLayout = loader.load();
		Scene scene = new Scene(mainLayout, 800,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void showGuidMenu() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainMenu.fxml"));
		BorderPane mainMenu = loader.load();
		mainLayout.setCenter(mainMenu);
	}

	public static void newGame() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("newgame/NewGame.fxml"));
		BorderPane newGame = loader.load();
		mainLayout.setCenter(newGame);
	}

	public static void startStory() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("startStory/startStory.fxml"));
		BorderPane startstory = loader.load();
		mainLayout.setCenter(startstory);
	}
	public static void levelUpStage() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(Main.class.getResource("view/MainLevelUp.fxml"));
		BorderPane levelUp = loader.load();
		Stage levelUpStage = new Stage();
		levelUpStage.setTitle("Nowy Level!");
		levelUpStage.initModality(Modality.WINDOW_MODAL);
		levelUpStage.initOwner(primaryStage);
		Scene scene = new Scene(levelUp);
		levelUpStage.setScene(scene);
		levelUpStag=levelUpStage;
		levelUpStage.showAndWait();


	}
}
