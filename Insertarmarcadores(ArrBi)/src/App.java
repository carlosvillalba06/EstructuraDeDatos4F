public class App {
    public static void main(String[] args) throws Exception {

        int[][] arregloEntrada = {

            {1},           // impar -> agrega 0
            {6,3,1},       // impar -> agrega 0
            {1,2,3},     // par   -> agrega (1+4)=5
            {0,5,3,0},     // par   -> agrega (0+0)=0
            {2,5,9},       // impar -> agrega 0
            {2,4,8,9,10,1}
        };
        System.out.println("======Entrada========");
        for (int i = 0; i < arregloEntrada.length; i++) {
            for (int j = 0; j < arregloEntrada[i].length; j++) {
                System.out.print(" " + arregloEntrada[i][j]);
            }
            System.out.println();
        }
        
        int[][] arregloSalida = new int[arregloEntrada.length][];

        for (int i = 0; i < arregloEntrada.length; i++){

            arregloSalida[i] = new int[arregloEntrada[i].length + 1];

            for (int j = 0; j < arregloEntrada[i].length; j++){

                arregloSalida[i][j] = arregloEntrada[i][j];
            }

            if (arregloEntrada[i].length % 2 == 0) {
                
                arregloSalida[i][arregloSalida[i].length - 1] = arregloEntrada[i][0] + arregloEntrada[i][arregloEntrada[i].length - 1];
            }else{

                arregloSalida[i][arregloSalida[i].length - 1] = 0;
            }
        }
        System.out.println("=======Salida=======");
        for(int i = 0; i < arregloSalida.length; i++){
            for (int j = 0; j < arregloSalida[i].length; j++) {
                System.out.print(" " + arregloSalida[i][j]);
            }
            System.out.println();
        }
    }
}
