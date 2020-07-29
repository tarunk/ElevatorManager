package tarun.com.app;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import tarun.com.cmds.Command;
import tarun.com.model.Elevator;
import tarun.com.model.ModeBElevator;


public class ModeBElevetorTest {

	@Test
	public void test() {
		Elevator maele = new ModeBElevator();
		Command cmd1 = new Command(5, 6);
		Command cmd2 = new Command(4, 6);
		ArrayList<Command> al = new ArrayList<>();
		al.add(cmd1);
		al.add(cmd2);
		String result = maele.executeCommand(5, al);
		assertEquals(result, "5 4 5 6 (3)");
	}

}
