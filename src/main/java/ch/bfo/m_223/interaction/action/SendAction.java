package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class SendAction extends Action {
    public SendAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Bestellung versenden");

        System.out.println("Eingeben der BestellId");
        int orderId = super.scanner.nextInt();

        super.bookStore.sendOrder(orderId);

        System.out.println("Bestellung wurde erfolgreich versendet.");
    }

}
