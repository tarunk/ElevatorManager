package tarun.com.model;

import tarun.com.cmds.Command;

import java.util.ArrayList;

public class ModeAElevator implements Elevator {
	private ArrayList<Integer> queue;
	
	public ModeAElevator() {
		queue = new ArrayList<Integer>();
	}
	
	@Override
	public String executeCommand(int level, ArrayList<Command> cmds) {
		queue.clear();
		int distance = calculateDistance(level, cmds);
		
		StringBuilder sb = print();
		sb.append("(" + distance + ")");
		return sb.toString();
	}
	
	private int calculateDistance(int level, ArrayList<Command> cmds) {
		int levelCount = 0;
		int startLevel = level;
		queue.add(startLevel);
		
		for (Command cmd : cmds) {
			int sLevel = cmd.getStartFloor();
			if (startLevel != sLevel) {
				queue.add(sLevel);
			}
			int eLevel = cmd.getEndFloor();
			queue.add(eLevel);
			levelCount += Math.abs(startLevel - sLevel) + Math.abs(eLevel - sLevel);
			startLevel = eLevel;
		}
		
		return levelCount;
	}
	
	private StringBuilder print() {
		StringBuilder sb = new StringBuilder();
		for (Integer a : queue) {
			sb.append(a.intValue() + " ");
		}
		
		return sb;
	}
}


