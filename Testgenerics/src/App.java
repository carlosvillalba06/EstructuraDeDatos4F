import java.util.ArrayList;
import java.util.List;

public class App {

    public static <T> void printArray(T[] arr){
        for (T v : arr) {
            System.out.println(v);
        }

    }
    public static void main(String[] args) throws Exception {

        Box<String> box1 = new Box<>("Esto es una caja de strings");
        List<String> lista = new ArrayList<>();
        Box<Integer> box2 = new Box<>(2);
        System.out.println(box2.getValue());
        
        


        Pair<String, Integer> pair = new Pair<String,Integer>("Id", 3);
        System.out.println(box1.getValue());

        System.out.println("La key es: " + pair.getKey());
        System.out.println("Valor: " + pair.getValue());

        String[] arrayString = {"Hola1" , "Hola2", "Hola3"};
        Integer[] arrayInteger = {1,2,3,4};
        printArray(arrayString);
        System.out.println("============================");
        printArray(arrayInteger);
        System.out.println("============================");
        Student[] students = new Student[2];
        Student st1 = new Student(1, "Test1");
        Student st2 = new Student(2, "Test2");
        students[0] = st1;
        students[1] = st2;
        printArray(students);

        Worker[] workers = new Worker[2];
        Student wk1 = new Student(1, "worker1");
        Student wk2 = new Student(2, "worker2");
        students[0] = wk1;
        students[1] = wk2;
        printArray(workers);
        
    }
}
