import java.awt.*;
import java.util.*;
import javax.tools.*;

public class Attacker extends Map{
	public static enum Race {HUMAN, ELF, DWARF, MONSTER};
	public static enum Alignment {GOOD, BAD, NEUTRAL};
	protected int health = 0;
	protected int physDef = 0;
	protected int magiDef = 0;
	//priority variable
	protected Point position = new Point(0,0);
	protected Race race = Race.HUMAN;
	protected Alignment alignment = Alignment.GOOD;
	protected boolean [] specialAbilities;
	//public abstract void aoe();
//Health
	protected void setHealth(int h){
		health = h;
	}
	public int getHealth(){
		return health;
	}
//Physical Defense
	public void setPhysDef(int def){
		physDef = def;
	}
	public int getPhysDef(){
		return physDef;
	}
//Magical Defense
	public void setMagiDef(int def){
		magiDef = def;
	}
	public int getMagiDef(){
		return magiDef;
	}
//Position
	protected void setPosition(Point p){
		int x = (int)p.getX();
		int y = (int)p.getY();
		if (x > 0  && x < map.get(0).size() && y > 0 && y < map.size()) {
			position = p;
		}
	}
	public Point getPosition(){
		return position;
	}
//Race
	public void setRace(Race race){
		this.race = race;
	}
	public Race getRace(){
		return race;
	}
//Alignment
	public void setAlignment(Alignment alignment){
		this.alignment = alignment;
	}
	public Alignment getAlignment(){
		return alignment;
	}
//Special Abilities
	public void setSpecial(int index, boolean isActive){
		try {
			specialAbilities[index] = isActive;
		} catch (Exception e) {
		}
	}
	public boolean[] getSpecial(){
		return specialAbilities;
	}
	public boolean getSpecial(int index){
		try {
			return specialAbilities[index];
		} catch (Exception e) {
			return specialAbilities[0];
		}
	}
	public void act(){
		
	}
}