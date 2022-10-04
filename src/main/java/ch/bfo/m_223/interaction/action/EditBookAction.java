package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.BookDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class EditBookAction extends Action {
    public EditBookAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Buch bearbeiten");
        BookDto buch = new BookDto();
        
        System.out.println("Eingeben der Id");
        buch.setBookId(super.scanner.nextInt());

        System.out.println("Eingeben vom Titel");
        buch.setTitel(super.scanner.next());

        System.out.println("Eingeben vom Autor");
        buch.setAuthor(super.scanner.next());

        System.out.println("Eingeben vom Verlag");
        buch.setPublisher(super.scanner.next());

        System.out.println("Eingeben vom Genre");
        buch.setGenre(super.scanner.next());

        var editedBook = super.bookStore.editBook(buch);

        System.out.println("Buch mit der ID" + editedBook.getBookId() + " wurde erfolgreich bearbeitet.");
    }

}
