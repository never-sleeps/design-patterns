package iterator.exampleWithIterator.iterators;

import iterator.exampleWithIterator.MenuItem;

import java.util.Iterator;

public class DinerMenuIterator implements Iterator<MenuItem> {
    MenuItem[] items;
    int position; // текущая позиция перебора в массиве

    /**
     * @param items Конструктор получает массив объектов, для перебора которых создаётся итератор
     */
    public DinerMenuIterator(MenuItem[] items) {
        this.items = items;
    }

    /**
     * Так как в нашем примере для перебора может быть использован массив максимального размера,
     * нужно проверить не только достижение границы массива, но и равенство следующего его элемента null (признак последнего элемента)
     * @return true, если в массиве еще остались элементы для перебора, или false
     */
    @Override
    public boolean hasNext() {
        return position < items.length && items[position] != null;
    }

    @Override
    public MenuItem next() {
        MenuItem menuItem = items[position];
        position = position + 1;
        return menuItem;
    }
}
