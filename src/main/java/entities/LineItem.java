/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author lene_
 */
public class LineItem {
    
    private Bottom bot;
    private Top top;
    private int quantity;
    private int totalPrice;

    public LineItem(Bottom bot, Top top, int quantity) {
        this.bot = bot;
        this.top = top;
        this.quantity = quantity;
       // this.invoice_id = invoice_id;
        this.totalPrice = (this.bot.getPrice() + this.top.getPrice()) * this.quantity;
    }

    public LineItem() {
        bot = null;
        top = null;
        quantity = 0;
        totalPrice = 0;
    }

    public Bottom getBot() {
        return bot;
    }

    public void setBot(Bottom bot) {
        this.bot = bot;
    }

    public Top getTop() {
        return top;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        if(totalPrice == 0 && quantity != 0 && bot != null && top != null){
            totalPrice = (bot.getPrice() + top.getPrice()) * quantity;
        }
        return totalPrice;
    }
    
    
    
    
    
    
    
}
