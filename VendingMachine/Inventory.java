package VendingMachine;

import java.util.HashMap;

public class Inventory {
    //map of items with code to name mapping
    //map of items with code to quantity mapping
    private HashMap<String, Item> itemCodes;
    private HashMap<String, Integer> itemQuantity;

    public Inventory(){
        itemCodes = new HashMap<>();
        itemQuantity = new HashMap<>();
    }

    public void addItem(String code, Item item, Integer quantity){
        itemCodes.put(code, item);
        itemQuantity.put(code,quantity);
    }

    public Item getItem(String code){
        return itemCodes.get(code);
    }

    public boolean isAvailable(String code){
        return itemQuantity.getOrDefault(code, 0)>0;
    }

    public void reduceStock(String code){
        itemQuantity.put(code,itemQuantity.get(code)-1);
    }

    public HashMap<String, Integer> getInventory(){
        return itemQuantity;
    }
}
