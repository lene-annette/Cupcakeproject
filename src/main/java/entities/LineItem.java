/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Cupcake;

/**
 *
 * @author lene_
 */
public class LineItem {
    
    private Cupcake cupcake;
    private int quantity;
    private int invoice_id;
    private int totalPrice;

    public LineItem(Cupcake cupcake, int quantity, int invoice_id) {
        this.cupcake = cupcake;
        this.quantity = quantity;
        this.invoice_id = invoice_id;
        this.totalPrice = this.cupcake.getPrice() * this.quantity;
    }

    public LineItem() {
        cupcake = null;
        quantity = 0;
        invoice_id = 0;
        totalPrice = 0;
    }

    public Cupcake getCupcake() {
        return cupcake;
    }

    public void setCupcake(Cupcake cupcake) {
        this.cupcake = cupcake;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getTotalPrice() {
        if(totalPrice == 0 && quantity != 0 && cupcake != null){
            totalPrice = cupcake.getPrice() * quantity;
        }
        return totalPrice;
    }
    
    
    
    
    
    
    
}
