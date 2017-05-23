import java.awt.*;
import java.util.*;
import javax.tools.*;

public class Map {
	protected Vector<Vector <Point>> map = new Vector<Vector<Point>>(30);
	protected static Vector<Point> path;
	protected static Vector<Attacker> unitsAndTowers = new Vector<Attacker>();
	public Map(){
		for (int y = 0; y < map.capacity(); ++y) {
			map.add(new Vector<Point>(30));
			for (int x = 0; x < map.get(y).capacity(); ++x) {
				map.get(y).add(new Point(x,y));
			}
		}
		setPath();
	}	
//Map
	public Point getMapPoint(int x, int y){
		return map.get(y).get(x);
	}
//Path
	public void setPath(){//needs to take a set of values from somewhere, and turn those into the path
		path = new Vector<Point>(30);
		for (int i = 0; i < path.capacity(); ++i)
			path.add(map.get(i).get(i));
	}
	public Vector<Point> getPath(){
		return path;
	}
	public void addPath(int index, Vector<Point> elements){
		path.addAll(index, elements);
	}
	public void removePath(int fromIndex, int toIndex){//from: inclusive, to: exclusive
		path.subList(fromIndex, toIndex).clear();
	}
	public Point getStart(){
		return path.get(0);
	}
//units and towers
	public void addUnit(Attacker attacker){
		unitsAndTowers.add(attacker);
	}
	public Vector<Attacker> getUnitsAndTowers(){
		return unitsAndTowers;
	}
//clean up
	public void clean(){
		for (Attacker a : unitsAndTowers) {
			if (a.getHealth() < 0) {
				unitsAndTowers.remove(a);
			}
		}
	}
}