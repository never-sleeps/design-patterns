package composite.exampleWithExternalIterator;

import java.util.Iterator;

/**
 * Класс - реализация пустого итератора. Нужен для реализации метода createIterator() для MenuItem
 */
public class NullIterator implements Iterator {
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Object next() {
        return null;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
