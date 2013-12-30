/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package IDS_MAIN;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Geezer
 */
class javaconnect {

    Connection conn= null;
    Connection conn1= null;
    static Connection connecrDb() throws SQLException, ClassNotFoundException {
    String driver = "org.gjt.mm.mysql.Driver";
    String url = "jdbc:mysql://localhost/IDS";
    String url2 = "jdbc:mysql://localhost/idsrule";
    String username = "root";
    String password = "";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    Connection conn1 =DriverManager.getConnection(url2, username, password);
    return conn;
    //return conn1;
    }
    
    static Connection connectDb() throws SQLException, ClassNotFoundException {
    String driver = "org.gjt.mm.mysql.Driver";
    String url = "jdbc:mysql://localhost/IDS";
    String url2 = "jdbc:mysql://localhost/idsrule";
    String username = "root";
    String password = "";

    Class.forName(driver);
    Connection conn = DriverManager.getConnection(url, username, password);
    Connection conn1 =DriverManager.getConnection(url2, username, password);
    //return conn;
    return conn1;
    }
    
}
