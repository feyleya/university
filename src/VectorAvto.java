package lab3;

public class VectorAvto<T> {
    private int capacity = 10;
    private int size;
    private T[] array;

    public VectorAvto() {
        array = (T[]) new Object[capacity];
    }

    public VectorAvto(int length) {

        if (length <= 0) {
            throw new IllegalArgumentException("Размер массива должен быть больше 0!");
        } else {
            array = (T[]) new Object[length];
            capacity = length;
        }
    }

    private void growArray() {
        capacity = (int) (capacity * 1.5);
        T[] copyArray = (T[]) new Object[capacity];

        for (int i = 0; i < array.length; i++) {
            copyArray[i] = array[i];
        }
        array = copyArray;
    }

    public void add(T element) {
        if (size == array.length - 1) {
            growArray();
        }
        array[size] = element;
        size++;
    }

    public int indexOf(T element) {
        if(element == null){
            return -1;
        }
        for (int i = 0; i < array.length; i++) {
            if (element.equals(array[i]))
                return i;
        }
        return -1;
    }
}
