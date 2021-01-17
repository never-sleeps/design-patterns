package command.macroCommand;

import command.macroCommand.commands.Command;

public class MacroCommand implements Command {
    Command[] commands;

    /**
     * @param commands массив команд
     */
    public MacroCommand(Command[] commands) {
        this.commands = commands;
    }

    /**
     * При выполнении макрокоманды все эти команды будут последовательно выполнены
     */
    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }

    @Override
    public void undo() {
        for (Command command : commands) {
            command.undo();
        }
    }
}
