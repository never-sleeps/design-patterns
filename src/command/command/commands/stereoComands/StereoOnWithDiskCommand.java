package command.command.commands.stereoComands;

import command.command.commands.Command;
import command.command.receivers.Stereo;

public class StereoOnWithDiskCommand implements Command {
    Stereo stereo;

    /**
     * @param stereo экземпляр стереосистемы, который сохраняется в локальной переменной экземпляра
     */
    public StereoOnWithDiskCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * Для включения стереосистемы необходимо: включить стереосистему, установить режим CD-диска
     */
    @Override
    public void execute() {
        stereo.on();
        stereo.setDiskMode();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
