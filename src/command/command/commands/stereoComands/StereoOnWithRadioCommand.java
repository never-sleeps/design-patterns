package command.command.commands.stereoComands;

import command.command.commands.Command;
import command.command.receivers.Stereo;

public class StereoOnWithRadioCommand implements Command {
    Stereo stereo;

    /**
     * @param stereo экземпляр стереосистемы, который сохраняется в локальной переменной экземпляра
     */
    public StereoOnWithRadioCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    /**
     * Для включения стереосистемы необходимо: включить стереосистему, установить режим CD-диска
     */
    @Override
    public void execute() {
        stereo.on();
        stereo.setRadioMode();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
