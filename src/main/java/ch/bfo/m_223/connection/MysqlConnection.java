package ch.bfo.m_223.connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.Scanner;

import org.apache.ibatis.jdbc.ScriptRunner;

public class MysqlConnection {
  final private String[] requiredTables = new String[] {
    "book", "customer", "order", "genere", "author", "publisher"
  };
  final private String DB_USER = "root";
  final private String DB_PASSWORD = "root";
  private Statement statement = null;
  private Connection connection = null;
  private Scanner scanner = new Scanner(System.in);
  
  public MysqlConnection() {
    this.establishConnection();
    this.checkDatabaseSetup();
  }
  
  public Statement getStatment() {
    return statement;
  }
  
  private void establishConnection() {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(
        "jdbc:mysql://mysql:3306", // docker hostname is mysql
        DB_USER, DB_PASSWORD
      );
      statement = connection.createStatement();
      
      statement.execute("CREATE DATABASE IF NOT EXISTS book_store");
      statement.execute("USE book_store");
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
  
  private void checkDatabaseSetup() {
    try {
      DatabaseMetaData meta = connection.getMetaData();
      for (String tableName : requiredTables) {
        ResultSet tables = meta.getTables(null, null, tableName, new String[] {"TABLE"});
        if (!tables.next()) {
          System.out.println("Tabelle " + tableName + " existiert nicht");
          System.out.println("Datenbank zürucksetzen? Dabei verlieren Sie alle Daten! [Y/n]");
          String answer = scanner.nextLine();
          if (answer.equals("Y")) {
            this.resetDatabase();
          }
        }
      }
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
  
  private void resetDatabase() {
    ScriptRunner sr = new ScriptRunner(connection);
    try {
      Reader reader = new BufferedReader(
        new FileReader("src/main/resources/scripts/book_store.sql")
      );
      sr.runScript(reader);
      System.out.println("Datenbank zurückgesetzt");
    } catch (Exception exception) {
      System.out.println(exception);
    }
  }
}
