package cli;

import actions.PlaceInput;
import commands.HelpCommand;
import commands.MoveCommand;
import commands.PlaceCommand;
import commands.ReportCommand;
import commands.TurnLeftCommand;
import commands.TurnRightCommand;
import grid.Grid;
import interfaces.Command;
import java.util.HashMap;
import java.util.Map;
import robot.Robot;

public class CommandMap {
  private final Map<String, Command> commandMap;

  public CommandMap(Robot robot, Grid grid) {
    this.commandMap = placedCommands(robot, grid);
  }

  private Map<String, Command> placedCommands(Robot robot, Grid grid) {
    Map<String, Command> map = new HashMap<>();
    map.put("PLACE", new PlaceCommand(robot));
    map.put("MOVE", new MoveCommand(robot, grid));
    map.put("LEFT", new TurnLeftCommand(robot));
    map.put("RIGHT", new TurnRightCommand(robot));
    map.put("REPORT", new ReportCommand(robot));
    map.put("HELP", new HelpCommand());
    return map;
  }

  public Command getCommand(String commandKey) {
    return commandMap.get(commandKey);
  }


}
