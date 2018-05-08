package game;

import java.io.IOException;
import java.util.Random;

import game.startStory.startStoryController;
import javafx.fxml.FXML;

public class YourChar {
	private Main main;
	private int exp=0;
	private int maxExp=100;
	private int strength;
	private int health;
	private int maxHealth;
	private String gender;
	private String name;
	private String charClass;
	private int level=1;
	private int armor;
	private int storyLevel=0;
	public YourChar(String name, String charClass, String gender){
		Random generator = new Random();
		this.name = name;
		this.charClass = charClass;
		this.gender = gender;
			if(charClass.equals("Wojownik"))
				{
				this.strength = generator.nextInt(5)+2;
				this.armor = generator.nextInt(5)+2;
				this.health = 100;
				this.maxHealth = 100;
				}
			else if(charClass.equals("Zabójca")){
				this.strength = generator.nextInt(5)+4;
				this.armor = generator.nextInt(5);
				this.health = 80;
				this.maxHealth = 80;
			}
			else if(charClass.equals("Tarczownik")){
				this.strength = generator.nextInt(5);
				this.armor = generator.nextInt(5)+4;
				this.health = 120;
				this.maxHealth = 120;
			}
	}
	public String getName(){
		return this.name;
	}
	public int getLevel(){
		return this.level;
	}
	public int getStrength(){
		return this.strength;
	}
	public int getArmor(){
		return this.armor;
	}
	public int getHealth(){
		return this.health;
	}
	public int getExp(){
		return this.exp;
	}
	public void levelUp(){
		this.level+=1;
		this.maxHealth+=10;
		this.health=this.maxHealth;
		this.strength+=1;
		this.armor+=1;
	}
	public void setStoryLevel(int storyLevel){
		this.storyLevel = storyLevel;
	}
	public int getStoryLevel(){
		return this.storyLevel;
	}
	public void nextStoryLevel(){
		this.storyLevel++;
	}
	public void setHealth(int health){
		this.health-= health;
	}
	public void setExp(int exp) throws IOException{
		this.exp+=exp;
		if(this.exp>=100){
			this.exp-=100;
			levelUp();
			main.levelUpStage();
			}
	}
	public String getCharClass(){
		return this.charClass;
	}
	public String getGender(){
		return this.gender;
	}
	public int getArm(){
		if(this.armor>=10)
			return 4;
		else if(this.armor>=5)
			return 2;
		else if(this.armor>=2)
			return 1;
		else
			return 0;
	}

}
