package ch.bfo.m_223.interaction.action;

import ch.bfo.m_223.contract.IBookStore;

import java.util.Scanner;

/**
 * Basisklasse für die einzelnen Useraktionen
 */
public abstract class Action {
    protected final IBookStore bookStore;
    protected final Scanner scanner;

    public Action(Scanner scanner, IBookStore bookStore) {
        this.scanner = scanner;
        this.bookStore = bookStore;
    }

    /**
     * Methode die den Actionablauf implementiert.
     * Parameter lesen und mit Bookstore interagieren.
     */
    public abstract void executeAction();
}
