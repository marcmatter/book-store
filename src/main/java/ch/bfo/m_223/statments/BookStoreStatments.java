package ch.bfo.m_223.statments;

import ch.bfo.m_223.connection.MysqlConnection;
import ch.bfo.m_223.contract.BookDto;
import ch.bfo.m_223.contract.CustomerDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class BookStoreStatments implements IBookStore {
    private MysqlConnection mysql = new MysqlConnection();
    private Statement statment = mysql.getStatment();
    private Connection connection = mysql.getConnection();
    
    private Random random = new Random();
    @Override
    public int order(int customerId, int bookId) {
        try {
            String sql = "INSERT INTO `order`(customer_id, book_id) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(2, customerId);
            ps.setInt(1, bookId);
            int order_id = ps.executeUpdate();
            return order_id;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override
    public CustomerDto editCustomer(CustomerDto editedCustomer) {
        return editedCustomer;
    }

    @Override
    public CustomerDto createCustomer(CustomerDto newCustomer) {
        try {
            String sql = "INSERT INTO `customer`(name, prename) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newCustomer.getName());
            ps.setString(2, newCustomer.getPrename());
            int customer_id = ps.executeUpdate();
            newCustomer.setCustomerId(customer_id);
            return newCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
            return newCustomer;
        }
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
        try {
            String sql = "INSERT INTO `book`(title, author_id, genere_id, publisher_id) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newBook.getTitel());
            ps.setString(2, newBook.getAuthor());
            ps.setString(3, newBook.getGenre());
            ps.setString(4, newBook.getPublisher());
            int book_id = ps.executeUpdate();
            newBook.setBookId(book_id);
            return newBook;
        } catch (SQLException e) {
            e.printStackTrace();
            return newBook;
        }
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
