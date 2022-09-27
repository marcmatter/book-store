package ch.bfo.m_223.connection;

import java.sql.*;

public class MysqlConnection {
  private String DB_USER = "root";
  private String DB_PASSWORD = "root";
  private Statement statement = null;
  
  public MysqlConnection() {
    this.establishConnection();
  }
  
  private void establishConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      Connection connection = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/book_store",
        DB_USER, DB_PASSWORD
      );
      statement = connection.createStatement();
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
  
  public Statement getStatment() {
    return statement;
  }
}
