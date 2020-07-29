package tarun.com.app;

import org.junit.Assert;
import org.junit.Test;
import tarun.com.cmds.Command;
import tarun.com.model.ModeAElevator;

import java.util.ArrayList;
public class ModeAElevatorTest {
	@Test
	public void test() {
		ModeAElevator maele = new ModeAElevator();
		Command cmd1 = new Command(5, 6);
		ArrayList<Command> al = new ArrayList<>();
		al.add(cmd1);
		String result = maele.executeCommand(5, al);
		Assert.assertEquals(result, "5 6 (1)");
	}

}
