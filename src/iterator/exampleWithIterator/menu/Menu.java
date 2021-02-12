package iterator.exampleWithIterator.menu;

import iterator.exampleWithIterator.MenuItem;

import java.util.Iterator;

/**
 * Простой интерфейс с методом, который возвращает клиентам итератор для элементов меню.
 */
public interface Menu {
    Iterator<MenuItem> createIterator();
}
