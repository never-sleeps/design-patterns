package adapter.example;

import java.util.Enumeration;
import java.util.Iterator;

/**
 * Адаптер, преобразующий Iterator в Enumeration.
 *
 * Чтобы адаптер воспринимался клиентским кодом как Enumeration, он реализует интерфейс Enumeration.
 */
public class IteratorEnumerationAdapter implements Enumeration<Object> {
    Iterator<Object> iterator;

    public IteratorEnumerationAdapter(Iterator<Object> iterator) {
        this.iterator = iterator;
    }

    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public Object nextElement() {
        return iterator.next();
    }
}
