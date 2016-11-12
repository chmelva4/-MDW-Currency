/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdw_currency_converter;

import java.rmi.Naming;
import java.util.Scanner;

/**
 *
 * @author chmelva4
 */
public class CurrencyClient {
    
    public static void main(String[] args) throws Exception{
        ICurrencyConverter client = (ICurrencyConverter)Naming.lookup("//localhost/CurConv");
        System.out.println("Welcome to currency converter possible values are eur, usd, gbp");
        Scanner scanner = new Scanner(System.in);
        
        while (true){
            System.out.println("Please enter from to amnount");
            String input = scanner.nextLine();
            String[] sp = input.split(" ");
            
            CurrencyEnum from, to;
            double amount;
            try {
                from = CurrencyEnum.valueOf(sp[0].trim().toUpperCase());
                to = CurrencyEnum.valueOf(sp[1].trim().toUpperCase());
                amount = Double.parseDouble(sp[2].trim());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                continue;
            }
            
            System.out.println(client.convertTo(from, to, amount));                        
        }
        
    }
    
    
}
