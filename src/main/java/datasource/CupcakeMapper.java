/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import entities.Bottom;
import entities.Top;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lene_
 */
public class CupcakeMapper {
    
    public static List<Bottom> getAllBottoms() throws SQLException, ClassNotFoundException{
        List<Bottom> bottoms = new ArrayList<>();
        try{
            String SQL = "SELECT * FROM bottom;";
            Connection con = DBConnector.connection();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while(rs.next()){
                Bottom b = new Bottom();
                b.setType(rs.getString("bottom_type"));
                b.setPrice(rs.getInt("price"));
                bottoms.add(b);
            }
            rs.close();
            con.close();
        }catch (Exception ex) {
            Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bottoms;
    }
    
        public static List<Top> getAllTops() throws SQLException, ClassNotFoundException{
        List<Top> tops = new ArrayList<>();
        try{
            String SQL = "SELECT * FROM top;";
            Connection con = DBConnector.connection();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while(rs.next()){
                Top t = new Top();
                t.setType(rs.getString("top_type"));
                t.setPrice(rs.getInt("price"));
                tops.add(t);
            }
            rs.close();
            con.close();
        }catch (Exception ex) {
            Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tops;
    }
    
}
