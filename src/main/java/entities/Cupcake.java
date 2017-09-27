/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import entities.Bottom;

/**
 *
 * @author lene_
 */
public class Cupcake {
    
    private Bottom bottom;
    private Top top;
    private int price;

    public Cupcake(Bottom bottom, Top top) {
        this.bottom = bottom;
        this.top = top;
        this.price = this.bottom.getPrice() + this.top.getPrice();
    }

    public Cupcake() {
        this.bottom = null;
        this.top = null;
        this.price = 0;
    }

    public Bottom getBottom() {
        return bottom;
    }

    public void setBottom(Bottom bottom) {
        this.bottom = bottom;
    }

    public Top getTop() {
        return top;
    }

    public void setTop(Top top) {
        this.top = top;
    }

    public int getPrice() {
        if(price == 0 && bottom != null && top != null){
            price = bottom.getPrice() + top.getPrice();
        }
        return price;
    }
    
    
    
}
