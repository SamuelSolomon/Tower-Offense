import java.util.logging.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;

class TowerFrame extends JFrame implements ActionListener{
	Map map = new Map();
	JButton makeMiner = new JButton("Make Miner - no values needed"); 
	JButton makeTower = new JButton("Make Tower - put x and y first");
	JButton act = new JButton("Act - see System Output");
	JLabel prompt = new JLabel("Please enter the X then Y values\n greater than -1, less than 30");
	JTextField xIn = new JTextField();
	JTextField yIn = new JTextField();
	
	public TowerFrame(){
		super("Basic Tower Offense Interface");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500,500, 400,200);
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		
		add(makeMiner);
		add(prompt);
		add(xIn);
		add(yIn);
		add(makeTower);
		add(act);
		makeMiner.addActionListener(this);
		makeTower.addActionListener(this);
		act.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e){
		Object source = e.getSource();
		if (source == makeMiner){
			Miner m = new Miner(false, false, false, map.getStart());
			map.addUnit(m);
			System.out.println("New Miner created at Coordinates 0,0");
		} else if (source == makeTower) {
			try {
				int x = Integer.parseInt(xIn.getText());
				int y = Integer.parseInt(yIn.getText());
				map.addUnit(new Armory(false, false, false, false, false, map.getMapPoint(x,y)));
				System.out.println("Tower made at position "+x+","+y);
			} catch (Exception error) {
				System.out.println("Sorry, Wrong Values");
			}
		} else if (source == act) {
			Vector<Attacker> list;
			list = map.getUnitsAndTowers();
			for (Iterator<Attacker> iterator = list.iterator(); iterator.hasNext(); ) {
				Attacker a = iterator.next();
				if (a.getHealth() < 0) {
					System.out.println(
						a.getClass().getName() + " at " + 
						(int)a.getPosition().getX()+","+
						(int)a.getPosition().getY()+" was destroyed");
					iterator.remove();
				} else if (a.getPosition().getX() >= 29) {
					System.out.println("A " +a.getClass().getName() + " got through");
					iterator.remove();
				} else {
					a.act();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TowerFrame frame = new TowerFrame();
		frame.setVisible(true);
	}
}





