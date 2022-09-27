package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class DeleteCustomerAction extends Action {
    public DeleteCustomerAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Kunde löschen");

        System.out.println("Eingeben der KundenId");
        int customerId = super.scanner.nextInt();

        super.bookStore.deleteCustomer(customerId);

        System.out.println("Kunde mit der ID" + customerId + " wurde erfolgreich gelöscht.");
    }

}
