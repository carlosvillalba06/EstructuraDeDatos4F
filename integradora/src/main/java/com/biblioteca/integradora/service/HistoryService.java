package com.biblioteca.integradora.service;

import com.biblioteca.integradora.structures.ArrayStack;
import com.biblioteca.integradora.model.Loan;
import com.biblioteca.integradora.model.Book;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    private final ArrayStack<String> historial;
    private final LoanService servicioPrestamos;
    private final BookService servicioLibros;

    public HistoryService(LoanService servicioPrestamos, BookService servicioLibros) {
        this.servicioPrestamos = servicioPrestamos;
        this.servicioLibros = servicioLibros;

        this.historial = servicioPrestamos.obtenerPilaHistorial();
    }

    public String deshacer() {

        if (historial.isEmpty())
            return "No hay acciones para deshacer";

        String accion = historial.pop(); 

        
        if (accion.startsWith("CREATE_LOAN:"))
            return deshacerCrearPrestamo(Integer.parseInt(accion.split(":")[1]));

        if (accion.startsWith("RETURN_LOAN:"))
            return deshacerDevolverPrestamo(Integer.parseInt(accion.split(":")[1]));

        if (accion.startsWith("ADD_TO_WAITLIST:")) {
            String[] partes = accion.split(":");
            return deshacerAgregarACola(Integer.parseInt(partes[1]), Integer.parseInt(partes[2]));
        }

        if (accion.startsWith("AUTO_LOAN:"))
            return deshacerAutoPrestamo(Integer.parseInt(accion.split(":")[1]));

        return "Acción no soportada";
    }

    private String deshacerCrearPrestamo(int id) {
        Loan prestamo = servicioPrestamos.buscarPrestamoPorId(id);
        if (prestamo == null) return "No existe préstamo para revertir";

        Book libro = servicioLibros.buscarPorId(prestamo.getBookId());

        servicioPrestamos.eliminarPrestamo(prestamo);
        libro.setAvailableCopies(libro.getAvailableCopies() + 1);

        return "Se deshizo CREATE_LOAN";
    }

    private String deshacerDevolverPrestamo(int id) {
        Loan prestamo = servicioPrestamos.buscarPrestamoPorId(id);
        if (prestamo == null) return "No existe préstamo para revertir";

        prestamo.setReturned(false);

        Book libro = servicioLibros.buscarPorId(prestamo.getBookId());
        libro.setAvailableCopies(libro.getAvailableCopies() - 1);

        return "Se deshizo RETURN_LOAN";
    }

    private String deshacerAutoPrestamo(int id) {
        Loan prestamo = servicioPrestamos.buscarPrestamoPorId(id);
        if (prestamo == null) return "No existe auto-préstamo";

        servicioPrestamos.eliminarPrestamo(prestamo);

        Book libro = servicioLibros.buscarPorId(prestamo.getBookId());
        libro.getWaitList().offer(prestamo.getUserId());

        return "Se deshizo AUTO_LOAN";
    }

    private String deshacerAgregarACola(int idUsuario, int idLibro) {
        String resultado = servicioPrestamos.cancelarReserva(idLibro, idUsuario);

        if (resultado.equals("Reserva cancelada")) {
            return "Se deshizo ADD_TO_WAITLIST. Usuario " + idUsuario + " removido de la cola del libro " + idLibro;
        }

        return "No se pudo revertir ADD_TO_WAITLIST (Usuario no se encontró en la cola)";
    }

    public ArrayStack<String> obtenerHistorial() {
        return historial;
    }
}