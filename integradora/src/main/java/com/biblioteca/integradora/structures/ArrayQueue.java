package com.biblioteca.integradora.structures;

public class ArrayQueue<T> implements IQueue<T> {

    private Object[] data;
    private int rear; //Indice de inserción
    private int front;//Indica el elemento al frente de la queue
    private int size; //Numero de elementos en la queue
    private static final int INITIAL_CAPACITY = 10; //Constante para el tamaño incial

    public ArrayQueue() {
        this.data = new Object[INITIAL_CAPACITY];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    @Override
    public void offer(T element) {
         // Verificar la capacidad del array
        expandCapacity();
        data[rear] = element; //Pone el element en el indice adigando (rear)
        rear = (rear + 1) % data.length; //recalcula rear, para evitar el desborde
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T poll() {
        if (isEmpty()) {
            System.out.println("La Queue está vacía");
            return null;
        }

        T result = (T) data[front];
        data[front] = null;

        front = (front + 1) % data.length;
        size--;
        return result;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("La Queue está vacía");
            return null;
        }

        return (T) data[front];
    }

    @Override
    public void clear() {
        data = new Object[INITIAL_CAPACITY];
        size = 0;
        front = 0;
        rear = 0;
    }

    private void expandCapacity() {
        if (size < data.length)
            return;

        Object[] newArr = new Object[data.length * 2];//Creacion de nuevo arreglo

        for (int i = 0; i < size; i++) {
            newArr[i] = data[(front + i) % data.length]; //Vaciado de la info comenzando desde front
        }
        //Reiniciamos los valores del arreglo para poderlo seguir usando
        front = 0;//Pone al frente en la primera posicion
        data = newArr; //Asignamos el nuevo arreglo al atributo data
        rear=size; //Indice de la siguiente inserción
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < size - 1)
                sb.append(" => ");
        }

        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;//Si soize esta fvacia 
    }

    @Override
    public int getSize() {
        return size;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size)
            return null;
        return (T) data[(front + index) % data.length];

    }

    @SuppressWarnings("unchecked")
    public int indexOf(T element) {
        for (int i = 0; i < size; i++) {
            T value = (T) data[(front + i) % data.length];
            if (value.equals(element))
                return i;
        }
        return -1;
    }

}

