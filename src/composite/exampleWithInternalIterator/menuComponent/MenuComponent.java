package composite.exampleWithInternalIterator.menuComponent;

/**
 * Задача этого класса - определение интерфейса листьев и комбинационных узлов.
 *
 * Класс представляем реализации по умолчанию для всех методов.
 * Так как одни методы имеют смысл только для MenuItem, а другие - только для Menu, реализация по умолчанию инициирует UnsupportedOperationException.
 * Если объект MenuItem или Menu не поддерживает операцию, ему не нужно ничего делать - он просто наследует реализацию по умолчанию.
 */
public abstract class MenuComponent {
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    public MenuComponent getChild(int i){
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public boolean isVegetarian() {
        throw new UnsupportedOperationException();
    }

    public void print() {
        throw new UnsupportedOperationException();
    }
}
