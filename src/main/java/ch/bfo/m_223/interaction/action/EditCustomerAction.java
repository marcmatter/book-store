package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.CustomerDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

public class EditCustomerAction extends Action {
    public EditCustomerAction(Scanner scanner, IBookStore bookStore) {
        super(scanner, bookStore);
    }

    @Override
    public void executeAction() {
        System.out.println("Kunde bearbeiten");
        CustomerDto kunde = new CustomerDto();

        System.out.println("Eingeben der Id");
        kunde.setCustomerId(super.scanner.nextInt());
        
        System.out.println("Eingeben vom Name");
        kunde.setName(super.scanner.next());

        System.out.println("Eingeben vom Vorname");
        kunde.setPrename(super.scanner.next());

        var editedCustomer = super.bookStore.editCustomer(kunde);

        System.out.println("Kunde mit der ID" + editedCustomer.getCustomerId() + " wurde erfolgreich bearbeitet.");
    }

}
