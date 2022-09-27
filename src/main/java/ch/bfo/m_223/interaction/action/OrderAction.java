package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class OrderAction extends Action {
    public OrderAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Bestellung erfassen");

        System.out.println("Eingeben der KundenId");
        int custmerId = super.scanner.nextInt();

        System.out.println("Eingeben der BuchId");
        int bookId = super.scanner.nextInt();

        int orderId = super.bookStore.order(custmerId, bookId);

        System.out.println("Bestellung wurde erfolgreich erfasst und hat die ID: " + orderId);
    }

}
