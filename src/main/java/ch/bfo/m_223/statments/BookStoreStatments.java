package ch.bfo.m_223.statments;

import ch.bfo.m_223.connection.MysqlConnection;
import ch.bfo.m_223.contract.BookDto;
import ch.bfo.m_223.contract.CustomerDto;
import ch.bfo.m_223.contract.IBookStore;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookStoreStatments implements IBookStore {
    private MysqlConnection mysql = new MysqlConnection();
    private Statement statment = mysql.getStatment();
    private Connection connection = mysql.getConnection();
    
    @Override
    public int order(int customerId, int bookId) {
        try {
            String sql = "INSERT INTO `order`(customer_id, book_id) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setInt(2, customerId);
            ps.setInt(1, bookId);
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                return rs.getInt(1);
            }
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public CustomerDto editCustomer(CustomerDto editedCustomer) {
        CustomerDto customer = new CustomerDto();
        try {
            String sql = """
                UPDATE customer SET
                name = ?,
                prename = ?
                WHERE id = ?
                """;
            PreparedStatement ps = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, editedCustomer.getName());
            ps.setString(2, editedCustomer.getPrename());
            ps.setInt(3, editedCustomer.getCustomerId());
            ps.executeUpdate();
            return editedCustomer;
        } catch (SQLException e) {
            e.printStackTrace();
            return customer;
        }
    }

    @Override
    public CustomerDto createCustomer(CustomerDto newCustomer) {
        CustomerDto customer = new CustomerDto();
        try {
            String sql = "INSERT INTO `customer`(name, prename) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, newCustomer.getName());
            ps.setString(2, newCustomer.getPrename());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()){
                customer.setCustomerId(rs.getInt(1));
            }
            rs = statment.executeQuery("SELECT * FROM `customer` WHERE `id`=" + customer.getCustomerId());
            if(rs.next()){
                customer.setName(rs.getString("name"));
                customer.setPrename(rs.getString("prename"));
            }
            return customer;
        } catch (SQLException e) {
            e.printStackTrace();
            return customer;
        }
    }

    @Override
    public void deleteCustomer(int customerId) {
        try {
            String sql = "DELETE FROM `customer` WHERE id = " + customerId;
            statment.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public BookDto editBook(BookDto editedBook) {
        BookDto book = new BookDto();
        try {
            String sql = """
                UPDATE book SET
                title = ?,
                author = ?,
                publisher = ?,
                genre = ? 
                WHERE id = ?
                """;
            PreparedStatement ps = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, editedBook.getTitel());
            ps.setString(2, editedBook.getAuthor());
            ps.setString(3, editedBook.getPublisher());
            ps.setString(4, editedBook.getGenre());
            ps.setInt(5, editedBook.getBookId());
            ps.executeUpdate();
            return editedBook;
        } catch (SQLException e) {
            e.printStackTrace();
            return book;
        }
    }

    @Override
    public BookDto createBook(BookDto newBook) {
        BookDto book = new BookDto();
        try {
            String sql = "INSERT INTO `book`(title, author, genre, publisher) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(
                sql,
                Statement.RETURN_GENERATED_KEYS
            );
            ps.setString(1, newBook.getTitel());
            ps.setString(2, newBook.getAuthor());
            ps.setString(3, newBook.getGenre());
            ps.setString(4, newBook.getPublisher());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            if (rs.next()) {
                book.setBookId(rs.getInt(1));
            }
            rs = statment.executeQuery("SELECT * FROM `book` WHERE `id`=" + book.getBookId());
            if (rs.next()) {
                book.setTitel(rs.getString("title"));
                book.setGenre(rs.getString("genre"));
                book.setPublisher(rs.getString("publisher"));
                book.setAuthor(rs.getString("author"));
            }
            return book;
        } catch (SQLException e) {
            e.printStackTrace();
            return book;
        }
    }

    @Override
    public void deleteBook(int bookId) {
        try {
            String sql = "DELETE FROM `book` WHERE id = " + bookId;
            statment.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendOrder(int orderId) {
        try {
            String sql = "UPDATE `order` SET isDelivered = true WHERE id =" + orderId;
            statment.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<BookDto> searchBook(String searchstring) {
        ArrayList<BookDto> results = new ArrayList<BookDto>();
        try {
            String sql = "SELECT * FROM `book` WHERE `title` LIKE '%" + searchstring + "%'";
            ResultSet rs = statment.executeQuery(sql);
            while (rs.next()) {
                BookDto book = new BookDto();
                book.setBookId(rs.getInt("id"));
                book.setTitel(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setPublisher(rs.getString("publisher"));
                book.setGenre(rs.getString("genre"));
                results.add(book);
            }
            return results;
        } catch (SQLException e) {
            e.printStackTrace();
            return results;
        }
    }
}
