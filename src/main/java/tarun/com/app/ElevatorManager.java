package tarun.com.app;

import tarun.com.cmds.CmdManager;
import tarun.com.cmds.Command;
import tarun.com.cmds.CommandReader;
import tarun.com.model.Elevator;
import tarun.com.model.ModeAElevator;
import tarun.com.model.ModeBElevator;

import java.util.ArrayList;
import java.util.Hashtable;

public class ElevatorManager {
	
	public static void ExeCommand(int level, ArrayList<Command> cmds) {
		Elevator[]elevator = {new ModeAElevator(), new ModeBElevator() };
		System.out.println(" ");
		for (int i = 0; i < 2; ++i) {
			String pathDistance = elevator[i].executeCommand(level, cmds);
			System.out.printf("%-64s", pathDistance);
			if (i == 0) {
				System.out.print("| ");
			}
		}
		
	}
	public static void printHead() {
		for (int i = 0; i < 128; ++i) {
			System.out.print("_");
		}
		System.out.println(" ");
		System.out.printf("%-64s", "Mode A");
		System.out.print("| ");
		System.out.printf("%-64s\n", "Mode B");
		//System.out.println("");
		for (int i = 0; i < 128; ++i) {
			System.out.print("-");
		}
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("specify command file name");
			//return;
		}
		CommandReader cr = new CommandReader("cmd.txt");
		//CommandReader cr = new CommandReader(args[0]);
		cr.readCommand();
		ArrayList<Integer> pos = cr.getPositionList();
		
		CmdManager cmdMan = new CmdManager(cr.getCmds());
		Hashtable<Integer, ArrayList<Command>> ht = cmdMan.getCommands();
		ElevatorManager.printHead();
		for (int p : pos) {
			ArrayList<Command> cmds = ht.get(p);
			ElevatorManager.ExeCommand(p, cmds);
 		}
	}

}
