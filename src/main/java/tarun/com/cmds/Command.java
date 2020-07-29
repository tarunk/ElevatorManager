package tarun.com.cmds;

public class Command {
	private int startFloor;
	private int endFloor;
	
	public Command(int first, int last) {
		startFloor = first;
		endFloor = last;
	}

	public int getStartFloor() {
		return startFloor;
	}

	public int getEndFloor() {
		return endFloor;
	}
	
}
