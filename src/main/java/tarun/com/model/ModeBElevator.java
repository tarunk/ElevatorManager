package tarun.com.model;

import tarun.com.cmds.Command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;


public class ModeBElevator implements Elevator {
	private Set<Integer> upSet;
	private Set<Integer> downSet;
	private ArrayList<Integer> printUpFirst;
	private ArrayList<Integer> printDownFirst;
	
	public ModeBElevator() {
		upSet = new TreeSet<>();
		downSet = new TreeSet<>();
		printUpFirst = new ArrayList<>();
		printDownFirst = new ArrayList<>();
	}
	
	@Override
	public String executeCommand(int level, ArrayList<Command> cmds) {
		upSet.clear();
		downSet.clear();
		for (Command c : cmds) {
			if (c.getStartFloor() > c.getEndFloor()) {
				downSet.add(c.getStartFloor());
				downSet.add(c.getEndFloor());
			} else {
				upSet.add(c.getStartFloor());
				upSet.add(c.getEndFloor());
			}
		}
		
		return findOptinalPath(level);
	}
	
	
	String findOptinalPath(int level) {
		StringBuilder sb;
		int distance = 0;
		if (downSet.isEmpty()) {
			distance = upFirstCost(level);
			sb = printSequence(printUpFirst);
		} else if (upSet.isEmpty()) {
			distance = downFirstCost(level);
			sb = printSequence(printDownFirst);
		} else {
			int upFirst = upFirstCost(level);
			int downFirst = downFirstCost(level);
			if (upFirst > downFirst) {
				sb = printSequence(printDownFirst);
				distance = downFirst;
			} else {
				sb = printSequence(printUpFirst);
				distance = upFirst;
			}
		}

		sb.append("(" + distance + ")");
		return sb.toString();
	}
	private int downFirstCost(int level) {
		printDownFirst.clear();
		
		int downFirstCost = 0;
		int startLevel = level;
		printDownFirst.add(startLevel);
		
		// first go to down
		ArrayList<Integer> reverseSet = new ArrayList<>();
		reverseSet.addAll(downSet);
		Collections.reverse(reverseSet);
		for (int a : reverseSet) {
			if (startLevel != a) {
				printDownFirst.add(a);
				downFirstCost += Math.abs(startLevel - a);
			}
			startLevel = a;
		}
		
		for (int b : upSet) {
			if (startLevel != b) {
				printDownFirst.add(b);
				downFirstCost += Math.abs(startLevel - b);
				startLevel = b;
			}
		}
		return downFirstCost;
	}
	
	private int upFirstCost(int level) {
		printUpFirst.clear();
		int upFirstCost = 0;
		int startLevel = level;
		printUpFirst.add(startLevel);

		//first go to up
		for (int up : upSet) {
			if (startLevel != up) {
				printUpFirst.add(up);
				upFirstCost += Math.abs(startLevel - up);
				startLevel = up;
			}
		}

		ArrayList<Integer> reverseSet = new ArrayList<>();
		reverseSet.addAll(downSet);
		Collections.reverse(reverseSet);
		for (int a : reverseSet) {
			if (startLevel != a) {
				printUpFirst.add(a);
				upFirstCost += Math.abs(startLevel - a);
			}
			startLevel = a;
		}

		return upFirstCost;
	}

	StringBuilder printSequence(ArrayList<Integer> aList) {
		StringBuilder sb = new StringBuilder();
		for (int a : aList) {
			sb.append(a + " ");
		}
		return sb;
	}
	
}
