import java.awt.*;
import javax.crypto.*;
import java.net.*;

public class Armory extends Attacker {
	public static final Race RACE = Race.MONSTER;
	public static final Alignment ALIGNMENT = Alignment.BAD;
	private static final int BASE_HEALTH = 20,PHYS_RES = 0,SPELL_RES = 0,RANGE = 10,MAINGUN_DAM = -1;
		//FRENZYBOMB_DAM = -5
		//frenzy bomb AOE
		//frenzy effect timer
		//frenzy bomb timer
		//frenzy active
		//snipe timer
	//private int mainGunCounter = 0;
	//variable for storing frenzied units
	//variable for storing buffed towers
	private int eastRange,westRange,northRange,southRange;
	
	public Armory(boolean physBuff, boolean frenzy, boolean snipe, boolean emp, boolean combo, Point start){
		position = start;
		health = BASE_HEALTH;
		physDef = PHYS_RES;
		magiDef = SPELL_RES;
		race = RACE;
		alignment = ALIGNMENT;
		specialAbilities = new boolean[]{physBuff,frenzy,snipe,emp,combo};
		//set frenzy timer
		//set sniper timer
		eastRange = (int)position.getX()+RANGE;//move this into it's own method, so units can use it as they move
		westRange = (int)position.getX()-RANGE;
		southRange = (int)position.getY()+RANGE;
		northRange = (int)position.getY()-RANGE;
	}
	
	public void act(){
		Attacker target = null;
		target = Utilities.findTargetInArea(eastRange,westRange,northRange,southRange,alignment);
		if (target != null) {
			/* Combo Bonus Main Gun
			if (specialAbilities[4]) {
				++mainGunCounter;//main gun counter has to be able to reset after a period of inactivity
				if (mainGunCounter > 9) {
					//call take phys peircing damage, pass target, pass main gun damage+
				}
				else if (mainGunCounter > 19) {
					//call take phys peircing damage, pass target, pass main gun damage++
				}
				else if (mainGunCounter > 29) {
					//call take phys peircing damage, pass target, pass main gun damage+++
				}
			} else {
				
			}
			*/
			Utilities.physPiercing(MAINGUN_DAM, target);
			System.out.println(
				"Tower at "+(int)position.getX()+","+(int)position.getY()+
				" : attacked Unit at "+(int)target.getPosition().getX()+","+
				(int)target.getPosition().getY()+"(Health : "+target.getHealth()+")");
		}
		/* Frenzy Bomb and Sniper
		if (specialAbilities[1]) {
			//check frenzy active - not active
				//check frenzybomb timer
				target = null;
				//call find target in utilities, pass it range/alignment, make target equal what is returned
				if (target != null) {
					//create an array of attackers
					//makes that array equal the return of a utitliy call for an area target, pass it range
					//loop through the array
						//set each targets alignment to neutral
						//store an array of values so it can be reset after frenzy concludes
					//reset frenzy timer
					//reset frenzy effect timer
					//frenzy is active
				}
			//frenzy is active
				//check frenzy effect timer - equals 0
					//loop through the target array
						//set targets alignment back to normal
					//frenzy is not active
		}
		if (specialAbilities[2]) {
			//check sniper timer
			target = null;
			//call a utility find highest priority, pass range, target equals return
			if (target != null) {
				//set targets health to -1
			}
		}
		*/
	}
}