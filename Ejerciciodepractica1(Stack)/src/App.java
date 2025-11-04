public class App {
    public static void main(String[] args) throws Exception {
        
       ArrayStack<String> stack = new ArrayStack<>();

       System.out.println(stack.isPalindrome("hola"));
       System.out.println(stack.isPalindrome("anita lava la tina"));
       System.out.println(stack.isPalindrome("yo hago yoga hoy"));
    }
}
