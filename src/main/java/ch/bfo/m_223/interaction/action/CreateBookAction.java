package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.BookDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class CreateBookAction extends Action {
    public CreateBookAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Buch erstellen");
        BookDto buch = new BookDto();

        System.out.println("Eingeben vom Titel");
        buch.setTitel(super.scanner.next());

        System.out.println("Eingeben vom Autor");
        buch.setAuthor(super.scanner.next());

        System.out.println("Eingeben vom Verlag");
        buch.setPublisher(super.scanner.next());

        System.out.println("Eingeben vom Genre");
        buch.setGenre(super.scanner.next());

        var createdBook = super.bookStore.createBook(buch);

        System.out.println("Buch mit der ID" + createdBook.getBookId() + " wurde erfolgreich erstellt.");
    }

}
