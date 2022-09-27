package ch.bfo.m_223.interaction;

import ch.bfo.m_223.contract.IBookStore;
import ch.bfo.m_223.interaction.action.*;
import ch.bfo.m_223.statments.BookStoreStatments;

import java.util.Scanner;

public class Cmd {
    private static Scanner scanner;
    private static IBookStore bookStore;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        System.out.println("Willkommen im Büchershop");

        ActionsEnum befehl;

        //ToDo: map to effective implementation
        bookStore = new BookStoreStatments();


        do {
            printKeywords();
            befehl = getUserinputAsActionsEnum(scanner.next());
            if(befehl ==null){
                continue;
            }

            Action action = getActionObject(befehl);

            action.executeAction();
        }
        while (befehl != ActionsEnum.EXIT);
    }

    private static Action getActionObject(ActionsEnum befehl) {
        switch (befehl){
            case ORDER:
                return new OrderAction(scanner, bookStore);
            case SEND:
                return new SendAction(scanner, bookStore);
            case DELETEBOOK:
                return new DeleteBookAction(scanner, bookStore);
            case DELETECUSTOMER:
                return new DeleteCustomerAction(scanner, bookStore);
            case CREATEBOOK:
                return new CreateBookAction(scanner, bookStore);
            case CREATECUSTOMER:
                return new CreateCustomerAction(scanner, bookStore);
            case EDITBOOK:
                return new EditBookAction(scanner, bookStore);
            case EDITCUSTOMER:
                return new EditCustomerAction(scanner, bookStore);
            case SEARCHBOOK:
                return new SearchBookAction(scanner, bookStore);
            default:
                throw new RuntimeException("No implementation for " + befehl + " found");
        }
    }


    private static ActionsEnum getUserinputAsActionsEnum(String userInput){
        ActionsEnum action = null;
        try {
            action = ActionsEnum.valueOf(userInput.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println();
            System.err.println("Dieser Befehl existiert nicht. Bitte überprüfen Sie ihre Eingabe!");
        }
        return action;
    }
    private static void printKeywords() {
        System.out.println();
        System.out.println("Was möchten Sie machen? ");
        System.out.println("Folgende befehle sind vorhanden:");
        for (ActionsEnum action : ActionsEnum.values()) {
            System.out.println("\t" + action);
        }
    }
}
