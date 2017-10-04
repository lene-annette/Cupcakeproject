/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import entities.LineItem;
import entities.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lene_
 */
public class InvoiceMapper {

    public static int registerOrder(User user) {
        int id = -1;
        Connection con = null;
        Statement stm = null;
        ResultSet rs = null;

        String cusname = user.getName();
        LocalDateTime date = LocalDateTime.now();
        String[] str = date.toString().split("T");
        String inputdate = str[0];

        String sql = "INSERT INTO orders(odate,cus_name) VALUES('" + inputdate + "','" + cusname + "');";
        try {
            con = DBConnector.connection();
            stm = con.createStatement();
            con.createStatement().executeUpdate(sql);

            rs = stm.executeQuery("SELECT LAST_INSERT_ID()");
            if (rs.next()) {
                id = rs.getInt(1);

                rs.close();
            }

            stm.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }

    public static void registerDetails(int id, List<LineItem> list) {
        Connection con = null;
        String sql = "";
        try {
            con = DBConnector.connection();
            for(int i = 0; i < list.size();i++){
                int lineno = i+1;
                String btype = list.get(i).getBot().getType();
                String ttype = list.get(i).getTop().getType();
                int qty = list.get(i).getQuantity();
                int price = list.get(i).getTotalPrice();
                
                sql = "INSERT INTO odetails VALUES("+ id +",'"+ btype +"','"+ ttype +"',"+ qty +","+ price +","+ lineno +");";
                con.createStatement().executeUpdate(sql);
            }
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
