package tarun.com.cmds;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class CommandReader {
	private String filePath;
	private ArrayList<Integer> initialPositions;
	private Hashtable<Integer, ArrayList<String>> strCmds;
	
	public CommandReader(String fileName) {
		filePath = fileName;
		strCmds = new Hashtable<>();
		initialPositions = new ArrayList<>();
	}
	
	public void readCommand() {
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = bufferReader.readLine()) != null) {
				processCmdLine(line);
			}
		} catch (IOException e) {
			System.err.println("File not found" + filePath);
		} finally {
			try {
				bufferReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public Hashtable<Integer, ArrayList<String>> getCmds() { return strCmds; }
	
	public ArrayList<Integer> getPositionList() { return initialPositions; }

	private void processCmdLine(String line) {
		String []str = line.split(":");
		String []cmds = str[1].split(",");
		ArrayList<String> list = new ArrayList<>();
		//System.out.print(str[0] + " ");
		for (String s : cmds) {
			list.add(s.trim());
			//System.out.print(s + " ");
		}
		//System.out.println(" ");
		initialPositions.add(Integer.parseInt(str[0].trim()));
		strCmds.put(Integer.parseInt(str[0].trim()), list);
	}
/**	
	public static void main(String[] args) {
		CommandReader cmdReader = new CommandReader("cmd.txt");
		cmdReader.readCommand();
	}
**/
}
