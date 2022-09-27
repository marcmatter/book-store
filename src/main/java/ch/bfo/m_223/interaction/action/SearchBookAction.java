package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.BookDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.List;
import java.util.Scanner;

public class SearchBookAction extends Action {
    public SearchBookAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Suche nach Büchern");

        System.out.println("Eingeben vom Suchtext");
        String searchtext = super.scanner.next();

        List<BookDto> results = super.bookStore.searchBook(searchtext);

        System.out.println("Suche wurde erfolgreich abgesetzt und liefert " + results.size() + " Resultate");

        for (BookDto buch : results) {
            System.out.println("\t" + buch);
        }
    }

}
