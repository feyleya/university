package lab3;

import java.util.Arrays;

public class MyVector<T> {
    private int capacity = 10;
    private int size;
    private T[] array;

    public MyVector() {
        array = (T[]) new Object[capacity];
    }

   public MyVector(MyVector<T> copy) {
        this.size = getSize();
        this.capacity = getCapacity();
    }

    public MyVector(int length) {

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

    public void addByIndex(int index, T element) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Индекс массива полжен быть положительным!");
        }
        if (index >= array.length) {
            growArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    public void deleteByIndex(int index) {
        if (index > array.length - 1) {
            throw new ArrayIndexOutOfBoundsException("Такого индекса не существует!");
        }
        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }
        size--;
    }

    public void deleteLast() {
        for (int i = array.length - 1; i > 0; i--) {
            if (array[i] != null) {
                array[i] = null;
                break;
            }
        }
        size--;
    }

    public void addLast(T element) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null) {
                array[i + 1] = element;
                break;
            }
        }
        size++;
    }

    public void changeSize(int number) {
        T[] copyArray = (T[]) new Object[number];
        if (number < array.length) {
            System.arraycopy(array, 0, copyArray, 0, number);
        } else {
            for (int i = 0; i < copyArray.length; i++) {
                add(null);
            }
            System.arraycopy(array, 0, copyArray, 0, number);
        }
        array = copyArray;
        capacity = number;
    }

    public void remove() {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] != null) {
                array[i] = null;
                size--;
            }
        }
    }

    public void printArray() {
        for (T element : array) {
            System.out.print(element + " ");
        }
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void printSize() {
        System.out.println("\nТекущий размер массива: " + getSize());
    }

    public void printCapacity() {
        System.out.println("Максимальный размер массива: " + getCapacity());
    }
}
