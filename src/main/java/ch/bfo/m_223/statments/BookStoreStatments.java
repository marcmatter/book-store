package ch.bfo.m_223.statments;

import ch.bfo.m_223.connection.MysqlConnection;
import ch.bfo.m_223.contract.BookDto;
import ch.bfo.m_223.contract.CustomerDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.sql.Statement;

public class BookStoreStatments implements IBookStore {
    private MysqlConnection connection = new MysqlConnection();
    private Statement db = connection.getStatment();
    
    private Random random = new Random();
    @Override
    public int order(int customerId, int bookId) {
        return random.nextInt();
    }

    @Override
    public CustomerDto editCustomer(CustomerDto editedCustomer) {
        return editedCustomer;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto newCustomer) {
        newCustomer.setCustomerId(random.nextInt());
        return newCustomer;
    }

    @Override
    public void deleteCustomer(int customerId) {

    }

    @Override
    public BookDto editBook(BookDto editedBook) {
        return editedBook;
    }

    @Override
    public BookDto createBook(BookDto newBook) {
        newBook.setBookId(random.nextInt());
        return newBook;
    }

    @Override
    public void deleteBook(int bookId) {

    }

    @Override
    public void sendOrder(int orderId) {

    }

    @Override
    public List<BookDto> searchBook(String searchstring) {
        ArrayList<BookDto> results = new ArrayList<BookDto>();
        BookDto book = new BookDto();
        book.setBookId(random.nextInt());
        book.setTitel("Der Schaffner");
        book.setAuthor("Morton Rhue");
        book.setPublisher("Moon Notes");
        book.setGenre("undefined");

        results.add(book);

        return results;
    }
}
