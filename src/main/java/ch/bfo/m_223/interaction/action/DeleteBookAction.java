package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class DeleteBookAction extends Action {
    public DeleteBookAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Buch löschen");

        System.out.println("Eingeben der BuchId");
        int bookId = super.scanner.nextInt();

        super.bookStore.deleteBook(bookId);

        System.out.println("Buch mit der ID" + bookId + " wurde erfolgreich gelöscht.");
    }

}
