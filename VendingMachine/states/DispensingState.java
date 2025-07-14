package VendingMachine.states;
import VendingMachine.Coin;
import VendingMachine.VendingMachine;
public class DispensingState extends state {
    public DispensingState(VendingMachine machine){
        super(machine);
    }

    @Override
    public void insertCoin(Coin coin) {
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void selecItem(String code) {
        throw new UnsupportedOperationException("Unimplemented method 'selecItem'");
    }

    @Override
    public void dispense() {
        //already triggered by hasmoney state
    }

    @Override
    public void refund() {
        throw new UnsupportedOperationException("Unimplemented method 'refund'");
    }

}
