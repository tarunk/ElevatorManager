package tarun.com.cmds;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

public class CmdManager {
	private Hashtable<Integer, ArrayList<Command>> cMap;
	
	public CmdManager(Hashtable<Integer, ArrayList<String>> strCmds) {
		cMap = new Hashtable<>();
		for (Map.Entry<Integer, ArrayList<String>> entry : strCmds.entrySet()) {
			int key = entry.getKey().intValue();
			ArrayList<String> lst = entry.getValue();
			
			setCommands(key, lst);
		}
	}
	
	public Hashtable<Integer, ArrayList<Command>> getCommands() {
		return cMap;
	}
	
	private void setCommands(int level, ArrayList<String> list) {
		ArrayList<Command> lst = new ArrayList<Command>();
		
		for (String s : list) {
			lst.add(getCommandObj(s));
		}
		
		cMap.put(level, lst);
	}
	
	
	
	private Command getCommandObj(String strCmd) {
		String []levels = strCmd.split("-");
		Command cmd  = new Command(Integer.parseInt(levels[0].trim()), Integer.parseInt(levels[1].trim()));
		
		return cmd;
	}

}
