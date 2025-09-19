public class App {
   

    public static int suma(int n){
        if (n == 0)  return 0;

        return n + suma(n - 1);

    }
     public static void main(String[] args) throws Exception {

        int n = 5;

        System.out.println("La suma es: " + suma(n));
        
        
    }
}
