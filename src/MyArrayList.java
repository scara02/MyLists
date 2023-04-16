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
    public void add(E element, int index) {
        if (index > size) throw new IndexOutOfBoundsException();

        if (size == arr.length) {
            increaseSize();
            arr[index] = element;
        }
        else {
            for (int i = size; i > index; i--) {
                arr[i] = arr[i - 1];
            }
            arr[index] = element;
        }
        size++;
    }

    @Override
    public E get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        return (E) arr[index];
    }

    @Override
    public boolean remove(E element) {
        for (int i = 0; i < size; i++) {
            if (arr[i] == element) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        for (int i = index; i < size; i ++) {
            arr[i] = arr[i + 1];
        }

        size--;

        return (E) arr[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) > -1;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            arr[i] = null;
        }
        size = 0;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if(o.equals(arr[i]))
                return i;
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = -1;
        for (int i = 0; i < size; i++) {
            if (o.equals(arr[i]))
                index = i;
        }

        return index;
    }

    @Override
    public void sort() {}

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
