package VendingMachine.states;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class HasMoneyState extends state {
    public HasMoneyState(VendingMachine machine){
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already received full amount.");
    }

    public void selectItem(String code) {
        System.out.println("Item already selected.");
    }

    @Override
    public void dispense() {
        machine.setState(new DispensingState(machine));
        machine.dispenseItem();
    }

    @Override
    public void refund() {
        machine.refundBalance();
        machine.reset();
        machine.setState(new IdleState(machine));
    }

    @Override
    public void selecItem(String code) {
        throw new UnsupportedOperationException("Unimplemented method 'selecItem'");
    }
}
