package VendingMachine;

import VendingMachine.states.*;

public class VendingMachine {
    private final static VendingMachine INSTANCE = new VendingMachine();
    private final Inventory inventory = new Inventory();

    private state currenState;
    private int balance=0;
    private String selectedItem;

    public VendingMachine(){
        currenState = new IdleState(this);
    }

    public static VendingMachine getInstance(){
        return INSTANCE;
    }

    public void insertCoin(Coin coin){
        currenState.insertCoin(coin);
    }

    public Item addItem(String code, String name, int price, int quantity){
        Item item = new Item(quantity, name, price);
        inventory.addItem(code, item, quantity);
        return item;
    }

    public void selectItem(String code){
        currenState.selecItem(code);
    }

    public void dispense(){
        currenState.dispense();
    }
    
    public void dispenseItem(){
        Item item = inventory.getItem(selectedItem);
        if(balance>=item.getPrice()){
            inventory.reduceStock(selectedItem);
            balance-=item.getPrice();
            System.out.println("Dispensed:"+ item.getName());
            if(balance>0){
                refundBalance();
            }
        }

        reset();
        setState(new IdleState(this));

    }

    public void reset(){
        selectedItem = null;
        balance=0;
        return;
    }

    public void setState(state state){
        currenState = state;
    }
    
    public void refundBalance() {
        System.out.println("Refunding: " + balance);
        balance = 0;
    }

    public void addBalance(int value){
        balance+=value;
        return;
    }

    public Item getSelectedItem(){
        return inventory.getItem(selectedItem);
    }

    

    // Getters for states and inventory
    public Inventory getInventory() { return inventory; }
    public int getBalance() { return balance; }


}
