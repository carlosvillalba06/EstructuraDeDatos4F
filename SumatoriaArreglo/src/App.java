public class App {
    public static void main(String[] args) throws Exception {
        
        int[][] arrTes = {
            {1,3,7,8},
            {0,6,3,1},
            {1,2,3,4},
            {0,5,3,0},
            {2,5,9,0}
        };

        int sumaCompleta = 0;

        for (int i = 0; i < arrTes.length; i++) {
            for (int j = 0; j < arrTes[i].length; j++) {
                sumaCompleta += arrTes[i][j];
            }
        }

        System.out.println("La suma es: " + sumaCompleta);
    }
}
