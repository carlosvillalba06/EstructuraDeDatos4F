package com.biblioteca.integradora.service;

import com.biblioteca.integradora.model.Book;
import com.biblioteca.integradora.model.Loan;
import com.biblioteca.integradora.structures.ArrayQueue;
import com.biblioteca.integradora.structures.ArrayStack;
import com.biblioteca.integradora.structures.Node;
import com.biblioteca.integradora.structures.SinglyLinkedList;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private final SinglyLinkedList prestamos = new SinglyLinkedList();
    private final ArrayStack<String> historial = new ArrayStack<>();
    private int proximoIdPrestamo = 1;

    private final BookService servicioLibros;
    private final UserService servicioUsuarios;

    public LoanService(BookService servicioLibros, UserService servicioUsuarios) {
        this.servicioLibros = servicioLibros;
        this.servicioUsuarios = servicioUsuarios;
    }

    public String crearPrestamo(int idUsuario, int idLibro) {
        Book libro = servicioLibros.buscarPorId(idLibro);
        if (libro == null)
            return "Libro no encontrado";
        if (servicioUsuarios.buscarPorId(idUsuario) == null)
            return "Usuario no encontrado";

        if (libro.getAvailableCopies() > 0) {
            
            Loan prestamo = new Loan(proximoIdPrestamo++, idUsuario, idLibro, false);
            prestamos.add(prestamo);

            libro.setAvailableCopies(libro.getAvailableCopies() - 1);

            historial.push("CREATE_LOAN:" + prestamo.getId());

            return "Préstamo creado";

        } else {
            libro.getWaitList().offer(idUsuario);
            historial.push("ADD_TO_WAITLIST:" + idUsuario + ":" + idLibro);
            return "No hay copias disponibles. Usuario agregado a lista de espera";
        }
    }

    public String devolverLibro(int idPrestamo) {
        var actual = prestamos.head;

        while (actual != null) {
            Loan prestamo = (Loan) actual.data;

            if (prestamo.getId() == idPrestamo && !prestamo.isReturned()) {

                prestamo.setReturned(true);
                Book libro = servicioLibros.buscarPorId(prestamo.getBookId());
                if (libro == null)
                    return "Libro no encontrado";

                if (!libro.getWaitList().isEmpty()) {
                    
                    int proximoIdUsuario = libro.getWaitList().poll();
                    
                    Loan prestamoAutomatico = new Loan(proximoIdPrestamo++, proximoIdUsuario, libro.getId(), false);
                    prestamos.add(prestamoAutomatico);

                    historial.push("AUTO_LOAN:" + prestamoAutomatico.getId());

                    return "Libro devuelto. Préstamo automático para usuario " + proximoIdUsuario;
                }

                libro.setAvailableCopies(libro.getAvailableCopies() + 1);

                historial.push("RETURN_LOAN:" + prestamo.getId());
                return "Libro devuelto correctamente";
            }

            actual = actual.next;
        }

        return "Préstamo no encontrado";
    }

    public SinglyLinkedList obtenerPrestamosActivos() {
        SinglyLinkedList activos = new SinglyLinkedList();
        var actual = prestamos.head;

        while (actual != null) {
            Loan prestamo = (Loan) actual.data;
            if (!prestamo.isReturned())
                activos.add(prestamo);
            actual = actual.next;
        }

        return activos;
    }

    public SinglyLinkedList obtenerPrestamosPorUsuario(int idUsuario) {
        SinglyLinkedList resultado = new SinglyLinkedList();
        var actual = prestamos.head;

        while (actual != null) {
            Loan prestamo = (Loan) actual.data;
            if (prestamo.getUserId() == idUsuario)
                resultado.add(prestamo);
            actual = actual.next;
        }

        return resultado;
    }

    public int obtenerPosicionReserva(int idLibro, int idUsuario) {
        Book libro = servicioLibros.buscarPorId(idLibro);
        if (libro == null)
            return -1;

        var cola = libro.getWaitList();

        int posicion = 1;
        for (int i = 0; i < cola.getSize(); i++) {
            if (cola.get(i) == idUsuario)
                return posicion;

            posicion++;
        }
        return -1;
    }

    public String cancelarReserva(int idLibro, int idUsuario) {
        Book libro = servicioLibros.buscarPorId(idLibro);
        if (libro == null)
            return "Libro no encontrado";

        ArrayQueue<Integer> colaVieja = libro.getWaitList();
        ArrayQueue<Integer> colaNueva = new ArrayQueue<>();

        boolean removido = false;

        while (!colaVieja.isEmpty()) {
            int valor = colaVieja.poll();
            if (valor != idUsuario)
                colaNueva.offer(valor);
            else
                removido = true;
        }

        libro.setWaitList(colaNueva);

        return removido ? "Reserva cancelada" : "Usuario no estaba en cola";
    }

    public ArrayStack<String> obtenerPilaHistorial() {
        return historial;
    }

    public Loan buscarPrestamoPorId(int id) {
        var actual = prestamos.head;
        while (actual != null) {
            Loan prestamo = (Loan) actual.data;
            if (prestamo.getId() == id)
                return prestamo;
            actual = actual.next;
        }
        return null;
    }

    public void eliminarPrestamo(Loan prestamoAborrar) {
        Node actual = prestamos.head;
        Node anterior = null;

        while (actual != null) {
            if (actual.data == prestamoAborrar) {
                if (anterior == null) {
                    // Borrar el primero
                    prestamos.head = actual.next;
                } else {
                    // Borrar en medio o final
                    anterior.next = actual.next;
                }
                return;
            }
            anterior = actual;
            actual = actual.next;
        }
    }
}