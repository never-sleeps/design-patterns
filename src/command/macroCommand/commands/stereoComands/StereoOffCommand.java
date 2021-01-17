package command.macroCommand.commands.stereoComands;


import command.macroCommand.commands.Command;
import command.macroCommand.receivers.Stereo;

public class StereoOffCommand implements Command {
    Stereo stereo;

    /**
     * @param stereo экземпляр стереосистемы, который сохраняется в локальной переменной экземпляра
     */
    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.on();
    }
}
