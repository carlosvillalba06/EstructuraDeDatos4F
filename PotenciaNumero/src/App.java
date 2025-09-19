public class App {

    public static int potencia(int a, int b){
        if(b == 0) {
            return 1;
        }

        return a * potencia(a, b - 1);
    }



    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
