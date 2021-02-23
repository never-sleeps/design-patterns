package composite.exampleWithExternalIterator;

import composite.exampleWithExternalIterator.menuComponent.Menu;
import composite.exampleWithExternalIterator.menuComponent.MenuComponent;

import java.util.Iterator;
import java.util.Stack;

/**
 * НЕТРИВИАЛЬНЫЙ итератор:
 * он перебирает элементы MenuItem в комбинации и следит за тем, чтобы в перебор были включены все дочерние меню (а так же их дочерние меню и т.д.)
 */
public class CompositeIterator implements Iterator<MenuComponent> {
    Stack<Iterator<MenuComponent>> stack = new Stack<>();

    /**
     * @param iterator итератор комбинации верхнего уровня, мы сохраняем его в стеке.
     */
    public CompositeIterator(Iterator<MenuComponent> iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        // Чтобы проверить существование следующего элемента, мы проверяем пуст ли стек
        if (stack.empty()) {
            return false;
        } else {
            // Есл стек не пуст, читаем из стека верхний итератор
            Iterator<MenuComponent> iterator = stack.peek();
            // и проверяем есть ли в стеке следующий элемент
            if (!iterator.hasNext()) {
                // Если нет, то метод извлекает компонент из стека и рекурсивно вызывает hasNext()
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    /**
     * @return В любом случае метод возвращает компонент
     */
    @Override
    public MenuComponent next() {
        // Сначала мы запрашиваем следующий элемент, существование которого проверяем вызовом hasNext().
        if(hasNext()) {
            // Если следующий элемент существует, мы извлекаем текущий итератор из стека и получаем следующий элемент.
            Iterator<MenuComponent> iterator = stack.peek();
            MenuComponent menuComponent = iterator.next();
            // Если компонент относится к классу Menu - обнаружена очередная комбинация, которую необходимо включить в перебор
            if (menuComponent instanceof Menu) {
                // соответственно, мы заносим его в стек
                stack.push(((Menu) menuComponent).createIterator());
            }
            return menuComponent;
        } else {
            return null;
        }
    }
}
