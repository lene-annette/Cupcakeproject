/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datasource;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
public class UserDBMapper {

    public static List<User> getAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM users;";
            Connection con = DBConnector.connection();
            ResultSet rs = con.createStatement().executeQuery(SQL);
            while (rs.next()) {
                User u = new User();
                u.setName(rs.getString("u_name"));
                u.setPassword(rs.getString("psw"));
                u.setBalance(rs.getInt("balance"));
                u.setEmail(rs.getString("email"));
                users.add(u);
            }
            rs.close();
            con.close();
        } catch (Exception ex) {
            Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return users;
    }

    public static User getUser1(String uname, String psw) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String SQL = "SELECT * FROM users WHERE u_name= '?' and psw= '?';";
        User user = new User();

        try {
            con = DBConnector.connection();
            ps = con.prepareStatement(SQL);

            ps.setString(1, uname);
            ps.setString(2, psw);
            rs = ps.executeQuery(SQL);
            if (rs.next()) {
                user.setName(rs.getString("u_name"));
                user.setPassword(rs.getString("psw"));
                user.setBalance(rs.getInt("balance"));
                user.setEmail(rs.getString("email"));
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            ps.close();
            con.close();
        }
        return user;

    }
    
    public static User getUser(String name, String password)throws SQLException, ClassNotFoundException{
        Connection con = null;
        String SQL = "SELECT * FROM users WHERE u_name='"+ name +"' AND psw='"+ password +"';";
        ResultSet rs = null;
        User user = new User();
        try{
            con = DBConnector.connection();
            rs = con.createStatement().executeQuery(SQL);
            while(rs.next()){
                user.setName(rs.getString("u_name"));
                user.setPassword(rs.getString("psw"));
                user.setBalance(rs.getInt("balance"));
                user.setEmail(rs.getString("email"));
            }
            rs.close();
            con.close();
        }catch(Exception ex){
            Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;       
        
    }

    public static void createUser(User user) throws SQLException, ClassNotFoundException {
        try {
            String SQL = "insert into users values('?','?',?,'?');";
            Connection con = DBConnector.connection();
            PreparedStatement ps = con.prepareStatement(SQL);
            
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getBalance());
            ps.setString(4, user.getEmail());
            
            ps.executeUpdate(SQL);
        } catch (Exception ex) {
            Logger.getLogger(UserDBMapper.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
