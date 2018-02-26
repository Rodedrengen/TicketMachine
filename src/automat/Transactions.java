/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automat;

import java.util.Date;

/**
 *
 * @author simon
 */
public class Transactions {
    
    private Date dato; 
    private String action; 
    private int amount;
    public static int amountOfTransactions; 
    
    public Transactions(String ac){
        dato = new Date(); 
        action = ac; 
        amount = 0;
        amountOfTransactions++;
    }
    
    public Transactions(String ac, int a){
        dato = new Date(); 
        action = ac; 
        amount = a; 
        amountOfTransactions++;
    }
    public String toString(){
        if (amount > 0){
            return dato + " " + action + " " + amount; 
        }else{
            return dato + " " + action; 
        }
    }
    public Date getDate(){
        Date date = dato;
        return date;
    }
    public int getAmount(){
        int a = amount;
        return a; 
    }
}
