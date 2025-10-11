public class App {
    public static void main(String[] args) throws Exception {
        
         int[][] arrTest={
            {1},
            {6,3,1},
            {1,2,3,4},
            {0,5,3,0},
            {2,5,9},
            {2,4,8,9,10}
        };
        
         System.out.println("================Original=========");
        for (int i = 0; i < arrTest.length; i++) {
            for (int j = 0; j < arrTest[i].length; j++) {
                System.out.print(" " + arrTest[i][j]);
            }
            System.out.println();
        }


        int[][] arrTestNuevo = new int[arrTest.length][];

        for (int i = 0; i < arrTest.length; i++) {
        
            arrTestNuevo[i] = new int[arrTest[i].length + 1];
            
        

        for(int j = 0; j < arrTest[i].length; j++){
            arrTestNuevo[i][j] = arrTest[i][j];
        }

            arrTestNuevo[i][arrTestNuevo[i].length - 1] = arrTest[i][arrTest[i].length - 1] + 1;
 
        }
    
        System.out.println("================Modificado=========");
        for(int i = 0; i < arrTestNuevo.length; i++){
            for(int j = 0; j < arrTestNuevo[i].length; j++){
                System.out.print(" " + arrTestNuevo[i][j]);
            }
            System.out.println();
        }
    
    }

    
}
