/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdw_currency_converter;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author chmelva4
 */
public class CurrencyServer extends UnicastRemoteObject implements ICurrencyConverter{
    
    private static final long serialVersionUID = 1L;
    
    private ArrayList<ArrayList<Double>> courses;
 
    protected CurrencyServer() throws RemoteException {
        super();
        courses = new ArrayList<>();
        courses.add(new ArrayList<>(Arrays.asList(1d, 1.08565d, 0.86149024d)));
        courses.add(new ArrayList<>(Arrays.asList(0.921107171d, 1d, 0.793524837)));
        courses.add(new ArrayList<>(Arrays.asList(1.16077926d,1.2602d, 1d)));
        
    }
 
    public static void main(String[] args) {
        try {
            /*
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
            */
            LocateRegistry.createRegistry(1099);
 
            CurrencyServer server = new CurrencyServer();
            Naming.rebind("//0.0.0.0/CurConv", server);
 
            System.out.println("Server started...");
 
        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
 
    }

    @Override
    public double convertTo(CurrencyEnum from, CurrencyEnum to, double amount) throws RemoteException {
        return amount*courses.get(from.ordinal()).get(to.ordinal());
    }

    
}
