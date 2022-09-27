package ch.bfo.m_223.contract;

import java.util.List;

public interface IBookStore {

    /***
     * Bestellung eines Buches
     * @param customerId Id des Kunden der die Bestellung ausgeführt hat
     * @param bookId Id des Buches die der Kunde bestellt hat
     * @return id der in der Datenbank erstellten Bestellung
     */
    int order(int customerId, int bookId);

    /***
     * Kunde bearbeiten
     * @param editedCustomer Kompletter Kunde mit den bearbeiteten Attributen
     * @return bearbeiteter Kunde
     */
    CustomerDto editCustomer(CustomerDto editedCustomer);

    /***
     * Kunde erstellen
     * @param newCustomer Kompletter Kunde
     * @return neuer Kunde inkl. DB Id
     */
    CustomerDto createCustomer(CustomerDto newCustomer);

    /***
     * Kunde löschen
     * @param customerId Id des zu löschenden Kunden
     */
    void deleteCustomer(int customerId);


    /***
     * Buch bearbeiten
     * @param editedBook Komplettes Buch mit den bearbeiteten Attributen
     * @return bearbeitetes Buch
     */
    BookDto editBook(BookDto editedBook);

    /***
     * Buch erstellen
     * @param newBook Komplettes neues Buch
     * @return neu erstelltes BUch inkl. DB Id
     */
    BookDto createBook(BookDto newBook);

    /***
     * Buch löschen
     * @param bookId Id des zu löschenden Buches
     */
    void deleteBook(int bookId);


    /***
     * Bestellung als "versendet" markieren
     * @param orderId Id der betroffenen Bestellung
     */
    void sendOrder(int orderId);

    /***
     * Suche nach Büchern
     * @param searchstring Suchtext nachdem die Bücher gesucht werden
     * @return Liste der gefundenen Bücher
     */
    List<BookDto> searchBook(String searchstring);

}