package VendingMachine.states;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class ItemSelectedState extends state {
    public ItemSelectedState(VendingMachine machine){
        super(machine);
    }
    @Override
    public void insertCoin(Coin coin){
        machine.addBalance(coin.getValue());
        int price = machine.getSelectedItem().getPrice();
        if(machine.getBalance()>price){
           System.out.println("sufficient money");
           machine.setState(new HasMoneyState(machine));
        }
    }

    @Override
    public void selecItem(String code){
        System.out.println("already selected");
    }
    
    @Override
    public void dispense(){
        System.out.println("enter money first");
    }
    
    @Override
    public void refund(){
        machine.reset();
        machine.setState(new IdleState(machine));
    }
}
