/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdw_currency_converter;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author chmelva4
 */
public interface ICurrencyConverter extends Remote{
    
    double convertTo(CurrencyEnum from, CurrencyEnum to, double amount) throws RemoteException;
    
}
