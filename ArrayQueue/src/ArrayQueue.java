public class ArrayQueue <T> implements IQueue<Object>{
    private Object[] data;
    private int rear; //Indice de inserción
    private int front;//Indica el elemento al frente de la queue
    private int size; //Numero de elementos en la queue
    private static final int INITIAL_CAPACITY = 10; //Constante para el tamaño incial

    public ArrayQueue(){
        this.data = new Object[INITIAL_CAPACITY];
        this.rear = 0;
        this.front = 0;
        this.size = 0;
    }

    @Override
    public void offer(Object element) {
        // Verificar la capacidad del array
        expandCapacity();
        data[rear]  =element; //Pone el element en el indice adigando (rear)
        rear = (rear + 1) % data.length; //recalcula rear, para evitar el desborde
        size++;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object poll() {
        if (isEmpty()) {
            System.out.println("La Queue esta vacia");
            return null;
        }

        T result = (T) data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        return result;
    }
    @Override
    public Object peek() {
        if (isEmpty()) {
            System.out.println("La Queue esta vacia");
            return null;
        }

        return data[front];
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    private void expandCapacity(){
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
            if (i<size-1) sb.append("=>");
            
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getSize'");
    }

}
