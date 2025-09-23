public class App {
    public static void main(String[] args) throws Exception {
        ListaMaterias lista = new ListaMaterias();
        lista.agregarMateria("Matematicas");
        lista.agregarMateria("Fisica");
        lista.agregarMateria("Quimica");
        lista.agregarMateria("Historia");
        lista.agregarMateria("Programacion");

        lista.imprimir();

        String buscarMateria = "Calculo diferencial";
        System.out.println("Busqueda: " + buscarMateria);

        if (lista.contiene(buscarMateria)){
            System.out.println("Resulatdo: Materia encontrada");
        }else{
            System.out.println("Resultado: Materia no encontrada");
        }
    }
}
