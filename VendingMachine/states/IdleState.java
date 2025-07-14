package VendingMachine.states;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class IdleState extends state{
    public IdleState(VendingMachine machine){
        super(machine);
    }
    @Override
    public void insertCoin(Coin coin){
        System.out.println("please select a item first");
    }

    @Override
    public void selecItem(String code){
        if(!machine.getInventory().isAvailable(code)){
            System.out.println("item not available");
            return;
        }
        machine.selectItem(code);
        machine.setState(new ItemSelectedState(machine));
        System.out.println("item is selected");
    }
    
    @Override
    public void dispense(){
        System.out.println("no item selected");

    }
    
    @Override
    public void refund(){
        System.out.println("no money to refund");
    }
    
}
