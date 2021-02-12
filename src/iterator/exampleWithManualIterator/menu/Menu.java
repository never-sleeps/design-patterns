package iterator.exampleWithManualIterator.menu;

import iterator.exampleWithManualIterator.iterators.Iterator;


/**
 * Простой интерфейс с методом, который возвращает клиентам итератор для элементов меню.
 */
public interface Menu {
    Iterator createIterator();
}
