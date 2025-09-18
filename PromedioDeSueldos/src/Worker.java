public class Worker {

    private int id;
    private String nombre;
    private double sueldo;

    public Worker (int id, String nombre, double sueldo){

        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;

    }
    public int getId(){

        return id;
    }

    public String getNombre(){

        return nombre;
    }

    public double getSueldo(){

        return sueldo;
    }

}
