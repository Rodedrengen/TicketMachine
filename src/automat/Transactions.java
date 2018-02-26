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
    
    private String dato; 
    private String action; 
    private int amount; 
    
    public Transactions(String d, String ac){
        dato = d; 
        action = ac; 
        amount = 0; 
    }
    
    public Transactions(String d, String ac, int a){
        dato = d; 
        action = ac; 
        amount = a; 
    }
    
}
