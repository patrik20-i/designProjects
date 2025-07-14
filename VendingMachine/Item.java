package VendingMachine;

public class Item {
    int id;
    String name;
    int price;

    public Item(int id, String name, int price){
        this.id = id;
        this.price = price;
        this.name = name;
    }


    //getters 
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }

}
