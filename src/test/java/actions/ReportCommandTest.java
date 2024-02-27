package actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import commands.ReportCommand;
import grid.Grid;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import robot.Robot;

public class ReportCommandTest {

  private Robot robot;
  private Grid grid;

  @BeforeEach
  public void setUp() {
    robot = new Robot();
    grid = new Grid(robot);
  }

  @Test
  void testReportCommand() {
    robot.place(0,0, "NORTH");
    ReportCommand report = new ReportCommand(robot);

    //Read printed to console output
    ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStreamCaptor));

    boolean result = report.execute();

    assertTrue(result);
    assertEquals("Robot's current position and direction: 0,0,NORTH",
        outputStreamCaptor.toString().trim() );
  }
}
