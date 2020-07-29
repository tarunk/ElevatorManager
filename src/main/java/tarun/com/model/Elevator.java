package tarun.com.model;

import tarun.com.cmds.Command;

import java.util.ArrayList;

public interface Elevator {
	public String executeCommand(int level, ArrayList<Command> cmds);
}
