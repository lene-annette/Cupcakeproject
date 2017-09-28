package cupcakeproject;

import datasource.DBConnector;
import entities.Bottom;
import entities.Top;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author PC
 */
public class ShoppingCart {
    public Bottom selectBottom(String bottom) throws SQLException, ClassNotFoundException {
        Bottom cakeBottom = null;
        try {
            String SQLString = "SELECT * "
                    + "FROM bottom "
                    + "WHERE bottom_type = ?";
            Connection con = DBConnector.connection();
            PreparedStatement getBottom = null;
            ResultSet rs = null;
            con.setAutoCommit(false);
            getBottom = con.prepareStatement(SQLString);

            getBottom.setString(1, bottom);
            rs = getBottom.executeQuery();
            con.commit();

            if (rs.next()) {
                cakeBottom = new Bottom(rs.getString("bottom_type"), rs.getInt("price"));
            }
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Fail in ShoppingCart - selectBottom");
            System.out.println(e.getMessage());
        }

        return cakeBottom;
    }

    public Top SelectTop(String top) throws SQLException, ClassNotFoundException {
        Top cakeTop = null;
        try {
            String SQLString = "SELECT * "
                    + "FROM top "
                    + "WHERE top_type = ?";
            Connection con = DBConnector.connection();
            PreparedStatement getTop = null;
            ResultSet rs = null;
            con.setAutoCommit(false);
            getTop = con.prepareStatement(SQLString);

            getTop.setString(1, top);
            rs = getTop.executeQuery();
            con.commit();

            if (rs.next()) {
                cakeTop = new Top(rs.getString("top_type"), rs.getInt("price"));
            }
            con.setAutoCommit(true);

        } catch (SQLException e) {
            System.out.println("Fail in ShoppingCart - selectTop");
            System.out.println(e.getMessage());
        }
        return cakeTop;

    }
}
