/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectpackage;

import java.util.ArrayList;

/**
 *
 * @author Jared - PC
 */
public class ParkingLot 
{
    private final Capacities capacities;
    private final ArrayList<Gate> gates;
    private final ArrayList<Car> carsInLot;
    private final Prices prices;
    
    private double moneyMade;
    public ParkingLot(Prices p)
    {
        prices = p;
        capacities = new Capacities();
        moneyMade = 0;
        gates = new ArrayList<>();
        carsInLot = new ArrayList<>();
        gates.add(new EntryGate(prices));
        gates.add(new ExitGate());
        moneyMade = 0;
    }
    
    public int currentCapacity()
    {
        return capacities.currCapacity;
    }
    
    public boolean findCar(Car c)
    {
        for(Car car : carsInLot)
        {
            if(car.equals(c))
                return true;
        }
        return false;
    }
    
    public boolean carArrived(Car c)
    {
        if(gates.get(0).carAtGate(c, capacities))
        {
            carsInLot.add(c);
            return true;
        }
        return false;
    }
    
    public boolean carLeft()
    {
        if(carsInLot.isEmpty())
            return false;
        Car c = carsInLot.remove(0);
        gates.get(1).carAtGate(c, capacities);
        return true;
    }
    
    public void close()
    {
        ExitGate temp = (ExitGate)gates.get(1);
        moneyMade += temp.sendMoney();
        totalIncome();
    }
    
    public double currentOutstandingIncome()
    {
        double ret = 0;
        for(Car c : carsInLot)
        {
            ret += c.giveTicket().getCostOfTicket();
        }
        return ret;
    }
    
    public void totalIncome()
    {
        String s = String.format("%.2f", moneyMade);
        System.out.println("Parking lot has made $" + s + ".");
    }
}
