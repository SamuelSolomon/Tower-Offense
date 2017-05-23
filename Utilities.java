import java.util.*;
import java.awt.*;

public final class Utilities extends Map {
	
	public static Attacker findTargetInArea(int east, int west, int north, int south, Attacker.Alignment alignment){//make it take a circle instead of a rectangle
		int x;
		int y;
		for (Attacker a : unitsAndTowers) {//
			if (a.getAlignment() != alignment) {
				x = (int)a.getPosition().getX();
				y = (int)a.getPosition().getY();
				if (west <= x && x <= east && north <= y && y <= south) {
					return a;
				}
			}
		}
		return null;
	}
	//find targets in area
	//find target
	//find targets
	public static void physPiercing(int damage, Attacker target){
		damage = damage + (target.getPhysDef()/2);
		if (damage > 0)
			damage = 0;
		target.setHealth(target.getHealth() +damage);
		//if (target.getHealth() < 0) {
		//	unitsAndTowers.remove(target);
		//	System.out.println("a Miner lost all it's health and was removed");
		//}
	}
	//magic peircing
	public static void physical(int damage, Attacker target){
		damage = damage + (target.getPhysDef());
		if (damage > 0)
			damage = 0;
		target.setHealth(target.getHealth() +damage);
		//if (target.getHealth() < 0) {
		//	unitsAndTowers.remove(target);
		//	System.out.println("a Tower lost all it's health and was removed");
		//}
	}
	//magic
}