package command.command.commands.stereoComands;

import command.command.commands.Command;
import command.command.receivers.Stereo;

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
