package game;

import java.util.Random;

public class Monster {
	private int exp;
	private int strength;
	private int health;
	private String name;
	private int armor;
	public Monster(String name, int health, int strength, int armor, int exp){
		this.name = name;
		this.health = health;
		this.strength = strength;
		this.armor = armor;
		this.exp = exp;
	}
	public static Monster troll = new Monster("Troll", 10, 10 ,10 ,110);
	public static Monster ork = new Monster("Ork", 10, 10 ,10 ,110);
	public static Monster pijany_wiesniak = new Monster("Pijany Wieœniak", 10, 3 ,0 ,30);

	public String getName(){
		return this.name;
	}
	public  int getStrength(){
		return this.strength;
	}
	public int getHealth(){
		return this.health;
	}
	public void setHealth(int x){
		this.health-=x;
	}
	public int getExp(){
		return exp;
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
	public int getArmor(){
		return this.armor;
	}

}