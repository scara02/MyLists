import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    private Object[] arr;
    private int size;

    public MyArrayList() {
        this(6);
    }

    public MyArrayList(int initialSize) {
        arr = new Object[initialSize];
    }

    public void increaseSize() {
        int increasedSize = size * 2;
        Object[] newArr = new Object[increasedSize];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }

        arr = newArr;
    }

    @Override
    public void add(E element) {
        if (size == arr.length) {
            increaseSize();
        }

        arr[size++] = element;
    }

    @Override
    public E get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        return (E) arr[index];
    }

    @Override
    public void remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        for (int i = index; i < size; i ++) {
            arr[i] = arr[i + 1];
        }

        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private int cursor;

        @Override
        public boolean hasNext() {
            return cursor < size();
        }

        @Override
        public E next() {
            return get(cursor++);
        }
    }
}
