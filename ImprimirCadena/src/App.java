public class App {

    public static String invertirCadena(String cadena){
        if (cadena.isEmpty()) return cadena;
        return invertirCadena(cadena.substring(1)) + cadena.charAt(0);
    }

    public static void main(String[] args) throws Exception {
        
        String cadenaOriginal = "Hola";

        System.out.println("Cadena sin invertir: " + cadenaOriginal);
    }
}

