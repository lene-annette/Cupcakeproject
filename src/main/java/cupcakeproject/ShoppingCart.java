package cupcakeproject;

import entities.LineItem;
import java.util.ArrayList;
import java.util.List;

/**
 * @author PC
 */
public class ShoppingCart {
    private List<LineItem> listOfItems;

    public ShoppingCart() {
        listOfItems = new ArrayList<>();
        
    }

    public List<LineItem> getListOfItems() {
        return listOfItems;
    }
        public void addItem(LineItem item) {
            listOfItems.add(item);
           
}
    }   
