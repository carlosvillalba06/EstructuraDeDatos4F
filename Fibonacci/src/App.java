public class App {

    public static int fibonacci(int n){

        if(n<=1) return n;
        return fibonacci(n -1 ) + fibonacci(n - 2);

    }
    public static void main(String[] args) throws Exception {

        int serie = 5;

        System.out.println("Los numeros son: ");
        for(int i = 0; i < serie;i++){
            System.out.println(fibonacci(i));
        }
       
    }
}
