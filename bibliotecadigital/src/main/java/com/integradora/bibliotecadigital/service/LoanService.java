package com.integradora.bibliotecadigital.service;

import com.integradora.bibliotecadigital.model.Book;
import com.integradora.bibliotecadigital.model.HistoryAction;
import com.integradora.bibliotecadigital.model.Loan;
import com.integradora.bibliotecadigital.structures.Node;
import com.integradora.bibliotecadigital.structures.SinglyLinkedList;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    private SinglyLinkedList prestamos = new SinglyLinkedList();
    private int nextLoanId = 1;

    private final BookService bookService;
    private final UserService userService;
    private final HistoryService historyService;

    public LoanService(
            BookService bookService,
            UserService userService,
            HistoryService historyService
    ) {
        this.bookService = bookService;
        this.userService = userService;
        this.historyService = historyService;
    }

    public ResponseEntity<?> crearPrestamo(int userId, int bookId, String fecha) {

        if (userService.porId(userId) == null)
            return ResponseEntity.notFound().build();

        Book book = bookService.buscarPorId(bookId);
        if (book == null)
            return ResponseEntity.notFound().build();

        if (book.getAvailableCopies() > 0) {

            int prevCopies = book.getAvailableCopies();

            Loan loan = new Loan(
                    nextLoanId++,
                    userId,
                    bookId,
                    fecha
            );

            prestamos.add(loan);
            book.setAvailableCopies(prevCopies - 1);

            HistoryAction h = new HistoryAction();
            h.setActionType("CREATE_LOAN");
            h.setUserId(userId);
            h.setBookId(bookId);
            h.setLoanId(loan.getId());
            h.setPreviousAvailableCopies(prevCopies);

            historyService.push(h);

            return ResponseEntity.status(201).body(loan);
        }

        book.getWaitlist().offer(userId);

        HistoryAction h = new HistoryAction();
        h.setActionType("ADD_TO_WAITLIST");
        h.setUserId(userId);
        h.setBookId(bookId);

        historyService.push(h);

        return ResponseEntity.ok(
                "No hay copias disponibles. Estas en la lista de espera."
        );
    }

    public ResponseEntity<String> devolverLibro(int loanId) {

        Loan loan = buscarPrestamoPorId(loanId);
        if (loan == null)
            return ResponseEntity.notFound().build();

        if (!loan.isActive())
            return ResponseEntity.badRequest().body("El prestamo ya fue devuelto");

        loan.markAsReturned("HOY");

        Book book = bookService.buscarPorId(loan.getBookId());
        if (!book.getWaitlist().isEmpty()) {

            int nextUserId = book.getWaitlist().poll();

            Loan nuevoPrestamo = new Loan(
                    nextLoanId++,
                    nextUserId,
                    book.getId(),
                    "HOY"
            );

            prestamos.add(nuevoPrestamo);

            return ResponseEntity.ok(
                    "Libro devuelto. Prestamo automatico para usuario " + nextUserId
            );
        }

        book.setAvailableCopies(book.getAvailableCopies() + 1);

        return ResponseEntity.ok("Libro devuelto correctamente");
    }


    public SinglyLinkedList obtenerPrestamosActivos() {
        SinglyLinkedList activos = new SinglyLinkedList();
        Node actual = prestamos.head;

        while (actual != null) {
            Loan loan = (Loan) actual.data;
            if (loan.isActive())
                activos.add(loan);
            actual = actual.next;
        }
        return activos;
    }

    public SinglyLinkedList obtenerPrestamosPorUsuario(int userId) {
        SinglyLinkedList lista = new SinglyLinkedList();
        Node actual = prestamos.head;

        while (actual != null) {
            Loan loan = (Loan) actual.data;
            if (loan.getUserId() == userId)
                lista.add(loan);
            actual = actual.next;
        }
        return lista;
    }

    public Loan buscarPrestamoPorId(int id) {
        Node actual = prestamos.head;
        while (actual != null) {
            Loan loan = (Loan) actual.data;
            if (loan.getId() == id)
                return loan;
            actual = actual.next;
        }
        return null;
    }

    public void eliminarPrestamo(Loan loanABorrar) {
        Node actual = prestamos.head;
        Node anterior = null;

        while (actual != null) {
            if (actual.data == loanABorrar) {
                if (anterior == null) {
                    prestamos.head = actual.next;
                } else {
                    anterior.next = actual.next;
                }
                return;
            }
            anterior = actual;
            actual = actual.next;
        }
    }
}
