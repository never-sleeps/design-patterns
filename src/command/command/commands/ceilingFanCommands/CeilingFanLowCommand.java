package command.command.commands.ceilingFanCommands;

import command.command.commands.Command;
import command.command.receivers.CeilingFan;

public class CeilingFanLowCommand implements Command {
    private CeilingFan ceilingFan;
    int prevSpeed;

    public CeilingFanLowCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        this.prevSpeed = ceilingFan.getSpeed();
        ceilingFan.low();
    }

    /**
     * Этот метод возвращает вентилятор к предыдущей скорости
     */
    @Override
    public void undo() {
        if (prevSpeed == CeilingFan.HIGH) {
            ceilingFan.high();
        } if (prevSpeed == CeilingFan.LOW) {
            ceilingFan.low();
        } if (prevSpeed == CeilingFan.OFF) {
            ceilingFan.off();
        }
    }
}
