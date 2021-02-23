package composite.exampleWithExternalIterator;

import composite.exampleWithExternalIterator.menuComponent.MenuComponent;

import java.util.Iterator;

/**
 *
 */
public class Waitress {
    private MenuComponent allMenus;

    /**
     * Мы просто передаём компонент меню верхнего уровня - тот, который содержит остальные меню (корень дерева).
     * @param allMenus меню верхнего уровня
     */
    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    /**
     * Чтобы вывести всю иерархию меню - все меню и все их элементы - достаточно вызвать print() для меню верхнего урвоня
     */
    public void printMenu() {
        allMenus.print();
    }

    /**
     * Метод получает комбинацию allMenus и создает для неё итератор (класс CompositeIterator)
     *
     * В этом коде реализуется внешний итератор, поэтому нам приходится учитывать много дополнительных обстоятельств.
     * Для начала, внешний итератор должен сохранять текущую позицию перебора, чтобы внешний клиент мог управлять перебором,
     * вызывая методы hasNext() и next(). Но в нашей ситуации код должен сохранять текущую позицию в комбинационной рекурсивной структуре.
     * По этой причине для отслеживания текущей позиции при перемещении вверх­вниз по комбинационной иерархии используются стеки.
     */
    public void printVegetarianMenu() {
        Iterator<MenuComponent> iterator = allMenus.createIterator();
        System.out.println("\nVEGETARIAN MENU\n---");
        // перебор всех элементов комбинации
        while (iterator.hasNext()) {
            MenuComponent menuComponent = iterator.next();
            try {
                // для каждого элемента вызывается isVegetarian(), печатаются элементы со значением true
                if (menuComponent.isVegetarian()) {
                    // метод print() вызывается всегда для MenuItem и никогда для комбинаций (Menu),
                    menuComponent.print();
                }
            } catch (UnsupportedOperationException ignored) {
                // реализация isVegetarian для Menu всегда генерирует UnsupportedOperationException.
                // Если это произойдет, мы перехватим исключение и продолжим перебор
            }
        }
    }
}
