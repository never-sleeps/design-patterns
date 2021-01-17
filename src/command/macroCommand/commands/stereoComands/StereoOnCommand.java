package command.macroCommand.commands.stereoComands;


import command.macroCommand.commands.Command;
import command.macroCommand.receivers.Stereo;

public class StereoOnCommand implements Command {
    Stereo stereo;

    /**
     * @param stereo экземпляр стереосистемы, который сохраняется в локальной переменной экземпляра
     */
    public StereoOnCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
