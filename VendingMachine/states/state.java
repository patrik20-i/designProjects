package VendingMachine.states;

import VendingMachine.VendingMachine;
import VendingMachine.Coin;

public abstract class state {
    VendingMachine machine;

    public state(VendingMachine machine){
        this.machine = machine;
    }

    //what all should a vending machine state can do
    public abstract void insertCoin(Coin coin);
    public abstract void selecItem(String code);
    public abstract void dispense();
    public abstract void refund();
}
