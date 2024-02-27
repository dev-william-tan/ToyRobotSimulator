package actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

import commands.HelpCommand;
import org.junit.jupiter.api.Test;

public class HelpCommandTest {

  @Test
  void testHelpCommand() {
    HelpCommand helpCommand = new HelpCommand();
    boolean result = helpCommand.execute();

    assertTrue(result);
  }
}
