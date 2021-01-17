package command.macroCommand.commands;

/**
 * Требуется для нажатий на кнопки, которым не заданы команды. В этом случае будет происходить "ничего".
 *
 * Объект NoCommand является примером пустого (null) объекта. Пустые объекты применяются тогда,
 * когда вернуть "полноценный" объект невозможно, но вам хочется избавить клиента от необходимости проверять null-ссылки.
 */
public class NoCommand implements Command {
    @Override
    public void execute() { }

    @Override
    public void undo() { }

}
