package game.startStory;

import java.io.IOException;

import game.Main;
import game.Monster;
import game.YourChar;
import game.newgame.NewGameController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class startStoryController {
	private YourChar character;
	private Monster monster1;
	private Main main;
	@FXML
	public Label nameField;
	@FXML
	private Label charClass;
	@FXML
	private Label gender;
	@FXML
	private Label level;
	@FXML
	private ProgressBar exp;
	@FXML
	private ProgressBar health;
	@FXML
	private Label strength;
	@FXML
	private Label armor;
	@FXML
	public TextArea storyArea;
	@FXML
	private Button opponentBtn;
	@FXML
	private Button attackBtn;
	@FXML
	private Button nextTurnBtn;
	private int OppAttack;
	private int YourAttack;

	private int storyLevel;

	public void  initialize(){
		this.opponentBtn.setDisable(true);
		this.attackBtn.setDisable(true);
		this.nameField.setText(NewGameController.newChar.getName());
		this.level.setText(Integer.toString(NewGameController.newChar.getLevel()));
		this.strength.setText(Integer.toString(NewGameController.newChar.getStrength()));
		this.armor.setText(Integer.toString(NewGameController.newChar.getArmor()));
		this.health.setProgress(NewGameController.newChar.getHealth()*0.01);
		this.exp.setProgress(NewGameController.newChar.getExp()*0.01);
		this.charClass.setText(NewGameController.newChar.getCharClass());
		this.gender.setText(NewGameController.newChar.getGender());
	}

	public void startStory(){
			if(NewGameController.newChar.getStoryLevel() == 0){
				NewGameController.newChar.setStoryLevel(1);
			}
		switch(NewGameController.newChar.getStoryLevel()){
		case 1:storyArea.setText(startStoryList.firstQuest());NewGameController.newChar.nextStoryLevel();break;
		case 2:storyArea.setText(startStoryList.secondQuest());NewGameController.newChar.nextStoryLevel();break;
		case 3:
			if(NewGameController.newChar.getStrength()>=4)storyArea.setText(startStoryList.secondQuestVerA());
			else
				startBattle(NewGameController.newChar, Monster.pijany_wiesniak);
				NewGameController.newChar.nextStoryLevel();break;
		case 4:storyArea.setText(startStoryList.thridQuest());NewGameController.newChar.nextStoryLevel();break;
		case 5:startBattle(NewGameController.newChar, Monster.ork);NewGameController.newChar.nextStoryLevel();break;
		case 6:storyArea.setText(startStoryList.fourthQuest());break;
		}
	}

	public void fight(){
		opponentBtn.setDisable(true);
		this.OppAttack = (monster1.getStrength()-character.getArm());
			if(OppAttack<0)this.OppAttack=0;
		character.setHealth(OppAttack);
		this.health.setProgress(character.getHealth()*0.01);
		if(character.getHealth()<=0)
			storyArea.setText("Zginales, otrzymujac smiertelne obrazenia");
		else{
		storyArea.setText("Zostales zaatakowany przez "+monster1.getName()+" i zadano Ci "+ OppAttack+" obrazen.\nMasz teraz "+ character.getHealth()+"\nKliknij ATAK, ¿eby kontynuowac...");
		attackBtn.setDisable(false);
		}
	}

	public void getObject1(YourChar character){
		this.character=character;
	}
	public void getObject2(Monster monster1){
		this.monster1=monster1;
	}

	public void nextHit() throws IOException{
		attackBtn.setDisable(true);
		if(NewGameController.newChar.getHealth()<=0)
			storyArea.setText("Zginales, otrzymujac smiertelne obrazenia");
		else
		{
			if(monster1.getHealth()>=0){
				YourAttack = (character.getStrength()-monster1.getArm());
				if(YourAttack<0)this.YourAttack=0;
				monster1.setHealth(YourAttack);
				storyArea.setText("Zaatakowales "+monster1.getName()+" i zadales "+YourAttack+" obrazen.\nTwoj przeciwnik ma teraz "+ monster1.getHealth()+"\nKliknij PRZECIWNIK, aby kontynuuowac...");
					if(monster1.getHealth()<=0){
						storyArea.setText(monster1.getName()+" zgin¹l z Twojej reki i zdobyleœ "+ monster1.getExp()+ "expa.");
						character.setExp(monster1.getExp());
						checkStats(character);
						nextTurnBtn.setDisable(false);
					}
					else
						opponentBtn.setDisable(false);
				}
			else {
				storyArea.setText(monster1.getName()+" zgin¹l z Twojej reki i zdobyleœ "+ monster1.getExp()+ "expa.");
				character.setExp(monster1.getExp());
				checkStats(character);
				nextTurnBtn.setDisable(false);
			}
		}

	}
	public void startBattle(YourChar character, Monster monster1){
		getObject1(character);
		getObject2(monster1);
		storyArea.setText("Napotykasz na swojej drodze "+monster1.getName()+"\nPRZECIWNIK, aby kontynuuowac");
		opponentBtn.setDisable(false);
		nextTurnBtn.setDisable(true);
	}
	public void checkStats(YourChar character){
		this.nameField.setText(NewGameController.newChar.getName());
		this.level.setText(Integer.toString(NewGameController.newChar.getLevel()));
		this.strength.setText(Integer.toString(NewGameController.newChar.getStrength()));
		this.armor.setText(Integer.toString(NewGameController.newChar.getArmor()));
		this.health.setProgress(NewGameController.newChar.getHealth()*0.01);
		this.exp.setProgress(NewGameController.newChar.getExp()*0.01);
	}


}
