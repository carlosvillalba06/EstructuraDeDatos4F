package com.integradora.bibliotecadigital.structures;

public class ArrayStack<T> implements IStack<T> {

    private Object[] data;
    private int top;

    private static final int INITIAL_CAPACITY = 10;

    // Constructor 1
    public ArrayStack() {
        this(INITIAL_CAPACITY);
    }

    // Constructor 2
    public ArrayStack(int initialCapacity) {
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        // nos vamos a asegurar que aun tenga espacio el array
        expandCapacity();
        data[top++] = element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }

        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La pila está vacía");
            return null;
        }
        return (T) data[top - 1];
    }

    @Override
    public void clear() {
        for (int i = 0; i < top; i++) {
            data[i] = null;
        }
        top = 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top - 1; i >= 0; i--) {
            sb.append(data[i]);
            if (i != 0)
                sb.append(" -> ");// Separador mientras sea diferente de 0
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    private void expandCapacity() {
        if (top < data.length)
            return;

        Object[] newArr = new Object[data.length * 2];
        for (int i = 0; i < top; i++) {
            newArr[i] = data[i];
        }
        data = newArr;
    }

    public Object[] mostrarLista() {
    Object[] arr = new Object[top];
    for (int i = 0; i < top; i++) {
        arr[i] = data[i];
    }
    return arr;
}

}
