/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lene_
 */
public class DBConnector {



    private static String url = "jdbc:mysql://207.154.247.212:3306/cupcakeproject";
    private static String username = "lsko";

    private static String password = "LeneSkov";

    public static Connection connection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(url, username, password);
        return connection;
    }
}
