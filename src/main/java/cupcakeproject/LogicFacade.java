/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cupcakeproject;

import datasource.CupcakeMapper;
import datasource.InvoiceMapper;
import entities.User;
import entities.Bottom;
import datasource.UserDBMapper;
import entities.LineItem;
import entities.Top;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lene_
 */
public class LogicFacade {

    public static User createUser1(String name, String password, int balance, String email) {
        User user = new User(name, password, balance, email);
        return user;
    }

    public static User createUser(String name, String password, int balance, String email){// throws SQLException, ClassNotFoundException {
        return UserDBMapper.createUser(name, password, balance, email);
    }

    public static User login1(String name, String password) { //TODO: skal kontakte databasen
        User user = new User("Lene", "1234", 100, "lene@mail.dk");
        if (name.equals(user.getName()) && password.equals(user.getPassword())) {
            return user;
        } else {
            return null;
        }
    }

    public static User login(String name, String password) {
        User user = UserDBMapper.getUser(name, password);
        return user;
    }

    public static List<Bottom> getBottoms1() {
        List<Bottom> bottoms = new ArrayList<>();

        Bottom b1 = new Bottom("Chocolate", 5);
        Bottom b2 = new Bottom("Vanilla", 5);
        Bottom b3 = new Bottom("Pistacio", 6);

        bottoms.add(b1);
        bottoms.add(b2);
        bottoms.add(b3);

        return bottoms;
    }

    public static List<Bottom> getBottoms() {
        List<Bottom> bottoms = new ArrayList<>();
        try {
            bottoms = CupcakeMapper.getAllBottoms();
        } catch (Exception e) {
            bottoms = null;
        }

        return bottoms;
    }

    public static List<Top> getTops() {
        List<Top> tops = new ArrayList<>();
        try {
            tops = CupcakeMapper.getAllTops();
        } catch (Exception e) {
            tops = null;
        }
        return tops;
    }
    
    public static void checkOut(ShoppingCart sc, User user, int spend){
        List<LineItem> items = sc.getListOfItems();
        int id = InvoiceMapper.registerOrder(user);
        InvoiceMapper.registerDetails(id, items);
        UserDBMapper.withDrawBalance(user, spend);
    }

}
