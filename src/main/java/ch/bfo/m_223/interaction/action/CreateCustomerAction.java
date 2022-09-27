package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.CustomerDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class CreateCustomerAction extends Action {
    public CreateCustomerAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Kunde erstellen");
        CustomerDto kunde = new CustomerDto();

        System.out.println("Eingeben vom Name");
        kunde.setName(super.scanner.next());

        System.out.println("Eingeben vom Vorname");
        kunde.setPrename(super.scanner.next());

        var createdCustomer = super.bookStore.createCustomer(kunde);

        System.out.println("Kunde mit der ID" + createdCustomer.getCustomerId() + " wurde erfolgreich erstellt.");
    }

}
