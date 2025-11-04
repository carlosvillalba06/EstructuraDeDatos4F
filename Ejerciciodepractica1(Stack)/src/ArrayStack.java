public class ArrayStack<T> implements IStack<T> {


    private Object[] data;
    private int top;

    public ArrayStack(){
        this(10);
    }

    public ArrayStack(int initialCapacity){
        this.data = new Object[initialCapacity];
        this.top = 0;
    }

    @Override
    public void push(T element) {
        data[top++] = (T) element;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T pop() {
        if (isempty()) {
            System.out.println("La pila esta vacia");
            return null;
        }
        T value = (T) data[--top];
        data[top] = null;
        return value;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T peek() {
        if (isempty()) {
            System.out.println("La pila esta vacia");
            return null;
        }
        return (T) data[top];
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
    public boolean isempty() {
        return top == 0;
    }

    @Override
    public void print() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = top; i >= 0; i--) {
            sb.append(data[i]);
            if (i != 0) sb.append("=>");
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    
public boolean isPalindrome(String text) {
    String limpiarTexto = "";
    for (int i = 0; i < text.length(); i++) {
        char c = text.charAt(i);
        if (c != ' ') { 
            limpiarTexto += c;
        }
    }

    ArrayStack<Character> pila = new ArrayStack<>(limpiarTexto.length());

    for (int i = 0; i < limpiarTexto.length(); i++) {
        pila.push(limpiarTexto.charAt(i));
    }

    for (int i = 0; i < limpiarTexto.length(); i++) {
        if (limpiarTexto.charAt(i) != pila.pop()) {
            return false;
        }
    }

    return true;
}



}
