package iterator.exampleWithManualIterator.iterators;

import iterator.exampleWithManualIterator.MenuItem;

import java.util.ArrayList;

public class BreakfastMenuIterator implements Iterator {
    ArrayList<MenuItem> items;
    int position = 0;

    public BreakfastMenuIterator(ArrayList<MenuItem> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        Object object = items.get(position);
        position += 1;
        return object;
    }
}
