import java.awt.*;
import javax.swing.text.*;
import java.util.*;

public class Miner extends Attacker {
	public static final Race RACE = Race.DWARF;
	public static final Alignment ALIGNMENT = Alignment.GOOD;
	private static final int 
		BASE_HEALTH = 10,
		RANGE = 1,
		PICKAXE_BASE_DAM = -1,
		PHYS_RES = 0,
		SPELL_RES = 0,
		
		ATTACKING_COUNTER_MAX = 2,
		HEARTS_USED_COUNTER_MAX = 2,
		UNIT_BASE_COST = 0,
		UNIT_HEART_BASE_COST = 1,
		PROPEREQUIPMENT_BASE_COST = 0,
		PROPERTRAINING_BASE_COST = 0,
		FORTHECAUSE_BASE_COST = 0;
	private static int
		attackingCounter = 1,
		heartsUsedCounter = 0;
	private int positionIndex = 0;
	private int eastRange,westRange,northRange,southRange;
	public Miner(boolean properEquipment, boolean properTraining, boolean extraUnits, Point start){
		position = start;
		health = BASE_HEALTH;
		physDef = PHYS_RES;
		magiDef = SPELL_RES;
		race = RACE;
		alignment = ALIGNMENT;
		specialAbilities = new boolean[]{properEquipment,properTraining,extraUnits};
		/*
		if (specialAbilities[0])
			health = (BASE_HEALTH * 2);
			physDef = (PHYS_RES + 1)
		if (specialAbilities[2])
			++heartsUsedCounter;
			if (heartsUsedCounter == HEARTS_USED_COUNTER_MAX)
				unitsAndTowers.add(new Miner(properEquipment,properTraining,extraUnits,start));
				heartsUsedCounter = 0;
		*/
	}
	public void act(){
		Attacker target = null;
		target = Utilities.findTargetInArea(eastRange,westRange,northRange,southRange,alignment);
		if (target != null) {
			/*
			if (specialAbilities[0]){
				//call take phys damage in utilities, pass it the target, and the damage done *better
			}
			else{
				//call take phys damage in utilities, pass it the target, and the damage done
			}
			*/
			Utilities.physical(PICKAXE_BASE_DAM, target);
			System.out.println(
				"Miner at "+(int)position.getX()+","+(int)position.getY()+
				" : attacked Tower at "+(int)target.getPosition().getX()+","+(int)target.getPosition().getY()+
				"(Health : "+target.getHealth()+")");
		} else {
			++positionIndex;
				System.out.print("Miner moved from position "+(int)position.getX()+","+(int)position.getY());
				position = path.get(positionIndex);
				eastRange = (int)position.getX()+RANGE;
				westRange = (int)position.getX()-RANGE;
				southRange = (int)position.getY()+RANGE;
				northRange = (int)position.getY()-RANGE;
				System.out.println(", to position "+(int)position.getX()+","+(int)position.getY());
		}
	}
}